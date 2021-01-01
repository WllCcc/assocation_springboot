package com.assocation.service;

import com.assocation.domain.Assocation;

import java.util.List;

public interface AssocationService {

    //查询所有社团
    List<Assocation> findAllAsso();

    //通过社团编号查询指定社团
    List<Assocation> findAssoById(String assoId);

    //通过社团名查询指定社团编号
    String findAssoIdByName(String assoName);

    //多条件模糊查询社团（社团名+社团状态+社团等级）
    List<Assocation> findAssoByMultiCons(String assoName, String assoStatus, String assoRank);

    //删除社团
    void deleteAssocation(String assoId) throws Exception;

    //更新社团信息
    void updateAssocation(Assocation assocation) throws Exception;
}
