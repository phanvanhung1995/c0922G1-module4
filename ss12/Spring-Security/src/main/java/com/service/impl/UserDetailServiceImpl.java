package com.service.impl;

import com.model.AppUser;
import com.model.UserRole;
import com.repository.IAppUserRepository;
import com.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    IAppUserRepository appUserRepository;

    @Autowired
    IUserRoleRepository userRoleRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = appUserRepository.findByUsername(username);

        if (appUser == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }

        List<UserRole> userRoleList = userRoleRepository.findAllByAppUser(appUser);

        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        if (userRoleList != null) {
            for (UserRole userRole : userRoleList) {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(userRole.getAppRole().getName());
                grantedAuthorityList.add(grantedAuthority);
            }
        }

        UserDetails userDetails = new User(appUser.getUsername(), appUser.getPassword(), grantedAuthorityList);

        return userDetails;
    }
}
