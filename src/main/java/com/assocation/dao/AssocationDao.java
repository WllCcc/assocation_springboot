package com.assocation.dao;

import com.assocation.domain.Assocation;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssocationDao {

    //查询所有社团
    @Select("select * from assocation")
    List<Assocation> findAllAsso();

    @Select("select * from assocation where asso_id = #{assoId}")
    List<Assocation> findAssoById(@Param("assoId") String assoId);

    @Select("select asso_id from assocation where asso_name = #{assoName}")
    String findAssoIdByName(@Param("assoName") String assoName);

    //多条件模糊查询（社团名+社团状态+社团等级）
    @Select({"<script> select * from assocation"
            +"<where>"
            +"<if test = \"assoName != null and assoName != ''\"> asso_name like CONCAT('%',#{assoName},'%')</if>"
            +"<if test = \"assoStatus != null and assoStatus != ''\"> asso_status = #{assoStatus}</if>"
            +"<if test = \"assoRank != null and assoRank != ''\"> asso_rank = #{assoRank}</if></where></script>"})
    List<Assocation> findAssoByMultiCons(@Param("assoName") String assoName, @Param("assoStatus") String assoStatus, @Param("assoRank") String assoRank);

    //添加社团
    @Insert("insert into assocation(asso_id,asso_name,asso_synopsis,asso_charge_id,asso_category,asso_est_date,asso_status,asso_rank) "
            +"values(#{assocationId},#{assocationName},#{assocationSynopsis},#{assocationChargeId},#{assocationCategory},#{assocationEstabDate},#{assocationStatus},#{assocationRank})")
    void addAssocation(Assocation assocation) throws Exception;

    //删除社团
    @Delete("delete from assocation where asso_id = #{assocationId}")
    void deleteAssocation(@Param("assocationId") String assocationId) throws Exception;

    //更新社团信息
    @Update("update assocation set asso_name = #{assocationName}, asso_synopsis = #{assocationSynopsis},asso_charge_id = #{assocationChargeId}, asso_category = #{assocationCategory},"
            +" asso_estab_date = #{assocationEstabDate}, asso_status = #{assocationStatus}, asso_rank = #{assocationRank} where asso_id = #{assocationId}")
    void updateAssocation(Assocation assocation) throws Exception;

}
