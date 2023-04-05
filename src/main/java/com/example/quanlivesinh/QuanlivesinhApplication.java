package com.example.quanlivesinh;

import com.example.quanlivesinh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuanlivesinhApplication {
@Autowired
UserRepository userRepository;

    public static void main(String[] args) {


        SpringApplication.run(QuanlivesinhApplication.class, args);
    }

}
