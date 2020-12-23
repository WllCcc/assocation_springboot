package com.assocation.domain;

import java.util.Date;

/**
 *  社团创建审批
 */
public class EstApproval {
    private String assocationId;//审批社团编号
    private String assocationName;//审批社团名称
    private String assocationSynopsis;//审批社团简介
    private Date applicationDate;//申请时间
    private Date approvalDate;//审批时间
    private ApprovalStatus status;//审批状态（同意/不同意）
    private String applyId;//申请人编号
    private String approvalId;//审批人编号

    public EstApproval(String assocationId, String assocationName, String assocationSynopsis, Date applicationDate, Date approvalDate, ApprovalStatus status, String applyId, String approvalId) {
        this.assocationId = assocationId;
        this.assocationName = assocationName;
        this.assocationSynopsis = assocationSynopsis;
        this.applicationDate = applicationDate;
        this.approvalDate = approvalDate;
        this.status = status;
        this.applyId = applyId;
        this.approvalId = approvalId;
    }

    public String getAssocationId() {
        return assocationId;
    }

    public void setAssocationId(String assocationId) {
        this.assocationId = assocationId;
    }

    public String getAssocationName() {
        return assocationName;
    }

    public void setAssocationName(String assocationName) {
        this.assocationName = assocationName;
    }

    public String getAssocationSynopsis() {
        return assocationSynopsis;
    }

    public void setAssocationSynopsis(String assocationSynopsis) {
        this.assocationSynopsis = assocationSynopsis;
    }

    public Date getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(Date applicationDate) {
        this.applicationDate = applicationDate;
    }

    public Date getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(Date approvalDate) {
        this.approvalDate = approvalDate;
    }

    public ApprovalStatus getStatus() {
        return status;
    }

    public void setStatus(ApprovalStatus status) {
        this.status = status;
    }

    public String getApplyId() {
        return applyId;
    }

    public void setApplyId(String applyId) {
        this.applyId = applyId;
    }

    public String getApprovalId() {
        return approvalId;
    }

    public void setApprovalId(String approvalId) {
        this.approvalId = approvalId;
    }
}
