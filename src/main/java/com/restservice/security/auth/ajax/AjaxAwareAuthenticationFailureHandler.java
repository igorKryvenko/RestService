package com.restservice.security.auth.ajax;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.restservice.error.AuthMethodNotSupportedException;
import com.restservice.error.JwtExpiredTokenException;

import com.restservice.model.response.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Igor on 11.03.2017.
 */
@Component
public class AjaxAwareAuthenticationFailureHandler implements AuthenticationFailureHandler {
    @Autowired
    private  ObjectMapper mapper;



    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {

        response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);

        if (e instanceof BadCredentialsException) {
            mapper.writeValue(response.getWriter(),new Response("Invalid username or password",HttpStatus.UNAUTHORIZED));
        } else if (e instanceof JwtExpiredTokenException) {
            mapper.writeValue(response.getWriter(), new Response("Token has expired", HttpStatus.UNAUTHORIZED));
        } else if (e instanceof AuthMethodNotSupportedException) {
            mapper.writeValue(response.getWriter(), new Response(e.getMessage(), HttpStatus.UNAUTHORIZED));
        }

        mapper.writeValue(response.getWriter(), new Response("Authentication failed", HttpStatus.UNAUTHORIZED));
    }
}
