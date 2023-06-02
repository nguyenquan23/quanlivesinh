
package com.example.quanlivesinh.repository;

import com.example.quanlivesinh.persistence.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationRepository extends JpaRepository<Certification,Long> {
    Certification getCertificationById(Long id);
    void deleteById(Long id);

    @Modifying
    @Query("UPDATE Certification c SET c.name = :name ,c.describe = :describe WHERE c.id = :id")
    void updateCertifition(@Param("id") Long id, @Param("name") String name, @Param("describe") String describe);
}

