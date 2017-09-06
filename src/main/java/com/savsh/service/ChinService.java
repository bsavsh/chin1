package com.savsh.service;

import com.savsh.entity.Chin;
import com.savsh.repository.ChinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Chin updateChin(Chin chin) {
        return chinRepository.save(chin);
    }

    public Chin insertChin(Chin chin) {
        return chinRepository.save(chin);
    }

    public Iterable<Chin> getParrentsOfChinById(long id) {
        List list = new ArrayList<>();
        Chin chin = getChinById(id);
        long fatherId = chin.getFatherId();
        long motherId = chin.getMotherId();

        list.add(getChinById(fatherId));
        list.add(getChinById(motherId));

        return list;
    }

    public Iterable<Chin> getGrandParrentsOfChinById(long id) {
        List list = new ArrayList<>();
        long fatherId = getChinById(id).getFatherId();
        long motherId = getChinById(id).getMotherId();

        long granpa1 = getChinById(fatherId).getFatherId();
        long granma1 = getChinById(fatherId).getMotherId();

        long granpa2 = getChinById(motherId).getFatherId();
        long granma2 = getChinById(motherId).getMotherId();

        list.add(getChinById(granpa1));
        list.add(getChinById(granma1));
        list.add(getChinById(granpa2));
        list.add(getChinById(granma2));

        return list;
    }

    public Iterable<Chin> getGreatGrandParrentsOfChinById(long id) {
        Iterable<Chin> grandparrents = getGrandParrentsOfChinById(id);
        List list = new ArrayList<>();
        for (Chin grandp : grandparrents) {
            Iterable<Chin> parrentsOfGrandparrents = getParrentsOfChinById(grandp.getId());
            for (Chin chin : parrentsOfGrandparrents) {
                list.add(chin);
            }
        }

        return list;
    }
}
