package com.service;

import com.model.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();

    void create(User user);

    boolean checkEmail(String email);
}
