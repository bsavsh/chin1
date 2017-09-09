package com.savsh.repository;

import com.savsh.entity.Chin;
import com.sun.deploy.panel.ITreeNode;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface ChinRepository extends CrudRepository<Chin, Long> {

    Iterable<Chin> getChinsByBornAfterAndBornBefore(
            LocalDate after, LocalDate before);

    Iterable<Chin> getChinsBySexAndBornAfterAndBornBefore(
            String sex, LocalDate after, LocalDate before);

    Iterable<Chin> getChinsBySexAndColorAndBornAfterAndBornBefore(
            String sex, String color, LocalDate after, LocalDate before);

    Iterable<Chin> getChinsByColorAndBornAfterAndBornBefore(
            String color, LocalDate after, LocalDate before);
}
