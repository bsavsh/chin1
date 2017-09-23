package com.savsh.web.sellChin;

import com.savsh.dto.FinanceRowDto;
import com.savsh.entity.SellChin;
import com.savsh.service.SellChinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/financies")
public class SellChinController {
    @Autowired
    private SellChinService sellChinService;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<FinanceRowDto> getAllSellChinOrders() {
        return sellChinService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public FinanceRowDto getFinanceById(@PathVariable long id) {
        return sellChinService.getOrderById(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteFinance(@PathVariable long id) {
        sellChinService.deleteOrder(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public SellChin updateFinance(@Valid @RequestBody SellChin sellChin) {
        return sellChinService.updateOrder(sellChin);
    }

    @RequestMapping(method = RequestMethod.POST)
    public SellChin insertFinance(@Valid @RequestBody SellChin order) {
        return sellChinService.insertOrder(order);
    }
}
