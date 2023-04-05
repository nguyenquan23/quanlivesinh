package com.example.quanlivesinh.service;

import com.example.quanlivesinh.enums.ERole;
import com.example.quanlivesinh.persistence.Inspect;
import com.example.quanlivesinh.persistence.Role;
import com.example.quanlivesinh.repository.InspectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class InspectServiceImpl implements InspectService{
    InspectRepository inspectRepository;
    @Autowired
    public void setInspectRepository(InspectRepository productRepository) {
        this.inspectRepository = productRepository;
    }
    @Override
    public List<Inspect> listAllInspect() {
        return inspectRepository.findAll().stream().filter(inspect -> {
          List<Role> l = new ArrayList<>(inspect.getRoles());
          return l.get(0).getName().equals(ERole.ROLE_INSPECT);
         }
        ).toList();
    }
}
