package com.base.user.service;

import com.base.user.module.User;

import java.util.List;


public interface IUserService {

    void add(User user);

    void deleteById(String id);

    void update(User user);

    User findById(String id);

    List<User> findAll();

}
