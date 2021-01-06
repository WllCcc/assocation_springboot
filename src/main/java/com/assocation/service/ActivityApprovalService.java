package com.assocation.service;

import com.assocation.domain.ActivityApproval;

import java.util.List;

public interface ActivityApprovalService {

    //查询所有活动审批清单
    List<ActivityApproval> findAll();

    //通过社团名查询社团编号
    String findAssoIdByName(String assoName);

    //社团活动申请
    void applyAssoAct(ActivityApproval actApproval) throws Exception;

    //审批社团活动申请
    void approvalAssoAct(ActivityApproval actApproval) throws Exception;

    //更新审批记录
    void updateActApproval(ActivityApproval actApproval) throws Exception;

}
