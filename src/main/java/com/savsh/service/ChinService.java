package com.savsh.service;

import com.savsh.entity.Chin;
import com.savsh.repository.ChinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ChinService {

    @Autowired
    private ChinRepository chinRepository;

    public Iterable<Chin> findAll() {
        return chinRepository.findAll();
    }

    public Chin getChinById(long id) {
        return chinRepository.findOne(id);
    }

    public void deleteChinById(long id) {
        chinRepository.delete(id);
    }

    public void updateChin(Chin chin) {
        chinRepository.save(chin);
    }

    public void insertChin(Chin chin) {
        chinRepository.save(chin);
    }
}
