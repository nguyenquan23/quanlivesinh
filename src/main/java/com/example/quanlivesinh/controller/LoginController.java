package com.example.quanlivesinh.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {
    @RequestMapping(value="/login" )
    public String login(){
       return "html/login";
    }


    @RequestMapping(value ="/home")
       public String loginSuccess(){
        return "html/home";

       }



}
