package com.restservice.service;

import com.restservice.dto.UserDto;
import com.restservice.error.UserAlreadyExistException;
import com.restservice.model.Role;
import com.restservice.model.User;
import com.restservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Igor on 03.03.2017.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerNewUser(UserDto userDto) {
        if(emailExist(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is account with this email" + userDto.getEmail());
        }
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        List<Role> role = new ArrayList<>();
        role.add(new Role("ROLE_USER"));
        user.setAuthorities(role);
        return userRepository.save(user);
    }
    private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email);
        if (user != null) {
            return true;
        }
        return false;
    }
}
