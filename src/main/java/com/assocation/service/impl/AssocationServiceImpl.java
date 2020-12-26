package com.assocation.service.impl;

import com.assocation.domain.Assocation;
import com.assocation.domain.Rank;
import com.assocation.domain.Status;
import com.assocation.service.AssocationService;

import java.util.List;

public class AssocationServiceImpl implements AssocationService {
    @Override
    public List<Assocation> findAll() {
        return null;
    }

    @Override
    public List<Assocation> findByMultiCons(String assoName, Status assoStatus, Rank assoRank) {
        return null;
    }

    @Override
    public void addAssocation(Assocation assocation) throws Exception {

    }

    @Override
    public void deleteAssocation(String assoId) throws Exception {

    }

    @Override
    public void updateAssocation(Assocation assocation) throws Exception {

    }

}
