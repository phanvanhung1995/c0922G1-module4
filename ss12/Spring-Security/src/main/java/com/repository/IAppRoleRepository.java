package com.repository;

import com.model.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppRoleRepository extends JpaRepository<AppRole,Long> {
}
