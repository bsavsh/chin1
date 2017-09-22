package com.savsh.service;

import com.savsh.dto.FinanceRowDto;
import com.savsh.entity.SellChin;
import com.savsh.repository.SellChinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SellChinService {
    @Autowired
    private SellChinRepository sellChinRepository;

    public Iterable<FinanceRowDto> findAll() {
        List<FinanceRowDto> dtos = new ArrayList<>();
        sellChinRepository.findAll().forEach(sellChin -> dtos.add(new FinanceRowDto(sellChin)));
        return dtos;
    }

    public FinanceRowDto getOrderById(long id) {
        return new FinanceRowDto(sellChinRepository.findOne(id));
    }

    public void deleteOrder(long id) {
        sellChinRepository.delete(id);
    }

    public SellChin updateOrder(SellChin sellChin) {
        return sellChinRepository.save(sellChin);
    }

    public SellChin insertOrder(SellChin sellChin) {
        return sellChinRepository.save(sellChin);
    }
}
