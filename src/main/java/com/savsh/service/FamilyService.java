package com.savsh.service;

import com.savsh.dto.ChinDto;
import com.savsh.dto.FamilyDto;
import com.savsh.entity.Chinchilla;
import com.savsh.entity.Family;
import com.savsh.repository.ChinchillaRepository;
import com.savsh.repository.FamilyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FamilyService {
    @Autowired
    private FamilyRepository familyRepository;

    public Iterable<FamilyDto> findAll() {
        List<FamilyDto> result = new ArrayList<>();
        familyRepository.findAll().forEach(f -> result.add(new FamilyDto(f)));
        return result;
    }

    public FamilyDto getFamilyById(long id) {
        return new FamilyDto(familyRepository.findOne(id));
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

    public Iterable<ChinDto> getFamilyByNumber(Long number) {
        Iterable<Family> families = familyRepository.getAllByNumber(number);
        List<Chinchilla> result = new ArrayList<>();
        result.add(families.iterator().next().getHusband());
        families.forEach(family -> result.add(family.getWife()));
        List<ChinDto> dtos = new ArrayList<>();
        result.forEach(c -> dtos.add(new ChinDto(c)));
        return dtos;
    }
}
