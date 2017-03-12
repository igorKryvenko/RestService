package com.restservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Igor on 11.03.2017.
 */
@Configuration
public class JwtConfig {
    /**
     * {@link JwtToken} will expire after this time.
     */
    private Integer tokenExpirationTime = 15;

    /**
     * Token issuer.
     */
    private String tokenIssuer = "http://svlada.com";

    /**
     * Key is used to sign {@link com.restservice.model.token.JwtToken}.
     */
    private String tokenSigningKey = "xm8EV6Hy5RMFK4EEACIDAwQus";

    /**
     * {@link JwtToken} can be refreshed during this timeframe.
     */
    private Integer refreshTokenExpTime = 60;

    public Integer getRefreshTokenExpTime() {
        return refreshTokenExpTime;
    }

    public void setRefreshTokenExpTime(Integer refreshTokenExpTime) {
        this.refreshTokenExpTime = refreshTokenExpTime;
    }

    public Integer getTokenExpirationTime() {
        return tokenExpirationTime;
    }

    public void setTokenExpirationTime(Integer tokenExpirationTime) {
        this.tokenExpirationTime = tokenExpirationTime;
    }

    public String getTokenIssuer() {
        return tokenIssuer;
    }
    public void setTokenIssuer(String tokenIssuer) {
        this.tokenIssuer = tokenIssuer;
    }

    public String getTokenSigningKey() {
        return tokenSigningKey;
    }

    public void setTokenSigningKey(String tokenSigningKey) {
        this.tokenSigningKey = tokenSigningKey;
    }
}
