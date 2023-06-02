
package com.example.quanlivesinh.service.impl;

import com.example.quanlivesinh.persistence.User;
//import com.example.quanlivesinh.repository.HihiRepository;
import com.example.quanlivesinh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
@Autowired
UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {



        User user = userRepository.findByUsername(username);

        System.out.println(user);
        return UserDetailsImpl.build(user);
    }
}

