package com.example.quanlivesinh.service.impl;

import com.example.quanlivesinh.persistence.Store;
import com.example.quanlivesinh.repository.CertificationRepository;
import com.example.quanlivesinh.repository.StoreRepository;
import com.example.quanlivesinh.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    StoreRepository storeRepository;

    @Autowired
    public void setStoreRepository(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public List<Store> getStoreAll() {
        return storeRepository.findAll();
    }

    @Override
    public Store getOneStore(Long id) {
        return storeRepository.getStoreById(id);
    }
    @Transactional
    @Override
    public Store saveorupdate(Store store) {
        return storeRepository.saveAndFlush(store);
    }

    @Override
    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }

}
