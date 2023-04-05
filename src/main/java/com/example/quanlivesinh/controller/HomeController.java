package com.example.quanlivesinh.controller;

import com.example.quanlivesinh.persistence.User;

import com.example.quanlivesinh.security.SecurityConfig;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {
    @RequestMapping(value="/login" )
    public String login(){
       return "html/login";
    }


    @RequestMapping(value ="/home")
       public String loginSuccess(){
        return "html/home";

       }


}
