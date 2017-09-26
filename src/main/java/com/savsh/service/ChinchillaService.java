package com.savsh.service;

import com.savsh.dto.ChinDto;
import com.savsh.entity.Chinchilla;
import com.savsh.entity.Gender;
import com.savsh.repository.ChinchillaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class ChinchillaService {
    @Autowired
    private ChinchillaRepository chinchillaRepository;

    public Iterable<ChinDto> findAll() {
        List<ChinDto> chins = new ArrayList<>();
        chinchillaRepository.findAll().forEach(chin -> chins.add(new ChinDto(chin)));
        return chins;
    }

    public Chinchilla getChinById(long id) {
        return chinchillaRepository.findOne(id);
    }

    public void deleteChinById(long id) {
        chinchillaRepository.delete(id);
    }

    public Chinchilla updateChin(Chinchilla chin) {
        return chinchillaRepository.save(chin);
    }

    public Chinchilla insertChin(Chinchilla chin) {
        chin.setDeceased(false);
        return chinchillaRepository.save(chin);
    }

//     ancestors

    public List<ChinDto> getAllAncestorsUpTo10Generations(long id) {
        List<Chinchilla> result = new ArrayList<>();
        result.addAll(getByAncestorsByN(id, 5));
        result.addAll(getByAncestorsByN(id, 6));
        result.addAll(getByAncestorsByN(id, 7));
        result.addAll(getByAncestorsByN(id, 8));
        result.addAll(getByAncestorsByN(id, 9));
        return toDtoList(result);
    }

    public List<ChinDto> getAncestorsGeneration(long id, long n) {
        return toDtoList(getByAncestorsByN(id, n));
    }

    public List<Chinchilla> getByAncestorsByN(long id, long n) {
        if (id == 0) {
            return new ArrayList<>();
        }
        if (n < 2) {
            return new ArrayList<Chinchilla>(Arrays.asList(getChinById(id).getFather(), getChinById(id).getMother()));
        }
        List<Chinchilla> gN = getByAncestorsByN(id, n - 1);
        List<Chinchilla> result = new ArrayList<>();
        gN.removeIf(chin -> chin == null);
        gN.forEach(chin -> result.addAll(getByAncestorsByN(chin.getId(), 1)));
        result.removeIf(chin -> chin == null);
        return result;
    }

//     offspring

    public List<ChinDto> getAllOffspring(long id) {
        List<Chinchilla> result = new ArrayList<>();
        result.addAll(getOffspring(id, 3));
        result.addAll(getOffspring(id, 4));
        result.addAll(getOffspring(id, 5));
        result.addAll(getOffspring(id, 6));
        result.addAll(getOffspring(id, 7));
        result.addAll(getOffspring(id, 8));
        result.addAll(getOffspring(id, 9));
        return toDtoList(result);
    }

    public List<ChinDto> getOffspingGeneration(long id, long n) {
        return toDtoList(getOffspring(id, n));
    }

    public List<Chinchilla> getOffspring(long id, long n) {
        if (n < 2) {
            return chinchillaRepository.getChinchillasByFather_IdOrMother_Id(id, id);
        }
        List<Chinchilla> cN = getOffspring(id, n - 1);
        List<Chinchilla> result = new ArrayList<>();
        cN.forEach(chin -> result.addAll(getOffspring(chin.getId(), 1)));
        return result;
    }

//     others

    public List<ChinDto> getBrothersAndSistersOfChinById(long id) {
        Chinchilla chin = getChinById(id);
        List<ChinDto> result = new ArrayList<>();
        if (chin == null) {
            return result;
        }
        Long fatherId = chin.getFather() == null ? 0 : chin.getFather().getId();
        Long motherId = chin.getMother() == null ? 0 : chin.getMother().getId();
        chinchillaRepository.getChinchillasByFather_IdAndMother_Id(
                fatherId, motherId).forEach(c -> result.add(new ChinDto(c)));
        result.removeIf(c -> c.getId() == id);
        return result;
    }

    public List<ChinDto> getHalfBrothersAndSistersOfChinById(long id) {
        Chinchilla chin = getChinById(id);
        List<ChinDto> result = new ArrayList<>();
        if (chin == null) {
            return result;
        }
        Long fatherId = chin.getFather() == null ? 0 : chin.getFather().getId();
        Long motherId = chin.getMother() == null ? 0 : chin.getMother().getId();
        chinchillaRepository.getChinchillasByFather_idAndMother_idNot(
                fatherId, motherId).forEach(c -> result.add(new ChinDto(c)));

        chinchillaRepository.getChinchillasByMother_idAndFather_idNot(
                motherId, fatherId).forEach(c -> result.add(new ChinDto(c)));
        return result;
    }

    public List<ChinDto> getUnclesAndAunts(long id) {
        Chinchilla chin = getChinById(id);
        List<ChinDto> result = new ArrayList<>();
        Long fatherId = chin.getFather() == null ? 0 : chin.getFather().getId();
        Long motherId = chin.getMother() == null ? 0 : chin.getMother().getId();
        result.addAll(getBrothersAndSistersOfChinById(fatherId));
        result.addAll(getBrothersAndSistersOfChinById(motherId));
        result.addAll(getHalfBrothersAndSistersOfChinById(fatherId));
        result.addAll(getHalfBrothersAndSistersOfChinById(motherId));
        return result;
    }

    public List<ChinDto> getCousinsOfChinById(long id) {
        Chinchilla chin = getChinById(id);
        List<ChinDto> result = new ArrayList<>();
        getUnclesAndAunts(id).forEach(c -> result.addAll(getOffspingGeneration(c.getId(), 1)));
        return result;
    }

//    queries

    public List<ChinDto> findAllWithQuery(String gender, String color, String after, String before, String inFamily) {
        LocalDate a = after.isEmpty() ? LocalDate.parse("1900-01-01") : LocalDate.parse(after);
        LocalDate b = before.isEmpty() ? LocalDate.now().plusDays(1) : LocalDate.parse(before);

        if (gender.isEmpty() && color.isEmpty() && inFamily.isEmpty()) {
            return toDtoList(chinchillaRepository.getChinchillasByBornAfterAndBornBeforeAndDeceasedFalse(a, b));
        }
        if (gender.isEmpty() && color.isEmpty() && !inFamily.isEmpty()) {
            if (inFamily.equals("true")) {
                List<Chinchilla> chins =
                        chinchillaRepository.getChinchillasByBornAfterAndBornBeforeAndDeceasedFalse(a, b);
                chins.retainAll(chinchillaRepository.getChinchillasInFamily());
                return toDtoList(chins);
            } else {
                List<Chinchilla> chins =
                        chinchillaRepository.getChinchillasByBornAfterAndBornBeforeAndDeceasedFalse(a, b);
                chins.removeAll(chinchillaRepository.getChinchillasInFamily());
                return toDtoList(chins);
            }
        }
        if (gender.isEmpty() && !color.isEmpty() && inFamily.isEmpty()) {
            return toDtoList(chinchillaRepository
                    .getChinchillasByBornAfterAndBornBeforeAndColorAndDeceasedFalse(a, b, color));
        }
        if (!gender.isEmpty() && color.isEmpty() && inFamily.isEmpty()) {
            return toDtoList(chinchillaRepository
                    .getChinchillasByBornAfterAndBornBeforeAndGenderAndDeceasedFalse(a, b, toGender(gender)));
        }
        if (gender.isEmpty() && !color.isEmpty() && !inFamily.isEmpty()) {
            if (inFamily.equals("true")) {
                List<Chinchilla> chins = chinchillaRepository
                        .getChinchillasByBornAfterAndBornBeforeAndColorAndDeceasedFalse(a, b, color);
                chins.retainAll(chinchillaRepository.getChinchillasInFamily());
                return toDtoList(chins);
            } else {
                List<Chinchilla> chins = chinchillaRepository
                        .getChinchillasByBornAfterAndBornBeforeAndColorAndDeceasedFalse(a, b, color);
                chins.removeAll(chinchillaRepository.getChinchillasInFamily());
                return toDtoList(chins);
            }
        }
        if (!gender.isEmpty() && color.isEmpty() && !inFamily.isEmpty()) {
            if (inFamily.equals("true")) {
                List<Chinchilla> chins = chinchillaRepository
                        .getChinchillasByBornAfterAndBornBeforeAndGenderAndDeceasedFalse(a, b, toGender(gender));
                chins.retainAll(chinchillaRepository.getChinchillasInFamily());
                return toDtoList(chins);
            } else {
                List<Chinchilla> chins = chinchillaRepository
                        .getChinchillasByBornAfterAndBornBeforeAndGenderAndDeceasedFalse(a, b, toGender(gender));
                chins.removeAll(chinchillaRepository.getChinchillasInFamily());
                return toDtoList(chins);
            }
        }
        if (!gender.isEmpty() && !color.isEmpty() && inFamily.isEmpty()) {
            return toDtoList(chinchillaRepository
                    .getChinchillasByBornAfterAndBornBeforeAndGenderAndColorAndDeceasedFalse(
                            a, b, toGender(gender), color));
        }
        if (!gender.isEmpty() && !color.isEmpty() && !inFamily.isEmpty()) {
            if (inFamily.equals("true")) {
                List<Chinchilla> chins = chinchillaRepository
                        .getChinchillasByBornAfterAndBornBeforeAndGenderAndColorAndDeceasedFalse(
                                a, b, toGender(gender), color);
                chins.retainAll(chinchillaRepository.getChinchillasInFamily());
                return toDtoList(chins);
            } else {
                List<Chinchilla> chins = chinchillaRepository
                        .getChinchillasByBornAfterAndBornBeforeAndGenderAndColorAndDeceasedFalse(
                                a, b, toGender(gender), color);
                chins.removeAll(chinchillaRepository.getChinchillasInFamily());
                return toDtoList(chins);
            }
        }
        return toDtoList(chinchillaRepository.getChinchillasByBornAfterAndBornBeforeAndDeceasedFalse(a, b));
    }

    private static List<ChinDto> toDtoList(List<Chinchilla> chins) {
        List<ChinDto> dtos = new ArrayList<>();
        chins.forEach(c -> {
            if (c != null) {
                dtos.add(new ChinDto(c));
            }
        });
        return dtos;
    }

    private static Gender toGender(String s) {
        if (s.equals("MALE")) {
            return Gender.MALE;
        } else if (s.equals("FEMALE")) {
            return Gender.FEMALE;
        } else {
            return Gender.UNKNOWN;
        }
    }

//    deceased

    public List<ChinDto> getDeceasedChins() {
        return toDtoList(chinchillaRepository.getChinchillasByDeceasedTrue());
    }

//    sold

    public List<ChinDto> getSoldChinchillas() {
        return toDtoList(chinchillaRepository.getSoldChinchillas());
    }

//    statistics
    public int getNumberOfAllChins() {
        List<ChinDto> chins = findAllWithQuery("", "", "", "","");
        chins.removeAll(getSoldChinchillas());
        return chins.size();
    }

    public int getNumberOfFemalesInFamily() {
        return findAllWithQuery("FEMALE", "", "", "", "true").size();
    }

    public int getNumberOfMalesInFamily() {
        return findAllWithQuery("MALE", "", "", "", "true").size();
    }

    public int getNumberOfAllNotInFamily() {
        List<ChinDto> chins = findAllWithQuery("", "", "", "", "false");
        chins.removeAll(getSoldChinchillas());
        return chins.size();
    }
}
