package com.restservice.model;

import java.util.Map;

/**
 * Created by Igor on 10.01.2017.
 */
public class Currency {
    private String base;
    private Map<String,Double> rates;

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "base='" + base + '\'' +
                ", rates=" + rates +
                '}';
    }
}
