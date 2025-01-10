package com.example.currencyexchangeservice.controller;

import com.example.currencyexchangeservice.dto.CurrencyExchangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeResponse retrieveCurrencyExchangeRate(@PathVariable() String from,
                                                                 @PathVariable String to) {
        final CurrencyExchangeResponse currencyExchangeResponse =
                new CurrencyExchangeResponse(1000L, from, to, BigDecimal.valueOf(65));
        currencyExchangeResponse.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchangeResponse;
    }
}
