package com.restservice.controller;

import com.restservice.model.Currency;
import com.restservice.service.CurrencyExchangeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URISyntaxException;
import java.util.List;

/**
 * Created by Igor on 10.01.2017.
 */
@RestController
@RequestMapping("/currencies")
public class CurrencyController {

    @Autowired
    CurrencyExchangeClient client;

    @RequestMapping
    public List<Currency> getListOfCurrencies() throws URISyntaxException {
        return client.findCurrencyByBase();
    }



}
