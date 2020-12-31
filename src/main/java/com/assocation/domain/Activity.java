package com.assocation.domain;

import java.util.Date;

/**
 *  社团活动记录
 */
public class Activity {
    private String activityId;//活动编号
    private String assocationId;//社团编号
    private String activityName;//活动名称
    private String activityTheme;//活动主题
    private String activityContent;//活动内容
    private Integer activityNumber;//活动人数
    private Date activityDate;//活动日期
    private String activityLocation;//活动地点
    private Double activityCost;//预期经费

    public Activity(String activityId, String assocationId, String activityName, String activityTheme, String activityContent, Integer activityNumber, Date activityDate, String activityLocation, Double activityCost) {
        this.activityId = activityId;
        this.assocationId = assocationId;
        this.activityName = activityName;
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

    public Integer getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(Integer activityNumber) {
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

    public Double getActivityCost() {
        return activityCost;
    }

    public void setActivityCost(Double activityCost) {
        this.activityCost = activityCost;
    }
}
