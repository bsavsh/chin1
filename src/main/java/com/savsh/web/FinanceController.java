package com.savsh.web;

import com.savsh.entity.Finance;
import com.savsh.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/financies")
public class FinanceController {

    @Autowired
    private FinanceService financeService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<Finance> getAllFinancies() {
        return financeService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Finance getFinanceById(@PathVariable long id) {
        return financeService.getFinanceById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteFinance(@PathVariable long id) {
        financeService.deleteFinance(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public Finance updateFinance(@Valid @RequestBody Finance finance) {
        return financeService.updateFinance(finance);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Finance insertFinance(@Valid @RequestBody Finance finance) {
        return financeService.insertFinance(finance);
    }
}
