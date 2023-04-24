package com.example.quanlivesinh.repository;

import com.example.quanlivesinh.persistence.Inspect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InspectRepository extends JpaRepository<Inspect,Long> {


    Inspect getInspectsById(Long id);
    Inspect saveAndFlush(Inspect inspect);
    @Modifying
    @Query("update Inspect  u set u.username = :newName , u.gender = :newGender , u.phone = :newPhone , u.address = :newAddress where u.id = :newId")
    void updateInspect(@Param("newId") Long id, @Param("newName") String username, @Param("newGender") boolean gender , @Param("newPhone") Integer phone, @Param("newAddress") String address );

    @Override
    void deleteById(Long id);
}
