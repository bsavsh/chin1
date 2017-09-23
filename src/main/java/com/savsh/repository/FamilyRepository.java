package com.savsh.repository;

import com.savsh.entity.Family;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FamilyRepository extends CrudRepository<Family, Long> {
    List<Family> getAllByNumber(Long number);
}
