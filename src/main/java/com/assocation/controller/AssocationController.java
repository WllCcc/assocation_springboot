package com.assocation.controller;

import com.assocation.domain.ActivityApproval;
import com.assocation.domain.Assocation;
import com.assocation.domain.User;
import com.assocation.exception.SysException;
import com.assocation.service.AssocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/assocation")
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
        mv.addObject("assocations",assocations);
        mv.setViewName("assocationList");
        return mv;
    }

    @RequestMapping("/findAssoByMultiCons")
    public ModelAndView findAssoByMultiCons(String assoName, String assoStatus, String assoRank){
        System.out.println("通过社团名+社团状态+社团等级条件组合查询社团.");
        ModelAndView mv = new ModelAndView();
        List<Assocation> assocations = assocationService.findAssoByMultiCons(assoName,assoStatus,assoRank);
        mv.addObject("assocations",assocations);
        mv.setViewName("assocationList");
        return mv;
    }

//    @RequestMapping("/addAssocation")
//    public ModelAndView addAssocation(Assocation assocation, HttpServletResponse response,ModelMap model) throws Exception{
//        System.out.println("添加社团.");
//        ModelAndView mv = new ModelAndView();
//        User user = (User)model.get("userInfo");
//        if("ADMIN".equals(user.getUserIdentity())){
//            try {
//                assocationService.addAssocation(assocation);
//                mv.setViewName("assocationList");
//            }catch (Exception e){
//                e.printStackTrace();
//                throw new SysException("添加社团失败.");
//            }
//        }else{
//            response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
//            mv.setViewName("assocationAdd");
//        }
//        return mv;
//    }

    @RequestMapping("/deleteAssocation")
    public String deleteAssocation(String assoId,HttpServletResponse response,ModelMap model) throws Exception{
        System.out.println("通过社团id删除指定社团.");
        User user = (User) model.get("userInfo");
        if("ADMIN".equals(user.getUserIdentity())){
            try {
                assocationService.deleteAssocation(assoId);
            }catch (Exception e){
                e.printStackTrace();
                throw new SysException("删除社团失败.");
            }
        }else {
            response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
        }
        return "redirect:findAll";
    }

    @RequestMapping("/updateAssocation")
    public String updateAssocation(Assocation assocation,HttpServletResponse response,ModelMap model) throws Exception{
        System.out.println("更新社团信息");
        User user = (User) model.get("userInfo");
        if("ADMIN".equals(user.getUserIdentity())){
            try {
                assocationService.updateAssocation(assocation);
            }catch (Exception e){
                e.printStackTrace();
                throw new SysException("更新社团信息失败.");
            }
        }else{
            response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
        }
        return "redirect:findAll";
    }

    @RequestMapping("applyAssoAct")
    public ModelAndView applyAssoAct(ActivityApproval actApproval,HttpServletResponse response,ModelMap model) throws Exception{
        System.out.println("社团活动申请.");
        ModelAndView mv = new ModelAndView();
        User user = (User) model.get("userInfo");

        //升生成活动编号
        String activityId = UUID.randomUUID().toString().replace("-","");
        //通过社团名查询社团编号
        String assoId = assocationService.findAssoIdByName(actApproval.getActivityAssoId());
        //申请日期
        Date applicationDate = new Date(System.currentTimeMillis());
        //申请人编号
        String applyId = user.getUserId();

        actApproval.setActivityId(activityId);
        actApproval.setActivityAssoId(assoId);
        actApproval.setApplicationDate(applicationDate);
        actApproval.setApplyId(applyId);

        try {
            assocationService.applyAssoAct(actApproval);
            response.getWriter().write("<script>alert('您的社团活动申请已提交，请等待管理员审批！')<script>");
            mv.setViewName("assocationList");
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("社团活动申请失败.");
        }
        return mv;
    }
}
