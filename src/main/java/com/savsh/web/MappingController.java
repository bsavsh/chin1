package com.savsh.web;

import com.savsh.service.ChinchillaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MappingController {
    @Autowired
    private ChinchillaService service;

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

    @RequestMapping(value = "/financies-page", method = RequestMethod.GET)
    public String getPageOfFinancies() {
        return "financies-page";
    }

    @RequestMapping(value = "/register-finance-page", method = RequestMethod.GET)
    public String getRegisterFinancePage() {
        return "register-finance-page";
    }
}
