package com.savsh.repository;

import com.savsh.entity.Chin;
import org.springframework.data.repository.CrudRepository;

public interface ChinRepository extends CrudRepository<Chin, Long> {
    Iterable<Chin> getChinsBySex(String sex);
}
