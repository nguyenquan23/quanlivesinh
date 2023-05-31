package com.example.quanlivesinh.controller;

import com.example.quanlivesinh.persistence.Certification;
import com.example.quanlivesinh.persistence.Inspect;
import com.example.quanlivesinh.persistence.Store;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class StoreController {
    @PostMapping( "/add/shop")
    public String sd(@ModelAttribute("shopNew") Store store, @RequestParam("hinhAnh") MultipartFile hinhAnh)throws IOException {



        String fileName = StringUtils.cleanPath(hinhAnh.getOriginalFilename());
        System.out.println(fileName);

        Path path = Paths.get("src/main/resources/static/images/store/" + fileName);
        Files.copy(hinhAnh.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        System.out.println(store.getAddress());
        System.out.println(store.getName());
        System.out.println(store.isStatus());


        Store shopNew = new Store();
        shopNew.setName(store.getName());
        shopNew.setImage("/images/store/" + fileName);
        shopNew.setAddress(store.getAddress());
        shopNew.setStatus(store.isStatus());
        shopNew.setOperatingTime(store.getOperatingTime());
        shopNew.setPhone(store.getPhone());




        return "html/home";
    }
    @RequestMapping("form-add")
    public String addShop(Model model){
        model.addAttribute("shopNew",new Store());
        return "html/form-add-shop";
    }
    @RequestMapping("informationStore")
    public String getStore(){
       return "html/home";
    }
}
