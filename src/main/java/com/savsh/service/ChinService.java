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
        List<Chin> list = new ArrayList<>();
        Chin chin = getChinById(id);
        long fatherId = chin.getFatherId();
        long motherId = chin.getMotherId();

        if (fatherId != 0) {
            list.add(getChinById(fatherId));
        }

        if (motherId != 0) {
            list.add(getChinById(motherId));
        }

        return list;
    }

    public Iterable<Chin> getGrandParrentsOfChinById(long id) {
        Iterable<Chin> parrents = getParrentsOfChinById(id);
        List<Chin> list = new ArrayList<>();
        for (Chin parrent : parrents) {
            saveParrentsOfParrentsInNGeneration(parrent.getId(), list);
        }

        return list;
    }

    public Iterable<Chin> getGreatGrandParrentsOfChinById(long id) {
        Iterable<Chin> grandParrents = getGrandParrentsOfChinById(id);
        List<Chin> list = new ArrayList<>();
        for (Chin grandParrent : grandParrents) {
            saveParrentsOfParrentsInNGeneration(grandParrent.getId(), list);
        }

        return list;
    }

    public Iterable<Chin> getGreatGreatGrandParrentsOfChinById(long id) {
        Iterable<Chin> greatGrandParrents = getGreatGrandParrentsOfChinById(id);
        List<Chin> list = new ArrayList<>();
        for (Chin greatGrandParrent : greatGrandParrents) {
            saveParrentsOfParrentsInNGeneration(greatGrandParrent.getId(), list);
        }

        return list;
    }

    public Iterable<Chin> getAllAncestorsUpTo10Generations(long id) {
        List<Chin> list = new ArrayList<>();
        m(id, list);


        return list;
    }

    private Iterable<Chin> m(long id, List list) {
        Iterable<Chin> greatGreatGrandParrents = getGreatGreatGrandParrentsOfChinById(id);
        for (Chin chin : greatGreatGrandParrents) {
            saveParrentsOfParrentsInNGeneration(chin.getId(), list);
        }

        return list;
    }

    private void saveParrentsOfParrentsInNGeneration(long id, List list) {
        Iterable<Chin> parrents = getParrentsOfChinById(id);
        for (Chin chin : parrents) {
            list.add(chin);
        }
    }

}
