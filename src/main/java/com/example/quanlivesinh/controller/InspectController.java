package com.example.quanlivesinh.controller;

import com.example.quanlivesinh.persistence.Inspect;
import com.example.quanlivesinh.service.InspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class InspectController {
    private InspectService inspectService;

    @Autowired
    public void setProductService(InspectService inspectService) {
        this.inspectService = inspectService;
    }
    @RequestMapping(value = "/informationInspect")
    public String getInspect(Model model){

       model.addAttribute("listInspect", inspectService.listAllInspect());

        return "html/home";
    }
}
