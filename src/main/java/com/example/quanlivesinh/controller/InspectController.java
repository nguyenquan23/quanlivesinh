package com.example.quanlivesinh.controller;


import com.example.quanlivesinh.persistence.Inspect;
import com.example.quanlivesinh.persistence.Role;

import com.example.quanlivesinh.service.InspectService;
import com.example.quanlivesinh.service.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class InspectController {
    private InspectService inspectService;
    private RoleService roleService;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    @Autowired
    public void setInspectService(InspectService inspectService) {
        this.inspectService = inspectService;
    }
    @Autowired
    public void setRoleService(RoleService roleService){this.roleService = roleService;}

    @RequestMapping(value = "/informationInspect")
    public String getInspect(Model model){

        System.out.println(inspectService.listAllInspect().size());

       model.addAttribute("listInspect", inspectService.listAllInspect());

        return "html/home";
    }
    @RequestMapping("/inspect/edit/{id}")

    public String editInspect(@PathVariable Long id, Model model){

        model.addAttribute("inspect", inspectService.getOneInspect(id) );
        return "html/home";
    }
    @RequestMapping("/inspect/delete/{id}")
    public String deleteInspect(@PathVariable Long id){
        inspectService.deleteInspect(id);
        return "redirect:/informationInspect";

    }


    @PostMapping("/inspect")
    public  String update(Inspect inspect, Model model){

        inspectService.updateInspect(inspect.getId(), inspect.getUsername(),inspect.getGender(),inspect.getPhone(),inspect.getAddress());
        model.addAttribute("listInspect", inspectService.listAllInspect());
        return  "redirect:/informationInspect";

    }
    @RequestMapping("/add")
    public  String add(Model model){
        model.addAttribute("inspectNew",new Inspect());
        return "html/home";
    }
    @PostMapping("inspect/add")
    public  String save(Inspect inspect){

        Role role = roleService.getRole(2L);
        inspect.getRoles().add(role);
        String passCode = passwordEncoder.encode(inspect.getPassword());
        inspect.setPassword(passCode);
        inspectService.save(inspect);
        return   "redirect:/informationInspect";
    }
}
