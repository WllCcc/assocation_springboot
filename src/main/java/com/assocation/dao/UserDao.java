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
            +"<if test = \"user_name != null and user_name != ''\"> user_name like CONCAT('%',#{userName},'%')</if>"
            +"<if test = \"user_identity != null and user_identity != ''\"> user_identity = #{userIdentity}</if></where></script>"})
    List<User> findByNameAndIdentity(@Param("userName") String userName,@Param("userIdentity") String userIdentity);

    @Insert("insert into user(user_id,user_name,user_sex,user_grade,user_class,user_college,user_assocation,user_password,user_repassword,user_phone,user_identity)"
            + "values(#{userId},#{userName},#{userSex},#{userGrade},#{userClass},#{userCollege},#{userAssocation},#{userPassword},#{userRePassword},#{userPhone},#{userIdentity})")
    void addUser(User user) throws Exception;

    //通过userId删除指定用户
    @Delete("delete from user where user_id = #{userId}")
    void deleteUserById(@Param("userId") String userId) throws Exception;

    //更新用户信息
    @Update("update user set user_name = #{userName},user_sex = #{userSex},user_grade = #{userGrade},user_class = #{userClass},user_college=#{userCollege},"
            +"user_assocation=#{userAssocation},user_password=#{userPassword},user_repassword=#{userRePassword},user_phone=#{userPhone},user_identity=#{userIdentity}")
    void updateUser(User user) throws Exception;

    //社团创建申请,将社团创建申请插入数据库
    @Insert("insert into estapproval(est_asso_id,est_asso_name,est_asso_synopsis,est_asso_category,est_asso_status,est_asso_rank,est_application_date,est_approval_date,est_status,est_apply_id,est_approval_id) "
            + "values(#{assocationId},#{assocationName},#{assocationSynopsis},#{assocationCategory},#{assocationStatus},#{assocationRank},#{applicationDate},#{approvalDate},#{status},#{applyId},#{approvalId})")
    void applyAssoEst(EstApproval estApproval) throws Exception;

    //审批通过社团创建申请,将社团信息插入数据库
    @Insert("insert into assocation(asso_id,asso_name,asso_synopsis,asso_charge_id,asso_category,asso_estab_date,asso_status,asso_rank) "
            + " values(#{assocationId},#{assocationName},#{assocationSynopsis},#{applyId},#{assocationCategory},#{approvalDate},#{assocationStatus},#{assocationRank})")
    void approveAssoEst(EstApproval estApproval) throws Exception;

    //审批通过社团活动申请
    @Insert("insert into activity(act_id,act_asso_id,act_name,act_theme,act_content,act_number,act_date,act_location,act_cost) "
            + "values(#{activityId},#{activityAssoId},#{activityName},#{activityTheme},#{activityContent},#{activityNumber},#{activityDate},#{activityLocation},'0')")
    void approvalAssoAct(ActivityApproval actApproval) throws Exception;

    //社团评级
    @Update("update assocation set asso_rank = #{assocationRank}")
    void ratingAsso(Assocation assocation) throws Exception;
}
