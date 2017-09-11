package com.savsh.web;

import com.savsh.service.ChinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/statistics")
public class StatisticsController {

    @Autowired
    private ChinService chinService;

    @RequestMapping(value = "/number-of-all-chins", method = RequestMethod.GET)
    public Long getNumberOfAllChins() {
        return chinService.getNumberOfAllChins();
    }

    @RequestMapping(value = "/number-of-females-in-family", method = RequestMethod.GET)
    public Long getNumberOfFemalesInFamily() {
        return chinService.getNumberOfFemalesInFamily();
    }

    @RequestMapping(value = "/number-of-males-in-family", method = RequestMethod.GET)
    public Long getNumberOfMalesInFamily() {
        return chinService.getNumberOfMalesInFamily();
    }

    @RequestMapping(value = "/number-of-all-not-in-family", method = RequestMethod.GET)
    public Long getNumberOfAllNotInFamily() {
        return chinService.getNumberOfAllNotInFamily();
    }

}
