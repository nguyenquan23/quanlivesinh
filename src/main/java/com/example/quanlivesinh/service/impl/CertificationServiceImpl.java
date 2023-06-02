package com.example.quanlivesinh.service.impl;

import com.example.quanlivesinh.persistence.Certification;
import com.example.quanlivesinh.repository.CertificationRepository;
import com.example.quanlivesinh.service.CertificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificationServiceImpl implements CertificationService {
    CertificationRepository certificationRepository;

    @Autowired
    public void setCertificationRepository(CertificationRepository certificationRepository) {
        this.certificationRepository = certificationRepository;
    }

    @Override
    public List<Certification> getCertificationAll() {
        return certificationRepository.findAll();
    }

    @Override
    public Certification getOneCertification(Long id) {
        Optional<Certification> certificationOptional = certificationRepository.findById(id);
        return certificationOptional.orElse(null);
    }

    @Override
    public void deleteInspect(Long id) {
        certificationRepository.deleteById(id);
    }

    @Override
    public void updateStudent(Long id, String name, String describe) {
        certificationRepository.updateCertifition(id,name,describe);
    }

    @Override
    public void save(Certification certification) {
        certificationRepository.saveAndFlush(certification);

    }

}
