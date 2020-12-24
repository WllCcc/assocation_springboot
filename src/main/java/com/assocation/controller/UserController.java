package com.assocation.controller;

import com.assocation.domain.Identity;
import com.assocation.domain.User;
import com.assocation.exception.SysException;
import com.assocation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/login")
    public ModelAndView login(String userName, String userPassword, Identity userIdentity){
        System.out.println("login()方法执行，用户登录中...");
        ModelAndView mv = new ModelAndView();
        User user =userService.login(userName,userPassword,userIdentity);
        if(user != null){
            if(user.getUserIdentity().equals(Identity.ADMIN)){
                //管理员登录，跳转到后台管理员界面
                System.out.println("管理员登录成功.");
                mv.addObject("user",user);
                mv.setViewName("adminIndex");
            }else{
                //学生登录，跳转到学生登录界面
                System.out.println("学生登录成功.");
                mv.setViewName("studentIndex");
            }
        }else{
            //不存在当前用户，返回login界面
            System.out.println("用户登录失败.");
            mv.setViewName("login");
        }
        return mv;
    }

    @RequestMapping("/logout")
    public String logout(){
        System.out.println("退出登陆.");
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

    @RequestMapping("/deleteUserById")
    public String deleteUserById(@RequestParam(name = "id") String userId) throws Exception{
        System.out.println("通过用户id删除指定用户.");
        userService.deleteUserById(userId);
        return "redirect:findAll";
    }

    @RequestMapping("/findByNameAndIdentity")
    public ModelAndView findByNameAndIdentity(String userName,Identity userIdentity){
        System.out.println("通过用户名+用户身份模糊查询匹配用户.");
        ModelAndView mv = new ModelAndView();
        List<User> users = userService.findByNameAndIdentity(userName,userIdentity);
        mv.addObject("users",users);
        mv.setViewName("userList");
        return mv;
    }

    @RequestMapping("/addUser")
    public ModelAndView addUser(User user, HttpServletResponse response) throws IOException {
        System.out.println("添加用户.");
        ModelAndView mv = new ModelAndView();
        if(!user.getUserPassword().equals(user.getUserRePassword())){
            response.getWriter().write("<script>alert('两次密码不一致')<script>");
            mv.setViewName("userAdd");
            return mv;
        }
        userService.addUser(user);
        mv.setViewName("findAll");
        return mv;
    }

    @RequestMapping("updateUser")
    public String updateUser(User user) throws Exception {
        System.out.println("更新用户信息.");
        try {
            userService.updateUser(user);
        }catch (Exception e){
            e.printStackTrace();
            throw new SysException("更新用户信息出错.");
        }
        return "redirect:findAll";
    }
}
