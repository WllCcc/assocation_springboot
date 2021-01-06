package com.assocation.dao;

import com.assocation.domain.ActivityApproval;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivityApprovalDao {

    //查询所有活动审批清单
    @Select("select * from actapproval")
    List<ActivityApproval> findAll();

    //通过社团名查询社团编号
    @Select("select asso_id from assocation where asso_name = #{assoName}")
    String findAssoIdByName(@Param("assoName") String assoName);

    //社团活动申请，将社团活动申请插入数据库
    @Insert("insert into actapproval(app_act_id,app_asso_id,app_act_name,app_act_theme,app_act_content,app_act_location,app_act_num,app_act_cost,app_act_date,act_application_date,act_apply_id) "
            + "values(#{activityId},#{activityAssoId},#{activityName},#{activityTheme},#{activityContent},#{activityLocation},#{activityNumber},#{activityCost},#{activityDate},#{applicationDate},#{applyId})")
    void applyAssoAct(ActivityApproval actApproval) throws Exception;

    //审批通过社团活动申请
    @Insert("insert into activity(act_id,act_asso_id,act_name,act_theme,act_content,act_number,act_date,act_location,act_cost) "
            + "values(#{activityId},#{activityAssoId},#{activityName},#{activityTheme},#{activityContent},#{activityNumber},#{activityDate},#{activityLocation},#{activityCost})")
    void approvalAssoAct(ActivityApproval actApproval) throws Exception;

    @Update("update actapproval set act_approval_date = #{approvalDate}, app_status = #{status}, act_approval_id = #{approvalId} where app_act_id = #{activityId}")
    void updateActApproval(ActivityApproval actApproval) throws Exception;
}
