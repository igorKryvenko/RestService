package com.restservice.service;

import com.google.common.collect.ImmutableList;
import com.restservice.model.Role;
import com.restservice.model.User;
import com.restservice.resository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by Igor on 13.01.2017.
 */
@Service
public class UserService implements UserDetailsService {



    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return userRepository.findByUsername(s);
    }
}
