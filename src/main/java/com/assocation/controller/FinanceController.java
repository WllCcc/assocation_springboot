package com.assocation.controller;

import com.assocation.domain.Finance;
import com.assocation.domain.User;
import com.assocation.exception.SysException;
import com.assocation.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/finance")
@SessionAttributes(value = {"userInfo"},types = {User.class})
public class FinanceController {

    private FinanceService financeService;

    @Autowired
    public void setFinanceService(FinanceService financeService) {
        this.financeService = financeService;
    }

    //查询所有社团活动的财务记录
    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        System.out.println("查询所有社团活动的财务记录.");
        ModelAndView mv = new ModelAndView();
        List<Finance> finances = financeService.findAll();
        mv.addObject("financeList",finances);
        mv.setViewName("financeList");
        return mv;
    }

    //通过财务编号+财务类型查询指定财务记录
    @RequestMapping("/findFinanceByMore")
    public ModelAndView findFinanceByMore(String financeId,String financeCategory){
        System.out.println("社团财务编号+财务类型模糊查询.");
        ModelAndView mv = new ModelAndView();
        List<Finance> finances = financeService.findFinanceByMore(financeId,financeCategory);
        mv.addObject("financeList",finances);
        mv.setViewName("financeList");
        return mv;
    }

    //添加财务记录
    @RequestMapping("/addFinance")
    public String addFinance(Finance finance, ModelMap model, HttpServletResponse response) throws Exception{
        System.out.println("添加社团活动财务记录.");
        System.out.println(finance.toString());
        User user = (User) model.get("userInfo");
        System.out.println(user.toString());
        if("管理员".equals(user.getUserIdentity())){
            try {
                String financeId = UUID.randomUUID().toString().replace("-","");
                finance.setFinanceId(financeId);
                financeService.addFinance(finance);
                System.out.println("财务记录添加成功.");
            }catch (Exception e){
                e.printStackTrace();
                throw new SysException("添加社团活动财务记录失败.");
            }
        }else {
            response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
        }
        return "redirect:/finance/findAll";
    }

    //删除财务记录
    @RequestMapping("/deleteFinance")
    public String deleteFinance(@RequestParam(name="financeId") String financeId, ModelMap model, HttpServletResponse response) throws Exception{
        System.out.println("删除社团活动财务记录.");
        System.out.println("financeId = "+financeId);
        User user = (User) model.get("userInfo");
        if("管理员".equals(user.getUserIdentity())){
            try {
                financeService.deleteFinance(financeId);
                System.out.println("删除社团活动财务记录成功.");
            }catch (Exception e){
                e.printStackTrace();
                throw new SysException("删除社团活动财务记录失败.");
            }
        }else {
            response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
        }
        return "redirect:/finance/findAll";
    }

    //更新财务信息
    @RequestMapping("/updateFinance")
    public String updateFinance(Finance finance,ModelMap model,HttpServletResponse response) throws Exception{
        System.out.println("更新社团活动财务记录.");
        User user = (User) model.get("userInfo");
        if("管理员".equals(user.getUserIdentity())){
            try {
                financeService.updateFinance(finance);
                System.out.println("更新社团活动财务信息成功.");
            }catch (Exception e){
                e.printStackTrace();
                throw new SysException("更新社团活动财务记录失败.");
            }
        }else {
            response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
        }
        return "redirect:/finance/findAll";
    }
}
