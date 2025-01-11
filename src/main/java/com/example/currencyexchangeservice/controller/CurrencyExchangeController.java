package com.example.currencyexchangeservice.controller;

import com.example.currencyexchangeservice.dto.CurrencyExchangeResponse;
import com.example.currencyexchangeservice.repository.CurrencyExchangeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeRepository currencyExchangeRepository;


    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public CurrencyExchangeResponse retrieveCurrencyExchangeRate(@PathVariable() String from,
                                                                 @PathVariable String to) {
        final CurrencyExchangeResponse currencyExchangeResponse = currencyExchangeRepository.findByFromAndTo(from, to);
        if (null == currencyExchangeResponse) {
            throw new RuntimeException("Unable to find data for " + from + " to " + to);
        }

        currencyExchangeResponse.setEnvironment(environment.getProperty("local.server.port"));
        return currencyExchangeResponse;
    }
}
