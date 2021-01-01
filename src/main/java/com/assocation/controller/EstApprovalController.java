package com.assocation.controller;

import com.assocation.domain.EstApproval;
import com.assocation.domain.User;
import com.assocation.exception.SysException;
import com.assocation.service.EstApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/estApproval")
public class EstApprovalController {

    private EstApprovalService estApprovalService;

    @Autowired
    public void setEstApprovalService(EstApprovalService estApprovalService) {
        this.estApprovalService = estApprovalService;
    }

    @RequestMapping("/applyAssoEst")
    public ModelAndView applyAssoEst(EstApproval estApproval,ModelMap model,HttpServletResponse response) throws Exception{
        System.out.println("申请创建社团.");
        ModelAndView mv = new ModelAndView();
        User user = (User) model.get("userInfo");
        //生成社团编号
        String assocationId = UUID.randomUUID().toString().replace("-","");
        //获取申请日期
        Date applicationDate = new Date(System.currentTimeMillis());
        //获取申请人编号
        String applyId = user.getUserId();
        estApproval.setAssocationId(assocationId);
        estApproval.setApplicationDate(applicationDate);
        estApproval.setApplyId(applyId);
        try {
            //提交申请
            estApprovalService.applyAssoEst(estApproval);
            response.getWriter().write("<script>alert('您的社团创建申请已提交，请等待管理员审批!')<script>");
            mv.setViewName("assocationList");
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("申请创建社团失败.");
        }
        return mv;
    }

    @RequestMapping("/approveAssoEst")
    public ModelAndView approveAssoEst(EstApproval estApproval, ModelMap model, HttpServletResponse response) throws Exception{
        System.out.println("审批社团创建申请.");
        ModelAndView mv = new ModelAndView();
        try {
            User user = (User) model.get("userInfo");
            if("ADMIN".equals(user.getUserIdentity())){
                //设置审批人编号为当前登录用户的编号
                estApproval.setApprovalId(user.getUserId());
                //设置审批状态为“同意”
                estApproval.setStatus("AGREE");
                //设置审批时间为当前时间
                estApproval.setApprovalDate(new Date(System.currentTimeMillis()));
                //提交审批
                estApprovalService.approveAssoEst(estApproval);

            }else{
                //非管理员，无权限进行审批操作
                response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
            }
            mv.setViewName("assocationList");
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("审批社团创建申请失败.");
        }
        return mv;
    }
}
