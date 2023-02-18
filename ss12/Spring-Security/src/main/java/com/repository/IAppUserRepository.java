package com.repository;

import com.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findByUsername(String username);
}
