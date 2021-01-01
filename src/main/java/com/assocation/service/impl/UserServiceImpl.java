package com.assocation.service.impl;

import com.assocation.dao.UserDao;
import com.assocation.domain.*;
import com.assocation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService{

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(String userName, String userPassword) {
        return userDao.login(userName,userPassword);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public List<User> findUserById(String userId) {
        return userDao.findUserById(userId);
    }

    @Override
    public void deleteUserById(String userId) throws Exception {
        userDao.deleteUserById(userId);
    }

    @Override
    public List<User> findByNameAndIdentity(String userName, String userIdentity) {
        return userDao.findByNameAndIdentity(userName,userIdentity);
    }

    @Override
    public void addUser(User user) throws Exception {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userDao.updateUser(user);
    }

    @Override
    public void ratingAsso(Assocation assocation) throws Exception {
        userDao.ratingAsso(assocation);
    }
}
