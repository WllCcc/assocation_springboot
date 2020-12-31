package com.assocation.dao;

import com.assocation.domain.Activity;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityDao {

    //查询所有社团活动
    @Select("select * from activity")
    List<Activity> findAll();

    //通过活动编号查询指定活动
    @Select("select * from activity where act_id = #{activityId}")
    List<Activity> findActivityById(@Param("activityId") String activityId);

    //多条件查询活动（活动名+所属社团编号）
    @Select({"<script> SELECT * from activity"
            +"<where>"
            +"<if test = \"act_name != null and act_name != ''\"> act_name like CONCAT('%',#{activityName},'%')</if>"
            +"<if test = \"act_asso_id != null and act_asso_id != ''\"> act_asso_id = #{assoId}</if></where></script>"})
    List<Activity> findByNameAndAssoId(@Param("activityName") String activityName,@Param("assoId") String assoId);

    //删除活动
    @Delete("delete from activity where act_id = #{activityId}")
    void deleteActivity(@Param("activityId") String activityId) throws Exception;

    //更新活动信息
    @Update("update activity set act_name = #{activityName}, act_theme = #{activityTheme}, act_content = #{activityContent},act_number = #{activityNumber},act_date = #{activityDate},act_location=#{activityLocation},act_cost = #{activityCost}")
    void updateActivity(Activity activity) throws Exception;

}
