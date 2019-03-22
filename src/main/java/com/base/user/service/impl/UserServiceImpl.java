package com.base.user.service.impl;

import com.base.user.dao.IUserDao;
import com.base.user.module.User;
import com.base.user.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service("userServiceImpl")
public class UserServiceImpl implements IUserService {

    @Resource
    private IUserDao userDaoImpl;


    public void add(User user) {
        user.setCreateDate(new Date());
        this.userDaoImpl.addUser(user);
    }

    public void deleteById(String id) {
        this.userDaoImpl.deleteById(id);
    }

    public void update(User user) {
        this.userDaoImpl.updateUser(user);
    }

    public User findById(String id) {
        User user = this.userDaoImpl.findById(id);
        return user;
    }

    public List<User> findAll() {
        List<User> list = this.userDaoImpl.findAll();
        return list;
    }

}
