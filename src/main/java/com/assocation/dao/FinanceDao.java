package com.assocation.dao;

import com.assocation.domain.Finance;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FinanceDao {

    //查询所有社团活动的财务记录
    @Select("select * from finance")
    List<Finance> findAll();

    //通过财务编号+财务类型查询指定财务记录
    @Select({"<script> SELECT * from finance"
            +"<where>"
            +"<if test = \"financeId != null and financeId != ''\"> fin_id like CONCAT('%',#{financeId},'%')</if>"
            +"<if test = \"financeCategory != null and financeCategory != ''\"> fin_category = #{financeCategory}</if></where></script>"})
    List<Finance> findFinanceByMore(@Param("financeId") String financeId, @Param("financeCategory") String financeCategory);

    //添加财务记录
    @Insert("insert into finance(fin_id,fin_asso_name,fin_act_name,fin_category,fin_money,fin_balance) "
            + " values(#{financeId},#{assocationName},#{activityName},#{category},#{financeMoney},#{financeBalance})")
    void addFinance(Finance finance) throws Exception;

    //删除财务记录
    @Delete("delete from finance where fin_id = #{financeId}")
    void deleteFinance(@Param("financeId") String financeId) throws Exception;

    //更新财务信息
    @Update("update finance set fin_asso_name = #{assocationName}, fin_act_name = #{activityName}, fin_category = #{category},fin_money = #{financeMoney}, fin_balance = #{financeBalance} where fin_id = #{financeId}")
    void updateFinance(Finance finance) throws Exception;

}
