package com.assocation.dao;

import com.assocation.domain.*;
import org.apache.ibatis.annotations.*;
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

    //多条件模糊查询（用户名+用户身份）
    @Select({"<script> SELECT * from user"
            +"<where>"
            +"<if test = \"user_name != null and user_name != ''\"> user_name like CONCAT('%',#{userName},'%')</if>"
            +"<if test = \"user_identity != null and user_identity != ''\"> user_identity = #{userIdentity}</if></where></script>"})
    List<User> findByNameAndIdentity(@Param("userName") String userName,@Param("userIdentity") Identity userIdentity);

    @Insert("insert into user(user_id,user_name,user_sex,user_grade,user_class,user_college,user_assocation,user_password,user_repassword,user_phone,user_identity)"
            + "values(#{userId},#{userName},#{userSex},#{userGrade},#{userClass},#{userCollege},#{userAssocation},#{userPassword},#{userRePassword},#{userPhone},#{userIdentity})")
    void addUser(User user) throws Exception;

    //通过userId删除指定用户
    @Delete("delete from user where user_id = #{userId}")
    void deleteUserById(String userId) throws Exception;

    //更新用户信息
    @Update("update user set user_name = #{userName},user_sex = #{userSex},user_grade = #{userGrade},user_class = #{userClass},user_college=#{userCollege},"
            +"user_assocation=#{userAssocation},user_password=#{userPassword},user_repassword=#{userRePassword},user_phone=#{userPhone},user_identity=#{userIdentity}")
    void updateUser(User user) throws Exception;

    //审批通过社团创建申请,将社团信息插入数据库
    @Insert("insert into assocation(asso_id,asso_name,asso_synopsis,asso_charge_id,asso_category,asso_estab_date,asso_status,asso_rank) "
            + " values(#{assocationId},#{assocationName},#{assocationSynopsis},#{applyId},null,#{approvalDate},'NORMAL',null)")
    void approveAssoEst(EstApproval estApproval) throws Exception;

    //审批通过社团活动申请
    @Insert("insert into activity(act_id,act_asso_id,act_name,act_theme,act_content,act_number,act_date,act_location,act_cost) "
            + "values(#{activityId},#{activityAssoId},#{activityName},#{activityTheme},#{activityContent},#{activityNumber},#{activityDate},#{activityLocation},'0')")
    void approvalAssoAct(ActivityApproval actApproval) throws Exception;

    //社团评级
    @Update("update assocation set asso_rank = #{assocationRank}")
    void ratingAsso(Assocation assocation) throws Exception;
}
