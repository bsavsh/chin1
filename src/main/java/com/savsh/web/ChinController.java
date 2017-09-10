package com.savsh.web;


import com.savsh.entity.Chin;
import com.savsh.service.ChinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/chins")
public class ChinController {

    @Autowired
    private ChinService chinService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Chin> allChins() {
        return chinService.findAll();
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Iterable<Chin> getChinsByQuery(@RequestParam(value = "gender", required = false) String gender,
                                          @RequestParam(value = "color", required = false) String color,
                                          @RequestParam(value = "bornAfter", required = false) String bornAfter,
                                          @RequestParam(value = "bornBefore", required = false) String bornBefore,
                                          @RequestParam(value = "inFamily", required = false) String inFamily) {
        return chinService.findAllWithQuery(gender, color, bornAfter, bornBefore, inFamily);
    }

    @RequestMapping(value = "/sold", method = RequestMethod.GET)
    public Iterable<Chin> getSoldChins() {
        return chinService.getSoldChins();
    }

    @RequestMapping(value = "/deceased", method = RequestMethod.GET)
    public Iterable<Chin> getDeceasedChins() {
        return chinService.getDeceasedChins();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Chin getChinById(@PathVariable long id) {
        return chinService.getChinById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteChinById(@PathVariable long id) {
        chinService.deleteChinById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Chin updateChin(@Valid @RequestBody Chin chin) {
        return chinService.updateChin(chin );
    }

    @RequestMapping(method = RequestMethod.POST)
    public Chin insertChin(@Valid @RequestBody Chin chin) {
        return chinService.insertChin(chin);
    }
}
