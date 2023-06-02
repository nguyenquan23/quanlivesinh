package com.example.quanlivesinh.service;

import com.example.quanlivesinh.persistence.Store;

import java.util.List;

public interface StoreService {
    List<Store> getStoreAll();
    Store getOneStore(Long id);
    Store saveorupdate(Store store);
    void deleteStore(Long id);
    /*void updateStore(Store store)*/
}
