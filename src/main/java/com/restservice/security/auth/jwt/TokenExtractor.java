package com.restservice.security.auth.jwt;

/**
 * Created by Igor on 11.03.2017.
 */
public interface TokenExtractor {
    public String extract(String payload);
}
