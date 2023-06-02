package com.example.quanlivesinh.controller;

import com.example.quanlivesinh.persistence.Certification;
import com.example.quanlivesinh.persistence.Inspect;
import com.example.quanlivesinh.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Controller
public class CertificationController {
    private CertificationService certificationService;
    @Autowired
    public void setInspectService(CertificationService certificationService) {
        this.certificationService = certificationService;
    }
    @RequestMapping(value = "/informationCertification")
    public String getCertification(Model model){
        model.addAttribute("listCertification",certificationService.getCertificationAll());
        return "html/home";
        }
    @RequestMapping("/certification/edit/{id}")

    public String editCertification(@PathVariable Long id, Model model){
        System.out.println(certificationService.getOneCertification(id));
        model.addAttribute("certification", certificationService.getOneCertification(id) );
        return "html/home";
    }
    @RequestMapping("/certification/delete/{id}")
    public String deleteInspect(@PathVariable Long id){
        certificationService.deleteInspect(id);
        return "redirect:/informationCertification";

    }
    @RequestMapping("/add/certification")
    public String addCertification(Model model){
        model.addAttribute("certificationNew",new Certification());
        return "html/home";

    }
    @PostMapping("add/NewCertification")
    public String saveCertification(@ModelAttribute("certificationNew") Certification certification , @RequestParam("hinhAnh") MultipartFile hinhAnh) throws IOException {
        String fileName = StringUtils.cleanPath(hinhAnh.getOriginalFilename());
        Path path = Paths.get("src/main/resources/static/images/certification/" + fileName);
        Files.copy(hinhAnh.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        Certification certificationNew = new Certification();
        certificationNew.setName(certification.getName());
        certificationNew.setDescribe(certification.getDescribe());
        certificationNew.setImage("/images/certification/" + fileName);
        certificationService.save(certificationNew);
        return "redirect:/informationCertification";
    }

    @RequestMapping(value = "/getInformationCertification")
    public String getAllCertification(Model model){
        model.addAttribute("listCertification",certificationService.getCertificationAll());

        return "html/home-page";
    }

    @PostMapping("/certification")
    public String Update(Certification certification, Model model){
        certificationService.updateStudent(certification.getId(),certification.getName(),certification.getDescribe());
        model.addAttribute("listCertification",certificationService.getCertificationAll());
      return "redirect:/informationCertification";
    }

    }

