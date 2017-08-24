package com.savsh.web;


import com.savsh.entity.Chin;
import com.savsh.repository.ChinRepository;
import com.savsh.service.ChinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/chins")
public class ChinController {

    @Autowired
    private ChinService chinService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Chin> allChins() {
        return chinService.findAll();
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
    public void updateChin(@RequestBody Chin chin) {
        chinService.updateChin(chin );
    }

    @RequestMapping(method = RequestMethod.POST)
    public void insertChin(@RequestBody Chin chin) {
        chinService.insertChin(chin);
    }
}
