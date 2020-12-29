package com.assocation.service.impl;

import com.assocation.dao.AssocationDao;
import com.assocation.domain.Assocation;
import com.assocation.domain.Rank;
import com.assocation.domain.Status;
import com.assocation.service.AssocationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("assocationService")
@Transactional
public class AssocationServiceImpl implements AssocationService {

    AssocationDao assocationDao;

    public void setAssocationDao(AssocationDao assocationDao) {
        this.assocationDao = assocationDao;
    }

    @Override
    public List<Assocation> findAllAsso() {
        return assocationDao.findAllAsso();
    }

    @Override
    public List<Assocation> findAssoByMultiCons(String assoName, Status assoStatus, Rank assoRank) {
        return assocationDao.findAssoByMultiCons(assoName,assoStatus,assoRank);
    }

    @Override
    public void addAssocation(Assocation assocation) throws Exception {
        assocationDao.addAssocation(assocation);
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
