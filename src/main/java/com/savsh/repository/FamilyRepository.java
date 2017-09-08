package com.savsh.repository;

import com.savsh.entity.Family;
import org.springframework.data.repository.CrudRepository;

public interface FamilyRepository extends CrudRepository<Family, Long> {
    Iterable<Family> findAllByNumberOfFamily(Long numberOfFamily);
}
