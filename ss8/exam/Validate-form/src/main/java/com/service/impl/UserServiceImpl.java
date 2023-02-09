package com.service.impl;

import com.model.User;
import com.repository.IUserrepository;
import com.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
   private IUserrepository iUserrepository;

    @Override
    public List<User> findAll() {
        return iUserrepository.findAll();
    }

    @Override
    public void create(User user) {
        iUserrepository.save(user);
    }
}
