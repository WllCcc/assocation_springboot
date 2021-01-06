package com.assocation.controller;

import com.assocation.domain.EstApproval;
import com.assocation.domain.User;
import com.assocation.exception.SysException;
import com.assocation.service.EstApprovalService;
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
@RequestMapping("/estApproval")
@SessionAttributes(value = {"userInfo"},types = {User.class})
public class EstApprovalController {

    private EstApprovalService estApprovalService;

    @Autowired
    public void setEstApprovalService(EstApprovalService estApprovalService) {
        this.estApprovalService = estApprovalService;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        System.out.println("查询所有社团审批清单.");
        ModelAndView mv = new ModelAndView();
        List<EstApproval> estApprovals = estApprovalService.findAll();
        mv.addObject("estApprovalList",estApprovals);
        mv.setViewName("assocationEstList");
        return mv;
    }

    @RequestMapping("/applyAssoEst")
    public String applyAssoEst(EstApproval estApproval,ModelMap model) throws Exception{
        System.out.println("申请创建社团.");
        User user = (User) model.get("userInfo");
        //生成社团编号
        String assocationId = UUID.randomUUID().toString().replace("-","");
        //获取申请日期
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        String applicationDate = sdf.format(date);
        //获取申请人编号
        String applyId = user.getUserId();
        estApproval.setAssocationId(assocationId);
        estApproval.setApplicationDate(applicationDate);
        estApproval.setApplyId(applyId);
        try {
            //提交申请
            estApprovalService.applyAssoEst(estApproval);
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("申请创建社团失败.");
        }
        return "redirect:/estApproval/findAll";
    }

    @RequestMapping("/approveAssoEst")
    public String approveAssoEst(EstApproval estApproval, ModelMap model, HttpServletResponse response) throws Exception{
        System.out.println("审批社团创建申请.");
        try {
            User user = (User) model.get("userInfo");
            if("管理员".equals(user.getUserIdentity())){
                if("AGREE".equals(estApproval.getStatus())){
                    //设置审批人编号为当前登录用户的编号
                    estApproval.setApprovalId(user.getUserId());
                    //设置审批时间为当前时间
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date = new Date(System.currentTimeMillis());
                    String approvalDate = sdf.format(date);
                    estApproval.setApprovalDate(approvalDate);
                    estApproval.setStatus("同意");
                    estApprovalService.updateEstApproval(estApproval);
                    //提交审批
                    estApprovalService.approveAssoEst(estApproval);
                }else{
                    return "redirect:/activity/findAll";
                }

            }else{
                //非管理员，无权限进行审批操作
                response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("审批社团创建申请失败.");
        }
        return "redirect:/assocation/findAll";
    }

    @RequestMapping("/updateEstApproval")
    public void updateEstApproval(EstApproval estApproval) throws Exception{
        estApprovalService.updateEstApproval(estApproval);
    }
}
