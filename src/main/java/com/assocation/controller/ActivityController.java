package com.assocation.controller;

import com.assocation.domain.Activity;
import com.assocation.domain.User;
import com.assocation.exception.SysException;
import com.assocation.service.ActivityService;
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
@RequestMapping("/activity")
@SessionAttributes(value = {"userInfo"},types = {User.class})
public class ActivityController {

    private ActivityService activityService;

    @Autowired
    public void setActivityService(ActivityService activityService) {
        this.activityService = activityService;
    }

    @RequestMapping("/findAll")
    public ModelAndView findAll(){
        System.out.println("查询当前所有活动.");
        ModelAndView mv = new ModelAndView();
        List<Activity> activities = activityService.findAll();
        for(Activity activity:activities)System.out.println(activity.toString());
        mv.addObject("activityList",activities);
        mv.setViewName("activityList");
        return mv;
    }

    @RequestMapping("/findActivityById")
    public ModelAndView findActivityById(String activityId){
        System.out.println("通过活动编号查询活动.");
        ModelAndView mv = new ModelAndView();
        List<Activity> activities = activityService.findActivityById(activityId);
        for(Activity activity:activities)System.out.println(activity.toString());
        mv.addObject("activityList",activities);
        mv.setViewName("activityList");
        return mv;
    }

    @RequestMapping("/findByNameAndAssoId")
    public ModelAndView findByNameAndAssoId(String activityName,String assoId){
        System.out.println("通过活动名和社团编号查询活动.");
        ModelAndView mv = new ModelAndView();
        List<Activity> activities = activityService.findByNameAndAssoId(activityName,assoId);
        for (Activity activity:activities)System.out.println(activity.toString());
        mv.addObject("activityList",activities);
        mv.setViewName("activityList");
        return mv;
    }

    @RequestMapping("/deleteActivity")
    public String deleteActivity(@RequestParam(name = "activityId") String activityId, ModelMap model, HttpServletResponse response) throws Exception{
        System.out.println("通过活动编号删除活动.");
        User user = (User) model.get("userInfo");
        if("管理员".equals(user.getUserIdentity())){
            try {
                activityService.deleteActivity(activityId);
            }catch (Exception e){
                e.printStackTrace();
                throw new SysException("删除活动失败.");
            }
        }else {
            response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
        }
        return "redirect:/activity/findAll";
    }

    @RequestMapping("/updateActivity")
    public String updateActivity(Activity activity,ModelMap model,HttpServletResponse response) throws Exception{
        System.out.println("更新活动信息.");
        User user = (User) model.get("userInfo");
        if("管理员".equals(user.getUserIdentity())){
            try {
                activityService.updateActivity(activity);
            }catch (Exception e){
                e.printStackTrace();
                throw new SysException("更新活动信息失败.");
            }
        }else {
            response.getWriter().write("<script>alert('非管理员无权限进行该操作!')<script>");
        }
        return "redirect:findAll";
    }

}
