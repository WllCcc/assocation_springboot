package com.assocation.domain;

import java.util.Date;

/**
 *  活动审批记录
 */
public class ActivityApproval {
    private String activityId;//活动编号
    private String activityAssoId;//所属社团编号
    private String activityName;//活动名称
    private String activityTheme;//活动主题
    private String activityContent;//活动内容
    private String activityLocation;//活动地点
    private Integer activityNumber;//活动人数
    private Double activityCost;//预期经费
    private Date activityDate;//活动日期
    private Date applicationDate;//申请日期
    private Date approvalDate;//审批日期
    private String status;//审批状态
    private String applyId;//申请人编号
    private String approvalId;//审批人编号

    public ActivityApproval(String activityId, String activityAssoId, String activityName, String activityTheme, String activityContent, String activityLocation, Integer activityNumber, Double activityCost, Date activityDate, Date applicationDate, Date approvalDate, String status, String applyId, String approvalId) {
        this.activityId = activityId;
        this.activityAssoId = activityAssoId;
        this.activityName = activityName;
        this.activityTheme = activityTheme;
        this.activityContent = activityContent;
        this.activityLocation = activityLocation;
        this.activityNumber = activityNumber;
        this.activityCost = activityCost;
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

    public String getActivityAssoId() {
        return activityAssoId;
    }

    public void setActivityAssoId(String activityAssoId) {
        this.activityAssoId = activityAssoId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityTheme() {
        return activityTheme;
    }

    public void setActivityTheme(String activityTheme) {
        this.activityTheme = activityTheme;
    }

    public String getActivityContent() {
        return activityContent;
    }

    public void setActivityContent(String activityContent) {
        this.activityContent = activityContent;
    }

    public String getActivityLocation() {
        return activityLocation;
    }

    public void setActivityLocation(String activityLocation) {
        this.activityLocation = activityLocation;
    }

    public Integer getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(Integer activityNumber) {
        this.activityNumber = activityNumber;
    }

    public Double getActivityCost() {
        return activityCost;
    }

    public void setActivityCost(Double activityCost) {
        this.activityCost = activityCost;
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
}
