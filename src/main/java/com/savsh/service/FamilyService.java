package com.savsh.service;

import com.savsh.entity.Chin;
import com.savsh.entity.Family;
import com.savsh.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class FamilyService {

    @Autowired
    private FamilyRepository familyRepository;

    @Autowired ChinService chinService;

    public Iterable<Family> findAll() {
        return familyRepository.findAll();
    }

    public Family getFamilyById(long id) {
        return familyRepository.findOne(id);
    }

    public void deleteFamilyById(long id) {
        chinService.getChinById(getFamilyById(id).getHusbandId()).setInFamily(false);
        chinService.getChinById(getFamilyById(id).getWifeId()).setInFamily(false);
        familyRepository.delete(id);
    }

    public Family updateFamily(Family family) {
        return familyRepository.save(family);
    }

    public Family insertFamily(Family family) {
        chinService.getChinById(family.getHusbandId()).setInFamily(true);
        chinService.getChinById(family.getWifeId()).setInFamily(true);
        return familyRepository.save(family);
    }

    // need to make some exception handling
    public Set<Chin> getFamilyByNumber(long id) {
        Set<Chin> setOfChinsInFamily = new HashSet<>();
        Iterable<Family> allByNumberOfFamily = familyRepository.findAllByNumberOfFamily(id);
        for (Family family : allByNumberOfFamily) {
            setOfChinsInFamily.add(chinService.getChinById(family.getHusbandId()));
            setOfChinsInFamily.add(chinService.getChinById(family.getWifeId()));
        }
        return setOfChinsInFamily;
    }
}
