package com.example.quanlivesinh.service.impl;

import com.example.quanlivesinh.enums.ERole;
import com.example.quanlivesinh.persistence.Inspect;
import com.example.quanlivesinh.persistence.Role;
import com.example.quanlivesinh.repository.InspectRepository;
import com.example.quanlivesinh.service.InspectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
@Service
public class InspectServiceImpl implements InspectService {
    InspectRepository inspectRepository;
    @Autowired
    public void setInspectRepository(InspectRepository productRepository) {
        this.inspectRepository = productRepository;
    }
    @Override
    public List<Inspect> listAllInspect() {
        return inspectRepository.findAll().stream().filter(inspect -> {

          List<Role> l = new ArrayList<>(inspect.getRoles());
            System.out.println(l.size());
            System.out.println(l.get(0).getName());

          return l.get(0).getName().equals(ERole.ROLE_INSPECT);
         }
        ).toList();
    }
    @Override
    public Inspect getOneInspect(Long id){
        return  inspectRepository.getInspectsById(id);

    }
    @Override
    @Transactional
    public void updateInspect(Long id, String username, boolean gender, Integer phone, String address) {
        inspectRepository.updateInspect(id,username,gender,phone,address);

    }

    @Override
    public void deleteInspect(Long id) {
        inspectRepository.deleteById(id);
    }

    @Override
    public Inspect save(Inspect inspect){
        return inspectRepository.saveAndFlush(inspect);
    }

}
