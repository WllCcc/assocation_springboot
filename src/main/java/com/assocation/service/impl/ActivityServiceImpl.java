package com.assocation.service.impl;

import com.assocation.dao.ActivityDao;
import com.assocation.domain.Activity;
import com.assocation.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("activityService")
@Transactional
public class ActivityServiceImpl implements ActivityService {

    ActivityDao activityDao;

    @Autowired
    public void setActivityDao(ActivityDao activityDao) {
        this.activityDao = activityDao;
    }

    @Override
    public List<Activity> findAll() {
        return activityDao.findAll();
    }

    @Override
    public List<Activity> findActivityById(String activityId) {
        return activityDao.findActivityById(activityId);
    }

    @Override
    public List<Activity> findByNameAndAssoId(String activityName, String assoId) {
        return activityDao.findByNameAndAssoId(activityName,assoId);
    }

    @Override
    public void deleteActivity(String activityId) throws Exception {
        activityDao.deleteActivity(activityId);
    }

    @Override
    public void updateActivity(Activity activity) throws Exception {
        activityDao.updateActivity(activity);
    }
}
