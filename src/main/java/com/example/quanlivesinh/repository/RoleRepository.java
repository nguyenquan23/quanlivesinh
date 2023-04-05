package com.example.quanlivesinh.repository;

import com.example.quanlivesinh.enums.ERole;
import com.example.quanlivesinh.persistence.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
    Optional<Role> findByName(ERole name);

}
