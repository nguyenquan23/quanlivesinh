
package com.example.quanlivesinh.repository;

import com.example.quanlivesinh.persistence.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends JpaRepository<Store,Long> {
    Store getStoreById(Long id);

    @Override
    void deleteById(Long id);
}

