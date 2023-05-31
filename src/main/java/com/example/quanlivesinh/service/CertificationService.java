package com.example.quanlivesinh.service;

import com.example.quanlivesinh.persistence.Certification;

import java.util.List;

public interface CertificationService {
    List<Certification> getCertificationAll();
    Certification getOneCertification(Long id);
    void deleteInspect(Long id);
    public void updateStudent(Long id, String name, String describe) ;
    public void save(Certification certification);
}
