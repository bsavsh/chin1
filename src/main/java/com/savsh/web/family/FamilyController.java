package com.savsh.web.family;

import com.savsh.dto.ChinDto;
import com.savsh.dto.FamilyDto;
import com.savsh.entity.Family;
import com.savsh.service.FamilyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/families")
public class FamilyController {
    @Autowired
    private FamilyService familyService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<FamilyDto> allFamilies() {
        return familyService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public FamilyDto getFamilyById(@PathVariable long id) {
        return familyService.getFamilyById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteFamilyById(@PathVariable long id) {
        familyService.deleteFamilyById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Family updateChin(@Valid @RequestBody Family family) {
        return familyService.updateFamily(family);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Family insertChin(@Valid @RequestBody Family family) {
        return familyService.insertFamily(family);
    }

    @RequestMapping(value = "/whole-by-number/{id}", method = RequestMethod.GET)
    public Iterable<ChinDto> getWholeFamilyByNumberOfFamily(@PathVariable long id) {
        return familyService.getFamilyByNumber(id);
    }

    @RequestMapping(value = "/number/{number}", method = RequestMethod.GET)
    public List<FamilyDto> getFamiliesByNumber(@PathVariable("number") long number) {
        return familyService.getFamiliesByNumber(number);
    }
}
