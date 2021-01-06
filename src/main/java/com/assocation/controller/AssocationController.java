package com.assocation.controller;

import com.assocation.domain.Assocation;
import com.assocation.domain.User;
import com.assocation.exception.SysException;
import com.assocation.service.AssocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/assocation")
@SessionAttributes(value = {"userInfo"},types = {User.class})
public class AssocationController {

    private AssocationService assocationService;

    @Autowired
    public void setAssocationService(AssocationService assocationService) {
        this.assocationService = assocationService;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        System.out.println("查询所有社团.");
        ModelAndView mv = new ModelAndView();
        List<Assocation> assocations = assocationService.findAllAsso();
        for(Assocation assocation:assocations)System.out.println(assocation.toString());
        mv.addObject("assocationList",assocations);
        mv.setViewName("assocationList");
        return mv;
    }

    @RequestMapping("/findAssoByMultiCons")
    public ModelAndView findAssoByMultiCons(String assoName, String assoStatus, String assoRank){
        System.out.println("通过社团名+社团状态+社团等级条件组合查询社团.");
        ModelAndView mv = new ModelAndView();
        List<Assocation> assocations = assocationService.findAssoByMultiCons(assoName,assoStatus,assoRank);
        mv.addObject("assocationList",assocations);
        mv.setViewName("assocationList");
        return mv;
    }


    @RequestMapping("/deleteAssocation")
    public String deleteAssocation(@RequestParam("assocationId") String assoId, HttpServletResponse response, ModelMap model) throws Exception{
        System.out.println("通过社团id删除指定社团.");
        User user = (User) model.get("userInfo");
        if("管理员".equals(user.getUserIdentity())){
            try {
                assocationService.deleteAssocation(assoId);
            }catch (Exception e){
                e.printStackTrace();
                throw new SysException("删除社团失败.");
            }
        }else {
            response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
        }
        return "redirect:/assocation/findAll";
    }

    @RequestMapping("/updateAssocation")
    public String updateAssocation(Assocation assocation,HttpServletResponse response,ModelMap model) throws Exception{
        System.out.println("更新社团信息");
        User user = (User) model.get("userInfo");
        System.out.println("user = " + user.toString());
        if("管理员".equals(user.getUserIdentity())){
            try {
                assocationService.updateAssocation(assocation);
            }catch (Exception e){
                e.printStackTrace();
                throw new SysException("更新社团信息失败.");
            }
        }else{
            response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
        }
        return "redirect:/assocation/findAll";
    }
}
