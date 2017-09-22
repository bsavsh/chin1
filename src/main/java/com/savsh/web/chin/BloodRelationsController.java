package com.savsh.web.chin;

import com.savsh.dto.ChinDto;
import com.savsh.entity.Chinchilla;
import com.savsh.service.ChinchillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BloodRelationsController {

    @Autowired
    private ChinchillaService chinchillaService;

    @RequestMapping(value = "/parrents/{id}", method = RequestMethod.GET)
    public Iterable<ChinDto> getParrentsOfChinById(@PathVariable long id) {
        return chinchillaService.getAncestorsGeneration(id, 1);
    }

    @RequestMapping(value = "/grand-parrents/{id}", method = RequestMethod.GET)
    public Iterable<ChinDto> getGrandParrentsOfChinById(@PathVariable long id) {
        return chinchillaService.getAncestorsGeneration(id, 2);
    }

    @RequestMapping(value = "/great-grand-parrents/{id}", method = RequestMethod.GET)
    public Iterable<ChinDto> getGreatGrandParrentsOfChinById(@PathVariable long id) {
        return chinchillaService.getAncestorsGeneration(id, 3);
    }

    @RequestMapping(value = "/great-great-grand-parrrents/{id}", method = RequestMethod.GET)
    public Iterable<ChinDto> getGreatGreatGrandParrentsOfChinById(@PathVariable long id) {
        return chinchillaService.getAncestorsGeneration(id, 4);
    }

    @RequestMapping(value = "/all-ancestors-up-to-10-generations/{id}", method = RequestMethod.GET)
    public Iterable<ChinDto> getAllAncestorsUpTo10Generations(@PathVariable long id) {
        return chinchillaService.getAllAncestorsUpTo10Generations(id);
    }

    @RequestMapping(value = "/brothers-and-sisters/{id}", method = RequestMethod.GET)
    public Iterable<ChinDto> getBrothersAndSistersOfChinById(@PathVariable long id) {
        return chinchillaService.getBrothersAndSistersOfChinById(id);
    }

    @RequestMapping(value = "/half-brothers-and-half-sisters/{id}", method = RequestMethod.GET)
    public Iterable<ChinDto> getHalfBrothersAndHalfSisters(@PathVariable long id) {
        return chinchillaService.getHalfBrothersAndSistersOfChinById(id);
    }

    @RequestMapping(value = "/uncles-and-aunts/{id}", method = RequestMethod.GET)
    public Iterable<ChinDto> getUnclesAndAunts(@PathVariable long id) {
        return chinchillaService.getUnclesAndAunts(id);
    }

    @RequestMapping(value = "/cousins/{id}", method = RequestMethod.GET)
    public Iterable<ChinDto> getCousins(@PathVariable long id) {
        return chinchillaService.getCousinsOfChinById(id);
    }

    @RequestMapping(value = "/first-offspring/{id}", method = RequestMethod.GET)
    public Iterable<ChinDto> getChildren(@PathVariable long id) {
        return chinchillaService.getOffspingGeneration(id, 1);
    }

    @RequestMapping(value = "/second-offspring/{id}", method = RequestMethod.GET)
    public Iterable<ChinDto> getGrandChildren(@PathVariable long id) {
        return chinchillaService.getOffspingGeneration(id, 2);
    }

    @RequestMapping(value = "/all-offspring/{id}", method = RequestMethod.GET)
    public Iterable<ChinDto> getAllNGenerationChildren(@PathVariable long id) {
        return chinchillaService.getAllOffspring(id);
    }
}
