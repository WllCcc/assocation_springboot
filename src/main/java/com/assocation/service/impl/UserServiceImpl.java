package com.assocation.service.impl;

import com.assocation.dao.UserDao;
import com.assocation.domain.Identity;
import com.assocation.domain.User;
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
    public User login(String userName, String userPassword, Identity userIdentity) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void deleteUserById(String userId) throws Exception {

    }

    @Override
    public List<User> findByNameAndIdentity(String userName, Identity userIdentity) {
        return null;
    }

    @Override
    public void addUser(User user) {

    }

    @Override
    public void updateUser(User user) throws Exception {

    }
}
