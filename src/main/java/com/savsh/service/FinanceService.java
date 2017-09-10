package com.savsh.service;

import com.savsh.entity.Finance;
import com.savsh.repository.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinanceService {

    @Autowired
    private FinanceRepository financeRepository;

    @Autowired ChinService chinService;

    public Iterable<Finance> findAll() {
        return financeRepository.findAll();
    }

    public Finance getFinanceById(long id) {
        return financeRepository.findOne(id);
    }

    public Finance insertFinance(Finance finance) {
        chinService.getChinById(finance.getChinId()).setSold(true);
        return financeRepository.save(finance);
    }

    public Finance updateFinance(Finance finance) {
        chinService.getChinById(finance.getChinId()).setSold(true);
        return financeRepository.save(finance);
    }

    public void deleteFinance(long id) {
        financeRepository.delete(id);
    }
}
