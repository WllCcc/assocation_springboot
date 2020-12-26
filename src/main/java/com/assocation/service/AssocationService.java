package com.assocation.service;

import com.assocation.domain.Assocation;
import com.assocation.domain.Rank;
import com.assocation.domain.Status;

import java.util.List;

public interface AssocationService {

    List<Assocation> findAll();

    //多条件模糊查询（社团名+社团状态+社团等级）
    List<Assocation> findByMultiCons(String assoName, Status assoStatus, Rank assoRank);

    void addAssocation(Assocation assocation) throws Exception;

    void deleteAssocation(String assoId) throws Exception;

    void updateAssocation(Assocation assocation) throws Exception;
}
