package com.base.user.dao;

import com.base.user.module.User;

import java.util.List;


public interface IUserDao {

    void addUser(User user);

    void deleteById(String id);

    void updateUser(User user);

    User findById(String id);

    List<User> findAll();

}
