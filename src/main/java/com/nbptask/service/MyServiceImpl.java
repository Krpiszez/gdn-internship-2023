package com.nbptask.service;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@Service
public class MyServiceImpl implements MyService {

    private final RestTemplate restTemplate;
    @Value("${api.base-url}")
    private String baseUrl;

    public MyServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public String fetchData(String table) {
        String url = baseUrl + "/tables/"+table;
        return restTemplate.getForObject(url, String.class);
    }

    @Override
    public Double getAvgExchangeRate(LocalDate date, String code) {
        String url = baseUrl + "/exchangerates/rates/A/" +code+"/"+date;
        String json = restTemplate.getForObject(url, String.class);
        JSONObject obj = new JSONObject(json);
        JSONArray arr = obj.getJSONArray("rates");
        return arr.getJSONObject(0).getDouble("mid");
    }

    @Override
    public String getMaxAndMinNQuot(String code, Integer quotation) {
        String url = baseUrl + "/exchangerates/rates/A/" + code + "/last/" + quotation;
        String json = restTemplate.getForObject(url, String.class);
        JSONObject obj = new JSONObject(json);
        JSONArray arr = obj.getJSONArray("rates");
        double minMid = Double.MAX_VALUE;
        double maxMid = Double.MIN_VALUE;

        for (int i = 0; i < arr.length(); i++) {
            JSONObject objIt = arr.getJSONObject(i);
            double mid = objIt.getDouble("mid");
            if (mid < minMid) {
                minMid = mid;
            }
            if (mid > maxMid) {
                maxMid = mid;
            }
        }
        JSONObject result = new JSONObject();
        result.put("Min Average Value For " + code, minMid);
        result.put("Max Average Value For " + code, maxMid);
        return result.toString();
    }

}

