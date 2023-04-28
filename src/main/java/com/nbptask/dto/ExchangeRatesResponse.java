package com.nbptask.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExchangeRatesResponse {
    private String table;
    private String currency;
    private String code;
    private List<Rate> rates;

    // getters and setters
}
