
package com.example.quanlivesinh.repository;

import com.example.quanlivesinh.persistence.Certification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CertificationRepository extends JpaRepository<Certification,Long> {
}

