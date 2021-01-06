package com.assocation.domain;


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
    private String activityNumber;//活动人数
    private String activityCost;//预期经费
    private String activityDate;//活动日期
    private String applicationDate;//申请日期
    private String approvalDate;//审批日期
    private String status;//审批状态
    private String applyId;//申请人编号
    private String approvalId;//审批人编号

    public ActivityApproval(String activityId, String activityAssoId, String activityName, String activityTheme, String activityContent, String activityLocation, String activityNumber, String activityCost, String activityDate, String applicationDate, String approvalDate, String status, String applyId, String approvalId) {
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

    public String getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(String activityNumber) {
        this.activityNumber = activityNumber;
    }

    public String getActivityCost() {
        return activityCost;
    }

    public void setActivityCost(String activityCost) {
        this.activityCost = activityCost;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
        this.activityDate = activityDate;
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
        return "ActivityApproval{" +
                "activityId='" + activityId + '\'' +
                ", activityAssoId='" + activityAssoId + '\'' +
                ", activityName='" + activityName + '\'' +
                ", activityTheme='" + activityTheme + '\'' +
                ", activityContent='" + activityContent + '\'' +
                ", activityLocation='" + activityLocation + '\'' +
                ", activityNumber='" + activityNumber + '\'' +
                ", activityCost='" + activityCost + '\'' +
                ", activityDate='" + activityDate + '\'' +
                ", applicationDate='" + applicationDate + '\'' +
                ", approvalDate='" + approvalDate + '\'' +
                ", status='" + status + '\'' +
                ", applyId='" + applyId + '\'' +
                ", approvalId='" + approvalId + '\'' +
                '}';
    }
}
