package com.assocation.controller;

import com.assocation.domain.ActivityApproval;
import com.assocation.domain.Assocation;
import com.assocation.domain.EstApproval;
import com.assocation.domain.User;
import com.assocation.exception.SysException;
import com.assocation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
@SessionAttributes(value = {"userInfo"},types = {User.class})
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public ModelAndView login(String userName, String userPassword, Model model){
        System.out.println("login()方法执行，用户登录中...");
        ModelAndView mv = new ModelAndView();
        User user =userService.login(userName,userPassword);
        if(user != null){
            //用户登录成功，跳转到后台管理界面
            System.out.println("用户登录成功.");
            //将已登录的user信息保存在session中
            model.addAttribute("userInfo",user);
            mv.addObject("user",user);
            mv.setViewName("home");
        }else{
            //不存在当前用户，返回login界面
            System.out.println("用户登录失败.");
            mv.setViewName("login");
        }
        return mv;
    }

    @RequestMapping("/logout")
    public String logout(SessionStatus sessionStatus){
        System.out.println("退出登陆.");
        //清除session中保存的用户信息
        sessionStatus.setComplete();
        return "login";
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        System.out.println("查询当前所有用户：");
        ModelAndView mv = new ModelAndView();
        List<User> userList = userService.findAll();
        for(User user:userList) System.out.println(user.toString());
        mv.addObject("users",userList);
        mv.setViewName("userList");
        return mv;
    }

    @RequestMapping("/findByNameAndIdentity")
    public ModelAndView findByNameAndIdentity(String userName,String userIdentity){
        System.out.println("通过用户名+用户身份模糊查询匹配用户.");
        ModelAndView mv = new ModelAndView();
        List<User> users = userService.findByNameAndIdentity(userName,userIdentity);
        mv.addObject("users",users);
        mv.setViewName("userList");
        return mv;
    }

    @RequestMapping("/deleteUserById")
    public String deleteUserById(@RequestParam(name = "id") String userId,ModelMap model,HttpServletResponse response) throws Exception{
        System.out.println("通过用户id删除指定用户.");
        try {
            User user = (User) model.get("userInfo");
            if("ADMIN".equals(user.getUserIdentity())){
                userService.deleteUserById(userId);
            }else{
                response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("删除指定用户失败.");
        }
        return "redirect:findAll";
    }

    @RequestMapping("/addUser")
    public ModelAndView addUser(User user, HttpServletResponse response) throws Exception {
        System.out.println("添加用户.");
        ModelAndView mv = new ModelAndView();
        if("ADMIN".equals(user.getUserIdentity())){
            if(!user.getUserPassword().equals(user.getUserRePassword())){
                response.getWriter().write("<script>alert('两次密码不一致')<script>");
                mv.setViewName("userAdd");
                return mv;
            }
            try {
                userService.addUser(user);
            }catch (Exception e){
                e.printStackTrace();
                throw new SysException("添加用户失败.");
            }
        }else{
            response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
            mv.setViewName("userAdd");
            return mv;
        }
        mv.setViewName("userList");
        return mv;
    }

    @RequestMapping("/updateUser")
    public String updateUser(User user,HttpServletResponse response) throws Exception {
        System.out.println("更新用户信息.");
        if("ADMIN".equals(user.getUserIdentity())){
            try {
                userService.updateUser(user);
            }catch (Exception e){
                e.printStackTrace();
                throw new SysException("更新用户信息出错.");
            }
        }else{
            response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
        }
        return "redirect:findAll";
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
            userService.applyAssoEst(estApproval);
            response.getWriter().write("<script>alert('您的社团创建申请已提交，请等待管理员审批!')<script>");
            mv.setViewName("assocationList");
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("申请创建社团失败.");
        }
        return mv;
    }

    @RequestMapping("/approveAssoEst")
    public ModelAndView approveAssoEst(EstApproval estApproval, ModelMap model,HttpServletResponse response) throws Exception{
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
                userService.approveAssoEst(estApproval);
                mv.setViewName("assocationList");

            }else{
                //非管理员，无权限进行审批操作
                response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
                mv.setViewName("assocationList");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("审批社团创建申请失败.");
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
                userService.approvalAssoAct(actApproval);
            }else {
                response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("审批社团活动申请失败.");
        }
        return "";
    }

    @RequestMapping("/ratingAsso")
    public String ratingAsso(Assocation assocation,ModelMap model,HttpServletResponse response) throws Exception{
        try {
            User user = (User) model.get("userInfo");
            if("ADMIN".equals(user.getUserIdentity())){
                //提交评级
                userService.ratingAsso(assocation);
            }else{
                response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("社团评级失败.");
        }
        return "";
    }

}
