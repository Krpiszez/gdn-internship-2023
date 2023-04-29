package com.nbptask.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public interface MyService {
    String fetchData(String table);

    Double getAvgExchangeRate(LocalDate date, String code);

    String getMaxAndMinNQuot(String code, Integer quotation);

    String majorBetweenBuyAndAskRate(String code, Integer quotation);
}
