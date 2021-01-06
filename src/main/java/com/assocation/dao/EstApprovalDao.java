package com.assocation.dao;

import com.assocation.domain.EstApproval;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstApprovalDao {

    //查询社团创建审批清单
    @Select("select * from estapproval")
    List<EstApproval> findAll();

    //社团创建申请,将社团创建申请插入数据库
    @Insert("insert into estapproval(est_asso_id,est_asso_name,est_asso_synopsis,est_asso_category,est_asso_status,est_asso_rank,est_application_date,est_approval_date,est_status,est_apply_id,est_approval_id) "
            + "values(#{assocationId},#{assocationName},#{assocationSynopsis},#{assocationCategory},#{assocationStatus},#{assocationRank},#{applicationDate},#{approvalDate},#{status},#{applyId},#{approvalId})")
    void applyAssoEst(EstApproval estApproval) throws Exception;

    //审批通过社团创建申请,将社团信息插入数据库
    @Insert("insert into assocation(asso_id,asso_name,asso_synopsis,asso_charge_id,asso_category,asso_estab_date,asso_status,asso_rank) "
            + " values(#{assocationId},#{assocationName},#{assocationSynopsis},#{applyId},#{assocationCategory},#{approvalDate},#{assocationStatus},#{assocationRank})")
    void approveAssoEst(EstApproval estApproval) throws Exception;

    //更新社团审批信息
    @Update("update estapproval set est_approval_date = #{approvalDate}, est_status = #{status}, est_approval_id = #{approvalId} where est_asso_id = #{assocationId}")
    void updateEstApproval(EstApproval actApproval) throws Exception;
}
