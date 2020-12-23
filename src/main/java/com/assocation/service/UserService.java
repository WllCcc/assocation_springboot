package com.assocation.service;

import com.assocation.domain.Identity;
import com.assocation.domain.User;

import java.util.List;

public interface UserService {

    User login(String userName, String userPassword, Identity userIdentity);

    List<User> findAll();

    void deleteUserById(String userId) throws Exception;

    List<User> findByNameAndIdentity(String userName,Identity userIdentity);

    void addUser(User user);

    void updateUser(User user) throws Exception;
}
