package com.nbptask.controller;

import com.nbptask.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/exchangerates")
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/tables/{table}")
    public String fetchData(@PathVariable("table") String table) {
        return myService.fetchData(table);
    }

    @GetMapping("/{currencyCode}/A/{date}")
    public Double getAvgExchangeRate(@PathVariable("date") @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date,
                                                     @PathVariable("currencyCode") String code){
        return myService.getAvgExchangeRate(date, code);
    }

    @GetMapping("/A/{code}/{quotation}")
    public String getMaxAndMin(@PathVariable("code") String code, @PathVariable("quotation") Integer quotation){
        return myService.getMaxAndMinNQuot(code, quotation);
    }

    @GetMapping("/C/{code}/{quotation}")
    public String majorBetweenBuyAndAskRate(@PathVariable("code") String code, @PathVariable("quotation") Integer quotation){
        return myService.majorBetweenBuyAndAskRate(code, quotation);
    }
}
