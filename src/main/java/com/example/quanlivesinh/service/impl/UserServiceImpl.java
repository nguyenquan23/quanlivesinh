package com.example.quanlivesinh.service.impl;

import com.example.quanlivesinh.persistence.User;
import com.example.quanlivesinh.repository.InspectRepository;
import com.example.quanlivesinh.repository.UserRepository;
import com.example.quanlivesinh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    @Autowired
    public void setUserRepository (UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return  userRepository.save(user);
    }
}
