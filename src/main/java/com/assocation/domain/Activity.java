package com.assocation.domain;


/**
 *  社团活动记录
 */
public class Activity {
    private String activityId;//活动编号
    private String assocationId;//社团编号
    private String activityName;//活动名称
    private String activityTheme;//活动主题
    private String activityContent;//活动内容
    private String activityNumber;//活动人数
    private String activityDate;//活动日期
    private String activityLocation;//活动地点
    private String activityCost;//预期经费

    public Activity(String activityId, String assocationId, String activityName, String activityTheme, String activityContent, String activityNumber, String activityDate, String activityLocation, String activityCost) {
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

    public String getActivityNumber() {
        return activityNumber;
    }

    public void setActivityNumber(String activityNumber) {
        this.activityNumber = activityNumber;
    }

    public String getActivityDate() {
        return activityDate;
    }

    public void setActivityDate(String activityDate) {
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

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    @Override
    public String toString() {
        return "Activity{" +
                "activityId='" + activityId + '\'' +
                ", assocationId='" + assocationId + '\'' +
                ", activityName='" + activityName + '\'' +
                ", activityTheme='" + activityTheme + '\'' +
                ", activityContent='" + activityContent + '\'' +
                ", activityNumber='" + activityNumber + '\'' +
                ", activityDate='" + activityDate + '\'' +
                ", activityLocation='" + activityLocation + '\'' +
                ", activityCost='" + activityCost + '\'' +
                '}';
    }
}
