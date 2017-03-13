package com.restservice.service;

import com.restservice.dto.UserDto;
import com.restservice.error.UserAlreadyExistException;
import com.restservice.model.Role;
import com.restservice.model.User;
import com.restservice.repository.RoleRepository;
import com.restservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Igor on 03.03.2017.
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    public User registerNewUser(UserDto userDto) {
        if(emailExist(userDto.getEmail())) {
            throw new UserAlreadyExistException("There is account with this email " + userDto.getEmail());
        }
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        String password = encoder.encode(userDto.getPassword());
        user.setPassword(password);
        user.setEmail(userDto.getEmail());
        List<Role> roleList = new ArrayList<>();
        Role role = new Role("ROLE_USER");

        roleList.add(roleRepository.save(role));
        user.setAuthorities(roleList);
        return userRepository.save(user);
    }
    private boolean emailExist(String email) {
        User user = userRepository.findByEmail(email).orElse(null);
        if (user != null) {
            return true;
        }
        return false;
    }
    public Optional<User> findByEmail(String email) {
        return this.userRepository.findByEmail(email);
    }
}
