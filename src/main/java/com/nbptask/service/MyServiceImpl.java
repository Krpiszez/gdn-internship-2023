package com.nbptask.service;

import org.springframework.web.client.RestTemplate;

public class MyServiceImpl implements MyService {

    private final RestTemplate restTemplate;
    private final String baseUrl;

    public MyServiceImpl(RestTemplate restTemplate, String baseUrl) {
        this.restTemplate = restTemplate;
        this.baseUrl = baseUrl;
    }

    @Override
    public String fetchData() {
        String url = baseUrl + "/api/data";
        return restTemplate.getForObject(url, String.class);
    }
}
