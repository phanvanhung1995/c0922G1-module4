package com.repository;

import com.model.AppUser;
import com.model.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IUserRoleRepository extends JpaRepository<UserRole, Long> {


    List<UserRole> findAllByAppUser(AppUser appUser);
}
