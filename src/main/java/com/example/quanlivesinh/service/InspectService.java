package com.example.quanlivesinh.service;

import com.example.quanlivesinh.persistence.Inspect;

import java.util.List;

public interface InspectService {
      List<Inspect> listAllInspect();
      Inspect getOneInspect(Long id);
      Inspect save(Inspect inspect);
      public void updateInspect(Long id, String username, boolean gender, Integer phone, String address);
      public void deleteInspect(Long id);


}
