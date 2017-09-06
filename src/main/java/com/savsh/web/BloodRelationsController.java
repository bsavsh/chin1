package com.savsh.web;

import com.savsh.entity.Chin;
import com.savsh.service.ChinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BloodRelationsController {

    @Autowired
    private ChinService chinService;

    @RequestMapping(value = "/parrents/{id}", method = RequestMethod.GET)
    public Iterable<Chin> getParrentsOfChinById(@PathVariable long id) {
        return chinService.getParrentsOfChinById(id);
    }

    @RequestMapping(value = "/grand-parrents/{id}", method = RequestMethod.GET)
    public Iterable<Chin> getGrandParrentsOfChinById(@PathVariable long id) {
        return chinService.getGrandParrentsOfChinById(id);
    }

    @RequestMapping(value = "/great-grand-parrents/{id}", method = RequestMethod.GET)
    public Iterable<Chin> getGreatGrandParrentsOfChinById(@PathVariable long id) {
        return chinService.getGreatGrandParrentsOfChinById(id);
    }

    @RequestMapping(value = "/great-great-grand-parrrents/{id}", method = RequestMethod.GET)
    public Iterable<Chin> getGreatGreatGrandParrentsOfChinById(@PathVariable long id) {
        return chinService.getGreatGreatGrandParrentsOfChinById(id);
    }

    @RequestMapping(value = "/all-ancestors-up-to-10-generations/{id}", method = RequestMethod.GET)
    public Iterable<Chin> getAllAncestorsUpTo10Generations(@PathVariable long id) {
        return chinService.getAllAncestorsUpTo10Generations(id);
    }
}