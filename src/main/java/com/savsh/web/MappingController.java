package com.savsh.web;

import com.savsh.entity.Chin;
import com.savsh.service.ChinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MappingController {

    @Autowired
    private ChinService service;

    @RequestMapping(value = {"/", "/home-page"}, method = RequestMethod.GET)
    public String hello() {
        return "home-page";
    }

    @RequestMapping(value = "/chins-page", method = RequestMethod.GET)
    public String chins() {
        return "chins-page";
    }

    @RequestMapping(value = "/chin", method = RequestMethod.GET)
    public String personalChinPage(@RequestParam("id") long id, Model model) {
        model.addAttribute("chinId", id);
        return "personal-chin-page";
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String registerChin() {
        return "register-page";
    }

    @RequestMapping(value = "/families-page", method = RequestMethod.GET)
    public String getFamilies() {
        return "families-page";
    }

    @RequestMapping(value = "/register-family-page", method = RequestMethod.GET)
    public String getRegisterPageForFamily() {
        return "register-family-page";
    }

    @RequestMapping(value = "/family", method = RequestMethod.GET)
    public String getPersonalFamilyPage(@RequestParam("number") long number, Model model) {
        model.addAttribute("familyNumber", number);
        return "family-personal-page";
    }
}
