package com.example.currencyexchangeservice.repository;

import com.example.currencyexchangeservice.dto.CurrencyExchangeResponse;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyExchangeRepository extends JpaRepository<CurrencyExchangeResponse, Long> {

    CurrencyExchangeResponse findByFromAndTo(String from, String to);
}
