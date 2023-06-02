package com.example.quanlivesinh.controller;


import com.example.quanlivesinh.persistence.Certification;
import com.example.quanlivesinh.persistence.Store;
import com.example.quanlivesinh.repository.CertificationRepository;
import com.example.quanlivesinh.repository.StoreRepository;
import com.example.quanlivesinh.service.CertificationService;
import com.example.quanlivesinh.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.EntityManager;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class StoreController {
    CertificationRepository certificationRepository;

    @Autowired
    public void setCertificationRepository(CertificationRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }
    StoreRepository storeRepository;

    @Autowired
    public void setStoreRepository(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }
    private StoreService storeService;
    @Autowired
    public void setInspectService(StoreService storeService) {
        this.storeService = storeService;
    }
    private CertificationService certificationService;
    @Autowired
    public void setInspectService(CertificationService certificationService) {
        this.certificationService = certificationService;
    }

   /* @PostMapping( "/add/shop")
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
    }*/
    @RequestMapping("form-add")
    public String addShop(Model model){
        model.addAttribute("shopNew",new Store());
        return "html/form-add-shop";
    }
    @RequestMapping("informationStore")
    public String getAllStore(  Model model){
        model.addAttribute("listStore",storeService.getStoreAll());
        System.out.println(storeService.getStoreAll().get(0));
        return "html/home";


            }
    @RequestMapping("/store/edit/{id}")

    public String editCertification(@PathVariable Long id, Model model){
        model.addAttribute("certifications",certificationService.getCertificationAll());
        model.addAttribute("store", storeService.getOneStore(id) );
        return "html/home";
    }
@Transactional
    @PostMapping("/store")
    public String processForm(@ModelAttribute("store") Store store,
                              @RequestParam(value = "certifications", required = false) List<Long> selectedCertifications) {
        Store storeNew = storeService.getOneStore(store.getId());
        for(Certification certification :storeNew.getCertifications()){
            certification.getStores().remove(store);
        }

        store.getCertifications().clear();

         storeService.saveorupdate(store);
         for(Long id : selectedCertifications){
             store.getCertifications().add(certificationService.getOneCertification(id));
             certificationService.getOneCertification(id).getStores().add(store);
         }
        storeService.saveorupdate(store);

        return "redirect:/informationStore";
    }
    @RequestMapping("/add/store")
    public String addCertification(Model model){
        model.addAttribute("certifications",certificationService.getCertificationAll());
        model.addAttribute("storeNew",new Store());
        return "html/home";

    }
    @PostMapping("/addStore")
    public String addStore(@ModelAttribute("storeNew") Store store, @RequestParam(value = "certifications", required = false) List<Long> selectedCertifications,@RequestParam("hinhAnh") MultipartFile hinhAnh) throws IOException{
        String fileName = StringUtils.cleanPath(hinhAnh.getOriginalFilename());
        Path path = Paths.get("src/main/resources/static/images/store/" + fileName);
        Files.copy(hinhAnh.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);
        store.setImage("/images/store/" + fileName);
        if (selectedCertifications != null) {
            for (Long certificationId : selectedCertifications) {
                Certification certification = certificationService.getOneCertification(certificationId);
                store.getCertifications().add(certification);
                certification.getStores().add(store);

            }
        }

        storeService.saveorupdate(store);
        return "redirect:/informationStore";

    }
    @RequestMapping("/store/delete/{id}")
    public String deleteInspect(@PathVariable Long id){
        storeService.deleteStore(id);
        return "redirect:/informationStore";

    }
    @RequestMapping("getInformationStore")
    public String getAllStores(Model model){
        model.addAttribute("listStore",storeService.getStoreAll());
        return "html/home-page";
    }

}
