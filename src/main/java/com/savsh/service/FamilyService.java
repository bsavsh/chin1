package com.savsh.service;

import com.savsh.entity.Family;
import com.savsh.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    public Iterable<Family> findAll() {
        return familyRepository.findAll();
    }

    public Family getFamilyById(long id) {
        return familyRepository.findOne(id);
    }

    public void deleteFamilyById(long id) {
        familyRepository.delete(id);
    }

    public Family updateFamily(Family family) {
        return familyRepository.save(family);
    }

    public Family insertFamily(Family family) {
        return familyRepository.save(family);
    }
}
