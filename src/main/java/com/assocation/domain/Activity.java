package com.assocation.domain;

import java.util.Date;

/**
 *  社团活动记录
 */
public class Activity {
    private String activityId;//活动编号
    private String assocationId;//社团编号
    private String activityTheme;//活动主题
    private String activityContent;//活动内容
    private String activityNumber;//活动人数
    private Date activityDate;//活动日期
    private String activityLocation;//活动地点
    private String activityCost;//所用经费

    public Activity(String activityId, String assocationId, String activityTheme, String activityContent, String activityNumber, Date activityDate, String activityLocation, String activityCost) {
        this.activityId = activityId;
        this.assocationId = assocationId;
        this.activityTheme = activityTheme;
        this.activityContent = activityContent;
        this.activityNumber = activityNumber;
        this.activityDate = activityDate;
        this.activityLocation = activityLocation;
        this.activityCost = activityCost;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getAssocationId() {
        return assocationId;
    }

    public void setAssocationId(String assocationId) {
        this.assocationId = assocationId;
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

    public String getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(String activityNumber) {
        this.activityNumber = activityNumber;
    }

    public Date getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(Date activityDate) {
        this.activityDate = activityDate;
    }

    public String getActivityLocation() {
        return activityLocation;
    }

    public void setActivityLocation(String activityLocation) {
        this.activityLocation = activityLocation;
    }

    public String getActivityCost() {
        return activityCost;
    }

    public void setActivityCost(String activityCost) {
        this.activityCost = activityCost;
    }
}
