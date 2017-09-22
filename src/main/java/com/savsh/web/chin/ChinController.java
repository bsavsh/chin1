package com.savsh.web.chin;

import com.savsh.dto.ChinDto;
import com.savsh.entity.Chinchilla;
import com.savsh.service.ChinchillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/chins")
public class ChinController {
    @Autowired
    private ChinchillaService chinchillaService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<ChinDto> allChins() {
        return chinchillaService.findAll();
    }

    @RequestMapping(value = "/query", method = RequestMethod.GET)
    public Iterable<ChinDto> getChinsByQuery(@RequestParam(value = "gender", required = false) String gender,
                                                @RequestParam(value = "color", required = false) String color,
                                                @RequestParam(value = "bornAfter", required = false) String bornAfter,
                                                @RequestParam(value = "bornBefore", required = false) String bornBefore,
                                                @RequestParam(value = "inFamily", required = false) String inFamily) {
        return chinchillaService.findAllWithQuery(gender, color, bornAfter, bornBefore, inFamily);
    }
//
//    @RequestMapping(value = "/sold", method = RequestMethod.GET)
//    public Iterable<Chinchilla> getSoldChins() {
//        return chinchillaService.getSoldChins();
//    }

//    @RequestMapping(value = "/deceased", method = RequestMethod.GET)
//    public Iterable<Chinchilla> getDeceasedChins() {
//        return chinchillaService.getDeceasedChins();
//    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ChinDto getChinById(@PathVariable long id) {
        return new ChinDto(chinchillaService.getChinById(id));
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteChinById(@PathVariable long id) {
        chinchillaService.deleteChinById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Chinchilla updateChin(@Valid @RequestBody Chinchilla chin) {
        return chinchillaService.updateChin(chin);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Chinchilla insertChin(@Valid @RequestBody Chinchilla chin) {
        return chinchillaService.insertChin(chin);
    }
}
