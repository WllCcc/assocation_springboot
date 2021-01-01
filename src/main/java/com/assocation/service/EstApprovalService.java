package com.assocation.service;

import com.assocation.domain.EstApproval;

import java.util.List;

public interface EstApprovalService {

    //查询社团创建审批清单
    List<EstApproval> findAll();

    //社团创建申请
    void applyAssoEst(EstApproval estApproval) throws Exception;

    //审批社团创建申请
    void approveAssoEst(EstApproval estApproval) throws Exception;
}
