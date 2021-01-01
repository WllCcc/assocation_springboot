package com.assocation.service;

import com.assocation.domain.Finance;

import java.util.List;

public interface FinanceService {

    //查询所有社团活动的财务记录
    List<Finance> findAll();

    //通过财务编号+财务类型查询指定财务记录
    List<Finance> findFinanceByMore(String financeId,String financeCategory);

    //添加财务记录
    void addFinance(Finance finance) throws Exception;

    //删除财务记录
    void deleteFinance(String financeId) throws Exception;

    //更新财务信息
    void updateFinance(Finance finance) throws Exception;
}
