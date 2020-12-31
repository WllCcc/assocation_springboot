package com.assocation.service.impl;

import com.assocation.dao.AssocationDao;
import com.assocation.domain.ActivityApproval;
import com.assocation.domain.Assocation;
import com.assocation.service.AssocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("assocationService")
@Transactional
public class AssocationServiceImpl implements AssocationService {

    AssocationDao assocationDao;

    @Autowired
    public void setAssocationDao(AssocationDao assocationDao) {
        this.assocationDao = assocationDao;
    }

    @Override
    public List<Assocation> findAllAsso() {
        return assocationDao.findAllAsso();
    }

    @Override
    public List<Assocation> findAssoById(String assoId) {
        return assocationDao.findAssoById(assoId);
    }

    @Override
    public String findAssoIdByName(String assoName) {
        return assocationDao.findAssoIdByName(assoName);
    }

    @Override
    public List<Assocation> findAssoByMultiCons(String assoName, String assoStatus, String assoRank) {
        return assocationDao.findAssoByMultiCons(assoName,assoStatus,assoRank);
    }

    @Override
    public void applyAssoAct(ActivityApproval actApproval) throws Exception {
        assocationDao.applyAssoAct(actApproval);
    }

    @Override
    public void deleteAssocation(String assoId) throws Exception {
        assocationDao.deleteAssocation(assoId);
    }

    @Override
    public void updateAssocation(Assocation assocation) throws Exception {
        assocationDao.updateAssocation(assocation);
    }

}
