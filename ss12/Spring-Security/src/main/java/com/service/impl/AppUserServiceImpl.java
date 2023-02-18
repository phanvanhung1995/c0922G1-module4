package com.service.impl;

import com.model.AppUser;
import com.model.UserRole;
import com.repository.IAppRoleRepository;
import com.repository.IAppUserRepository;
import com.repository.IUserRoleRepository;
import com.service.IAppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements IAppUserService {

    @Autowired
    IAppUserRepository appUserRepository;

    @Autowired
    IAppRoleRepository appRoleRepository;

    @Autowired
    IUserRoleRepository userRoleRepository;


    @Override
    public void save(AppUser appUser) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        appUser.setPassword(bCryptPasswordEncoder.encode(appUser.getPassword()));

        appUser = appUserRepository.save(appUser);
        UserRole userRole = new UserRole();

        userRole.setAppRole(appRoleRepository.findById((long) 3).get());
        userRole.setAppUser(appUser);

        userRoleRepository.save(userRole);
    }
}

