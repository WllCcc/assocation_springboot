package com.assocation.controller;

import com.assocation.domain.ActivityApproval;
import com.assocation.domain.User;
import com.assocation.exception.SysException;
import com.assocation.service.ActivityApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/activityApproval")
public class ActivityApprovalController {

    private ActivityApprovalService activityApprovalService;

    @Autowired
    public void setActivityApprovalService(ActivityApprovalService activityApprovalService) {
        this.activityApprovalService = activityApprovalService;
    }

    @RequestMapping("applyAssoAct")
    public ModelAndView applyAssoAct(ActivityApproval actApproval, HttpServletResponse response, ModelMap model) throws Exception{
        System.out.println("社团活动申请.");
        ModelAndView mv = new ModelAndView();
        User user = (User) model.get("userInfo");

        //升生成活动编号
        String activityId = UUID.randomUUID().toString().replace("-","");
        //通过社团名查询社团编号
        String assoId = activityApprovalService.findAssoIdByName(actApproval.getActivityAssoId());
        //申请日期
        Date applicationDate = new Date(System.currentTimeMillis());
        //申请人编号
        String applyId = user.getUserId();

        actApproval.setActivityId(activityId);
        actApproval.setActivityAssoId(assoId);
        actApproval.setApplicationDate(applicationDate);
        actApproval.setApplyId(applyId);

        try {
            activityApprovalService.applyAssoAct(actApproval);
            response.getWriter().write("<script>alert('您的社团活动申请已提交，请等待管理员审批！')<script>");
            mv.setViewName("assocationList");
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("社团活动申请失败.");
        }
        return mv;
    }

    @RequestMapping("/approvalAssoAct")
    public String approvalAssoAct(ActivityApproval actApproval,ModelMap model,HttpServletResponse response) throws Exception{
        System.out.println("审批社团活动申请");
        try {
            User user = (User) model.get("userInfo");
            //判断当前用户是否为管理员
            if("ADMIN".equals(user.getUserIdentity())){
                //当前用户是管理员
                actApproval.setApprovalId(user.getUserId());
                actApproval.setStatus("AGREE");
                actApproval.setApprovalDate(new Date(System.currentTimeMillis()));
                //提交审批
                activityApprovalService.approvalAssoAct(actApproval);
            }else {
                response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("审批社团活动申请失败.");
        }
        return "redirect:findAll";
    }

}
