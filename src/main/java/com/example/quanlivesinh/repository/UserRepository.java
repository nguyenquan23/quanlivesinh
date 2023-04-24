package com.example.quanlivesinh.repository;

import com.example.quanlivesinh.enums.ERole;
import com.example.quanlivesinh.persistence.Role;
import com.example.quanlivesinh.persistence.User;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface UserRepository extends JpaRepository<User,Long> {

 // @Query("SELECT n.id, s.address,s.phone,s.gender,s.password,s.username,s.id FROM User s JOIN s.roles n  WHERE s.username = ?1")

  User findByUsername(String username);



}
