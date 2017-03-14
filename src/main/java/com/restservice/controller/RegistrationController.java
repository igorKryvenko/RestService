package com.restservice.controller;


import com.restservice.dto.UserDto;
import com.restservice.error.UserAlreadyExistException;
import com.restservice.model.User;

import com.restservice.model.response.Response;
import com.restservice.service.UserService;

import com.restservice.util.OnRegistrationCompleteEvent;

import org.slf4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by Igor on 06.03.2017.
 */
@Controller
@RequestMapping("/api/auth/registration")
public class RegistrationController {
    private final Logger LOGGER = org.slf4j.LoggerFactory.getLogger(getClass());

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @RequestMapping( method = RequestMethod.POST)
    @ResponseBody
    public Response registerAccount(@RequestBody  UserDto userDto,HttpServletRequest request) throws ServletException {
        LOGGER.debug("Registration account with data: ",userDto);
        User registered;

        try{
            registered = userService.registerNewUser(userDto);

        }catch (UserAlreadyExistException e) {
            return new Response(e.getMessage(),HttpStatus.CONFLICT);
        }
        publisher.publishEvent(new OnRegistrationCompleteEvent(registered,request.getLocale(),getAppUrl(request)));
        request.login(registered.getEmail(),registered.getPassword());
        return new Response("success");
    }

    private String getAppUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }
}
