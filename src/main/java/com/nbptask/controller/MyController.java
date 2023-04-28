package com.nbptask.controller;

import com.nbptask.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/fetch-data")
    public String fetchData() {
        return myService.fetchData();
    }
}
