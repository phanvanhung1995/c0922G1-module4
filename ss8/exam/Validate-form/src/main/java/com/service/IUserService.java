package com.service;

import com.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void create(User user);

    boolean checkEmail(String email);
    Page<User> findAllByLastNameAndAge(String name, String age, Pageable pageable);
}
