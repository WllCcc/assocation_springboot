package com.assocation.domain;


/**
 *  社团创建审批
 */
public class EstApproval {
    private String assocationId;//社团编号
    private String assocationName;//社团名称
    private String assocationSynopsis;//社团简介
    private String assocationCategory;//社团类别
    private String assocationStatus;//社团状态
    private String assocationRank;//社团等级
    private String applicationDate;//申请时间
    private String approvalDate;//审批时间
    private String status;//审批状态（等待审批/同意/不同意）
    private String applyId;//申请人编号
    private String approvalId;//审批人编号

    public EstApproval(String assocationId, String assocationName, String assocationSynopsis, String assocationCategory, String assocationStatus, String assocationRank, String applicationDate, String approvalDate, String status, String applyId, String approvalId) {
        this.assocationId = assocationId;
        this.assocationName = assocationName;
        this.assocationSynopsis = assocationSynopsis;
        this.assocationCategory = assocationCategory;
        this.assocationStatus = assocationStatus;
        this.assocationRank = assocationRank;
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

    public String getAssocationCategory() {
        return assocationCategory;
    }

    public void setAssocationCategory(String assocationCategory) {
        this.assocationCategory = assocationCategory;
    }

    public String getAssocationStatus() {
        return assocationStatus;
    }

    public void setAssocationStatus(String assocationStatus) {
        this.assocationStatus = assocationStatus;
    }

    public String getAssocationRank() {
        return assocationRank;
    }

    public void setAssocationRank(String assocationRank) {
        this.assocationRank = assocationRank;
    }

    public String getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(String applicationDate) {
        this.applicationDate = applicationDate;
    }

    public String getApprovalDate() {
        return approvalDate;
    }

    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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

    @Override
    public String toString() {
        return "EstApproval{" +
                "assocationId='" + assocationId + '\'' +
                ", assocationName='" + assocationName + '\'' +
                ", assocationSynopsis='" + assocationSynopsis + '\'' +
                ", assocationCategory='" + assocationCategory + '\'' +
                ", assocationStatus='" + assocationStatus + '\'' +
                ", assocationRank='" + assocationRank + '\'' +
                ", applicationDate='" + applicationDate + '\'' +
                ", approvalDate='" + approvalDate + '\'' +
                ", status='" + status + '\'' +
                ", applyId='" + applyId + '\'' +
                ", approvalId='" + approvalId + '\'' +
                '}';
    }
}
