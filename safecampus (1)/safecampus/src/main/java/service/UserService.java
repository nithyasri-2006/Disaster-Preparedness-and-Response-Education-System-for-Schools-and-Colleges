package com.safecampus.safecampus.service;

import com.safecampus.safecampus.model.User;
import com.safecampus.safecampus.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User register(User user){
        return userRepository.save(user);
    }

    public User login(String username,String password){

        User user = userRepository.findByUsername(username);

        if(user != null && user.getPassword().equals(password)){
            return user;
        }

        return null;
    }
}