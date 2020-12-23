package com.assocation.domain;

import java.util.Date;

/**
 *  活动审批记录
 */
public class ActivityApproval {
    private String activityId;//审批活动编号
    private String activityName;//审批活动名称
    private String activityLocation;//活动地点
    private Date activityDate;//活动日期
    private Date applicationDate;//活动申请日期
    private Date approvalDate;//活动审批日期
    private ApprovalStatus status;//审批状态
    private String applyId;//申请人编号
    private String approvalId;//审批人编号

    public ActivityApproval(String activityId, String activityName, String activityLocation, Date activityDate, Date applicationDate, Date approvalDate, ApprovalStatus status, String applyId, String approvalId) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.activityLocation = activityLocation;
        this.activityDate = activityDate;
        this.applicationDate = applicationDate;
        this.approvalDate = approvalDate;
        this.status = status;
        this.applyId = applyId;
        this.approvalId = approvalId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityLocation() {
        return activityLocation;
    }

    public void setActivityLocation(String activityLocation) {
        this.activityLocation = activityLocation;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
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
