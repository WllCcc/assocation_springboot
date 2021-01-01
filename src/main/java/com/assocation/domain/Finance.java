package com.assocation.domain;

/**
 *  社团财务
 */
public class Finance {
    private String financeId;//财务编号
    private String assocationName;//社团名称
    private String activityName;//活动名称
    private Double category;//类别（收入/支出）
    private String financeMoney;//金额
    private String financeBalance;//剩余总金额

    public Finance(String financeId, String assocationName, String activityName, Double category, String financeMoney, String financeBalance) {
        this.financeId = financeId;
        this.assocationName = assocationName;
        this.activityName = activityName;
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

    public String getAssocationName() {
        return assocationName;
    }

    public void setAssocationName(String assocationName) {
        this.assocationName = assocationName;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
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
