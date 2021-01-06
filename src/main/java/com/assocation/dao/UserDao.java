package com.assocation.dao;

import com.assocation.domain.*;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    //登录
    @Select("select * from user where user_name = #{userName} and user_password = #{userPassword}")
    User login(@Param("userName") String userName, @Param("userPassword") String userPassword);

    //查询所有用户
    @Select("select * from user")
    List<User> findAll();

    @Select("select * from user where user_id = #{userId}")
    List<User> findUserById(@Param("userId") String userId);

    //多条件模糊查询（用户名+用户身份）
    @Select({"<script> SELECT * from user"
            +"<where>"
            +"<if test = \"userName != null and userName != ''\"> user_name like CONCAT('%',#{userName},'%')</if>"
            +"<if test = \"userIdentity != null and userIdentity != ''\"> user_identity = #{userIdentity}</if></where></script>"})
    List<User> findByNameAndIdentity(@Param("userName") String userName,@Param("userIdentity") String userIdentity);

    @Insert("insert into user(user_id,user_name,user_sex,user_grade,user_class,user_college,user_assocation,user_password,user_repassword,user_phone,user_identity)"
            + "values(#{userId},#{userName},#{userSex},#{userGrade},#{userClass},#{userCollege},#{userAssocation},#{userPassword},#{userRePassword},#{userPhone},#{userIdentity})")
    void addUser(User user) throws Exception;

    //通过userId删除指定用户
    @Delete("delete from user where user_id = #{userId}")
    void deleteUserById(@Param("userId") String userId) throws Exception;

    //更新用户信息
    @Update("update user set user_name = #{userName},user_sex = #{userSex},user_grade = #{userGrade},user_class = #{userClass},user_college=#{userCollege},"
            +"user_assocation=#{userAssocation},user_phone=#{userPhone},user_identity=#{userIdentity} where user_id = #{userId}")
    void updateUser(User user) throws Exception;

    //社团评级
    @Update("update assocation set asso_rank = #{assocationRank}")
    void ratingAsso(Assocation assocation) throws Exception;
}
