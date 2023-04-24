package com.example.quanlivesinh.service;

import com.example.quanlivesinh.enums.ERole;
import com.example.quanlivesinh.persistence.Role;

import java.util.Optional;

public interface RoleService {
    public Optional<Role> getOneRole(ERole role);
    public Role getRole(Long id);
}
