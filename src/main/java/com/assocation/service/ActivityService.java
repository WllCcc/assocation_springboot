package com.assocation.service;

import com.assocation.domain.Activity;

import java.util.List;

public interface ActivityService {

    //查询所有社团活动
    List<Activity> findAll();

    //通过活动编号查询指定活动
    List<Activity> findActivityById(String activityId);

    //多条件查询活动（活动名+所属社团编号）
    List<Activity> findByNameAndAssoId(String activityName,String assoId);

    //删除活动
    void deleteActivity(String activityId) throws Exception;

    //更新活动信息
    void updateActivity(Activity activity) throws Exception;

}
