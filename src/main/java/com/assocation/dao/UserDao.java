package com.assocation.dao;

import com.assocation.domain.Identity;
import com.assocation.domain.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    //登录
    @Select("select * from user where userName = #{userName} and userPassword = #{userPassword} and userIdentity = #{userIdentity}")
    User login(@Param("userName") String userName, @Param("userPassword") String userPassword, @Param("userIdentity") Identity userIdentity);

    //查询所有用户
    @Select("select * from user")
    List<User> findAll();

    //通过userId删除指定用户
    @Delete("delete from user where user_id = #{userId}")
    void deleteUserById(String userId);

    //多条件模糊查询（用户名+用户身份）
    @Select({"<script> SELECT * from user"
            +"<where>"
            +"<if test = \"user_name != null and user_name != ''\"> user_name like CONCAT('%',#{userName},'%')</if>"
            +"<if test = \"user_identity != null and user_identity != ''\"> user_identity = #{userIdentity}</if></where></script>"})
    List<User> findByNameAndIdentity(@Param("userName") String userName,@Param("userIdentity") Identity userIdentity);

}
