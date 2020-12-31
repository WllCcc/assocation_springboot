package com.assocation.domain;

/**
 *  社团财务
 */
public class Finance {
    private String financeId;//财务编号
    private String assocationId;//社团编号
    private String activityId;//活动编号
    private Double category;//类别（收入/支出）
    private String financeMoney;//金额
    private String financeBalance;//剩余总金额

    public Finance(String financeId, String assocationId, String activityId, Double category, String financeMoney, String financeBalance) {
        this.financeId = financeId;
        this.assocationId = assocationId;
        this.activityId = activityId;
        this.category = category;
        this.financeMoney = financeMoney;
        this.financeBalance = financeBalance;
    }

    public String getFinanceId() {
        return financeId;
    }

    public void setFinanceId(String financeId) {
        this.financeId = financeId;
    }

    public String getAssocationId() {
        return assocationId;
    }

    public void setAssocationId(String assocationId) {
        this.assocationId = assocationId;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public Double getCategory() {
        return category;
    }

    public void setCategory(Double category) {
        this.category = category;
    }

    public String getFinanceMoney() {
        return financeMoney;
    }

    public void setFinanceMoney(String financeMoney) {
        this.financeMoney = financeMoney;
    }

    public String getFinanceBalance() {
        return financeBalance;
    }

    public void setFinanceBalance(String financeBalance) {
        this.financeBalance = financeBalance;
    }
}
