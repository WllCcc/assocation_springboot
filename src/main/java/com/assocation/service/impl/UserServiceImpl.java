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
    public User login(String userName, String userPassword, Identity userIdentity) {
        return userDao.login(userName,userPassword,userIdentity);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public void deleteUserById(String userId) throws Exception {
        userDao.deleteUserById(userId);
    }

    @Override
    public List<User> findByNameAndIdentity(String userName, Identity userIdentity) {
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
    public void approveAssoEst(EstApproval estApproval) throws Exception {
        userDao.approveAssoEst(estApproval);
    }

    @Override
    public void approvalAssoAct(ActivityApproval actApproval) throws Exception{
        userDao.approvalAssoAct(actApproval);
    }

    @Override
    public void ratingAsso(Assocation assocation) throws Exception {
        userDao.ratingAsso(assocation);
    }
}
