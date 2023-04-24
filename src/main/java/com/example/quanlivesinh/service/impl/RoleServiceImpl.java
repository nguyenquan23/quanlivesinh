package com.example.quanlivesinh.service.impl;

import com.example.quanlivesinh.enums.ERole;
import com.example.quanlivesinh.persistence.Role;
import com.example.quanlivesinh.repository.RoleRepository;
import com.example.quanlivesinh.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Optional<Role> getOneRole(ERole role) {
       return roleRepository.findByName(role);
    }
    @Override
    public Role getRole(Long id){
        return roleRepository.getById(id);
    }
}
