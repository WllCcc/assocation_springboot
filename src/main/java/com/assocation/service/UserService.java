package com.assocation.service;

import com.assocation.domain.*;

import java.util.List;

public interface UserService {

    User login(String userName, String userPassword);

    List<User> findAll();

    List<User> findUserById(String userId);

    List<User> findByNameAndIdentity(String userName, String userIdentity);

    void addUser(User user) throws Exception;

    void deleteUserById(String userId) throws Exception;

    void updateUser(User user) throws Exception;

    //社团评级
    void ratingAsso(Assocation assocation) throws Exception;
}
