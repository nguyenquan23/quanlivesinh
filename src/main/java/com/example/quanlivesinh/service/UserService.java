package com.example.quanlivesinh.service;

import com.example.quanlivesinh.persistence.User;
import org.springframework.beans.factory.annotation.Autowired;


public interface UserService {
    public User save(User user);

}
