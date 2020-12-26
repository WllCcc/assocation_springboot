package com.assocation.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 *  社团实体
 */
public class Assocation {
    private String assocationId;//社团id
    private String assocationName;//社团名称
    private String assocationSynopsis;//社团简介
    private String assocationChargeId;//负责人学号
    private String assocationCategory;//社团类别

    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date assocationEstabDate;//成立时间

    private Status assocationStatus;//社团状态
    private Rank assocationRank;//社团等级

    public Assocation(String assocationId, String assocationName, String assocationSynopsis, String assocationChargeId, String assocationCategory, Date assocationEstabDate, Status assocationStatus, Rank assocationRank) {
        this.assocationId = assocationId;
        this.assocationName = assocationName;
        this.assocationSynopsis = assocationSynopsis;
        this.assocationChargeId = assocationChargeId;
        this.assocationCategory = assocationCategory;
        this.assocationEstabDate = assocationEstabDate;
        this.assocationStatus = assocationStatus;
        this.assocationRank = assocationRank;
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

    public String getAssocationChargeId() {
        return assocationChargeId;
    }

    public void setAssocationChargeId(String assocationChargeId) {
        this.assocationChargeId = assocationChargeId;
    }

    public String getAssocationCategory() {
        return assocationCategory;
    }

    public void setAssocationCategory(String assocationCategory) {
        this.assocationCategory = assocationCategory;
    }

    public Date getAssocationEstabDate() {
        return assocationEstabDate;
    }

    public void setAssocationEstabDate(Date assocationEstabDate) {
        this.assocationEstabDate = assocationEstabDate;
    }

    public Status getAssocationStatus() {
        return assocationStatus;
    }

    public void setAssocationStatus(Status assocationStatus) {
        this.assocationStatus = assocationStatus;
    }

    public Rank getAssocationRank() {
        return assocationRank;
    }

    public void setAssocationRank(Rank assocationRank) {
        this.assocationRank = assocationRank;
    }
}
