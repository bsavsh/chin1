package com.savsh.repository;

import com.savsh.entity.Chin;
import com.sun.deploy.panel.ITreeNode;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;

public interface ChinRepository extends CrudRepository<Chin, Long> {

    Iterable<Chin> getChinsBySexAndColorAndInFamilyAndBornAfterAndBornBeforeAndDeceasedFalseAndSoldFalse(
            String sex, String color, Boolean inFamily, LocalDate after, LocalDate before);

    Iterable<Chin> getChinsBySexAndColorAndBornAfterAndBornBeforeAndDeceasedFalseAndSoldFalse(
            String sex, String color, LocalDate after, LocalDate before);

    Iterable<Chin> getChinsBySexAndInFamilyAndBornAfterAndBornBeforeAndDeceasedFalseAndSoldFalse(
            String sex, Boolean inFamily, LocalDate after, LocalDate before);

    Iterable<Chin> getChinsByColorAndInFamilyAndBornAfterAndBornBeforeAndDeceasedFalseAndSoldFalse(
            String color, Boolean inFamily, LocalDate after, LocalDate before);

    Iterable<Chin> getChinsBySexAndBornAfterAndBornBeforeAndDeceasedFalseAndSoldFalse(
            String sex, LocalDate after, LocalDate before);

    Iterable<Chin> getChinsByColorAndBornAfterAndBornBeforeAndDeceasedFalseAndSoldFalse(
            String color, LocalDate after, LocalDate before);

    Iterable<Chin> getChinsByInFamilyAndBornAfterAndBornBeforeAndDeceasedFalseAndSoldFalse(
            Boolean inFamily, LocalDate after, LocalDate before);

    Iterable<Chin> getChinsByBornAfterAndBornBeforeAndDeceasedFalseAndSoldFalse(
            LocalDate after, LocalDate before);


    Iterable<Chin> getChinsBySoldTrue();

    Iterable<Chin> getChinsByDeceasedTrue();

//    statistics

    Long countAllByDeceasedFalseAndSoldFalse();

    Long countAllBySexAndDeceasedFalseAndSoldFalseAndInFamilyTrue(String sex);

    Long countAllByDeceasedFalseAndSoldFalseAndInFamilyFalse();


}
