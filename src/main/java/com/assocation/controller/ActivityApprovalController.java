package com.assocation.controller;

import com.assocation.domain.ActivityApproval;
import com.assocation.domain.User;
import com.assocation.exception.SysException;
import com.assocation.service.ActivityApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/activityApproval")
@SessionAttributes(value = {"userInfo"},types = {User.class})
public class ActivityApprovalController {

    private ActivityApprovalService activityApprovalService;

    @Autowired
    public void setActivityApprovalService(ActivityApprovalService activityApprovalService) {
        this.activityApprovalService = activityApprovalService;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        System.out.println("查询所有社团活动审批清单.");
        ModelAndView mv = new ModelAndView();
        List<ActivityApproval> activityApprovals = activityApprovalService.findAll();
        mv.addObject("activityApprovalList",activityApprovals);
        mv.setViewName("activityEstList");
        return mv;
    }

    @RequestMapping("/applyAssoAct")
    public String applyAssoAct(ActivityApproval actApproval, HttpServletResponse response, ModelMap model) throws Exception{
        System.out.println("社团活动申请.");
        //生成活动编号
        String activityId = UUID.randomUUID().toString().replace("-","");
        //申请日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String applicationDate = sdf.format(date);
        //申请人编号
        User user = (User) model.get("userInfo");
        String applyId = user.getUserId();
        actApproval.setActivityId(activityId);
        actApproval.setApplicationDate(applicationDate);
        actApproval.setApplyId(applyId);
        try {
            activityApprovalService.applyAssoAct(actApproval);
            response.getWriter().write("<script>alert('您的社团活动申请已提交，请等待管理员审批！')<script>");
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("社团活动申请失败.");
        }
        return "redirect:/activityApproval/findAll";
    }

    @RequestMapping("/approvalAssoAct")
    public String approvalAssoAct(ActivityApproval actApproval,ModelMap model,HttpServletResponse response) throws Exception{
        System.out.println("审批社团活动申请");
        System.out.println("status = " + actApproval.getStatus());
        try {
            User user = (User) model.get("userInfo");
            //判断当前用户是否为管理员
            if("管理员".equals(user.getUserIdentity())){
                System.out.println("执行到里面了");
                if("AGREE".equals(actApproval.getStatus())){
                    //同意
                    actApproval.setApprovalId(user.getUserId());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date(System.currentTimeMillis());
                    String approvalDate = sdf.format(date);
                    actApproval.setApprovalDate(approvalDate);
                    actApproval.setStatus("同意");
                    //更新申请信息
                    activityApprovalService.updateActApproval(actApproval);
                    //提交审批,将活动信息保存到数据库
                    activityApprovalService.approvalAssoAct(actApproval);
                }else{
                    return "redirect:/activity/findAll";
                }
            }else {
                response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("审批社团活动申请失败.");
        }
        return "redirect:/activity/findAll";
    }

    @RequestMapping("/updateActApproval")
    public void updateActApproval(ActivityApproval actApproval) throws Exception{
        activityApprovalService.updateActApproval(actApproval);
    }

}
