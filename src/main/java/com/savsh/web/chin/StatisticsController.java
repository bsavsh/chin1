package com.savsh.web.chin;

import com.savsh.service.ChinchillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/statistics")
public class StatisticsController {
    @Autowired
    private ChinchillaService chinchillaService;

    @RequestMapping(value = "/number-of-all-chins", method = RequestMethod.GET)
    public int getNumberOfAllChins() {
        return chinchillaService.getNumberOfAllChins();
    }

    @RequestMapping(value = "/number-of-females-in-family", method = RequestMethod.GET)
    public int getNumberOfFemalesInFamily() {
        return chinchillaService.getNumberOfFemalesInFamily();
    }

    @RequestMapping(value = "/number-of-males-in-family", method = RequestMethod.GET)
    public int getNumberOfMalesInFamily() {
        return chinchillaService.getNumberOfMalesInFamily();
    }

    @RequestMapping(value = "/number-of-all-not-in-family", method = RequestMethod.GET)
    public int getNumberOfAllNotInFamily() {
        return chinchillaService.getNumberOfAllNotInFamily();
    }

}
