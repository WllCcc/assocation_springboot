package com.assocation.service.impl;

import com.assocation.dao.EstApprovalDao;
import com.assocation.domain.EstApproval;
import com.assocation.service.EstApprovalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("estApprovalService")
@Transactional
public class EstApprovalImpl implements EstApprovalService {

    private EstApprovalDao estApprovalDao;

    @Autowired
    public void setEstApprovalDao(EstApprovalDao estApprovalDao) {
        this.estApprovalDao = estApprovalDao;
    }

    @Override
    public List<EstApproval> findAll() {
        return estApprovalDao.findAll();
    }

    @Override
    public void applyAssoEst(EstApproval estApproval) throws Exception {
        estApprovalDao.applyAssoEst(estApproval);
    }

    @Override
    public void approveAssoEst(EstApproval estApproval) throws Exception {
        estApprovalDao.approveAssoEst(estApproval);
    }

    @Override
    public void updateEstApproval(EstApproval estApproval) throws Exception {
        estApprovalDao.updateEstApproval(estApproval);
    }
}
