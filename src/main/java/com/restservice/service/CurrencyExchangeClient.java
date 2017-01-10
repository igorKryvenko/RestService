package com.restservice.service;

import com.google.common.collect.ImmutableList;

import com.restservice.model.Currency;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Igor on 10.01.2017.
 */
@Component
public class CurrencyExchangeClient {


    private RestTemplate restTemplate = new RestTemplate();

    @Value("#{'${app.bases}'.split(',')}")
    private List<String> bases;

    @Value("${app.apiUrl}")
    private String apiUrl;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public List<Currency> findCurrencyByBase() {
        List<Currency> currencies = new LinkedList<>();
        for(String base : bases) {
           ResponseEntity<Currency> responseEntity =  restTemplate.getForEntity(apiUrl + base, Currency.class);
           currencies.add(responseEntity.getBody());
        }
        log.info("Objects",currencies);
        System.out.println(currencies);
        return ImmutableList.copyOf(currencies);

    }
}
