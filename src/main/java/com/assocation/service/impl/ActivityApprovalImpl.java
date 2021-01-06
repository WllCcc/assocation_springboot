package com.assocation.service.impl;

import com.assocation.dao.ActivityApprovalDao;
import com.assocation.domain.ActivityApproval;
import com.assocation.service.ActivityApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("activityApprovalService")
public class ActivityApprovalImpl implements ActivityApprovalService {

    private ActivityApprovalDao activityApprovalDao;

    @Autowired
    public void setActivityApprovalDao(ActivityApprovalDao activityApprovalDao) {
        this.activityApprovalDao = activityApprovalDao;
    }

    @Override
    public List<ActivityApproval> findAll() {
        return activityApprovalDao.findAll();
    }

    @Override
    public String findAssoIdByName(String assoName) {
        return activityApprovalDao.findAssoIdByName(assoName);
    }

    @Override
    public void applyAssoAct(ActivityApproval actApproval) throws Exception {
        activityApprovalDao.applyAssoAct(actApproval);
    }

    @Override
    public void approvalAssoAct(ActivityApproval actApproval) throws Exception {
        activityApprovalDao.approvalAssoAct(actApproval);
    }

    @Override
    public void updateActApproval(ActivityApproval actApproval) throws Exception {
        activityApprovalDao.updateActApproval(actApproval);
    }
}
