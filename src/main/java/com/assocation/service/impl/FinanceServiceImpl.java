package com.assocation.service.impl;

import com.assocation.dao.FinanceDao;
import com.assocation.domain.Finance;
import com.assocation.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("financeService")
@Transactional
public class FinanceServiceImpl implements FinanceService {

    private FinanceDao financeDao;

    @Autowired
    public void setFinanceDao(FinanceDao financeDao) {
        this.financeDao = financeDao;
    }

    @Override
    public List<Finance> findAll() {
        return financeDao.findAll();
    }

    @Override
    public List<Finance> findFinanceByMore(String financeId, String financeCategory) {
        return financeDao.findFinanceByMore(financeId,financeCategory);
    }

    @Override
    public void addFinance(Finance finance) throws Exception {
        financeDao.addFinance(finance);
    }

    @Override
    public void deleteFinance(String financeId) throws Exception {
        financeDao.deleteFinance(financeId);
    }

    @Override
    public void updateFinance(Finance finance) throws Exception {
        financeDao.updateFinance(finance);
    }
}
