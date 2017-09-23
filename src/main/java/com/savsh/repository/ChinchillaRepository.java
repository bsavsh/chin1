package com.savsh.repository;

import com.savsh.entity.Chinchilla;
import com.savsh.entity.Gender;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;

public interface ChinchillaRepository extends CrudRepository<Chinchilla, Long> {
    @Query("select c from Chinchilla c where c.id in(select f.wife from Family f) or c.id in(select f.husband from Family f)")
    List<Chinchilla> getChinchillasInFamily();

    List<Chinchilla> getChinchillasByFather_IdOrMother_Id(long father_id, long mother_id);

    List<Chinchilla> getChinchillasByFather_IdAndMother_Id(long father_id, long mother_id);

    List<Chinchilla> getChinchillasByFather_idAndMother_idNot(long father_id, long mother_id);

    List<Chinchilla> getChinchillasByMother_idAndFather_idNot(long mother_id, long father_id);

//    queries
    List<Chinchilla> getChinchillasByBornAfterAndBornBeforeAndDeceasedFalse(LocalDate a, LocalDate b);

    List<Chinchilla> getChinchillasByBornAfterAndBornBeforeAndColorAndDeceasedFalse(LocalDate a, LocalDate b, String c);

    List<Chinchilla> getChinchillasByBornAfterAndBornBeforeAndGenderAndDeceasedFalse(LocalDate a, LocalDate b, Gender gender);

    List<Chinchilla> getChinchillasByBornAfterAndBornBeforeAndGenderAndColorAndDeceasedFalse(
            LocalDate a, LocalDate b, Gender gender, String color);

//    deceased

    List<Chinchilla> getChinchillasByDeceasedTrue();

//    sold

    @Query("select c from Chinchilla  c where c.id in(select s.chinchilla from SellChin s)")
    List<Chinchilla> getSoldChinchillas();
}
