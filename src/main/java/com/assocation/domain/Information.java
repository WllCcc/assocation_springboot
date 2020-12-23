package com.assocation.domain;

import java.util.Date;

/**
 *  社团资讯
 */
public class Information {
    private String infoId;//资讯编号
    private String infoTitle;//资讯标题
    private String infoContent;//资讯内容
    private String infoImgUrl;//资讯图片url
    private String assocationId;//社团编号
    private Date infoDate;//资讯发布日期

    public Information(String infoId, String infoTitle, String infoContent, String infoImgUrl, String assocationId, Date infoDate) {
        this.infoId = infoId;
        this.infoTitle = infoTitle;
        this.infoContent = infoContent;
        this.infoImgUrl = infoImgUrl;
        this.assocationId = assocationId;
        this.infoDate = infoDate;
    }

    public String getInfoId() {
        return infoId;
    }

    public void setInfoId(String infoId) {
        this.infoId = infoId;
    }

    public String getInfoTitle() {
        return infoTitle;
    }

    public void setInfoTitle(String infoTitle) {
        this.infoTitle = infoTitle;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public String getInfoImgUrl() {
        return infoImgUrl;
    }

    public void setInfoImgUrl(String infoImgUrl) {
        this.infoImgUrl = infoImgUrl;
    }

    public String getAssocationId() {
        return assocationId;
    }

    public void setAssocationId(String assocationId) {
        this.assocationId = assocationId;
    }

    public Date getInfoDate() {
        return infoDate;
    }

    public void setInfoDate(Date infoDate) {
        this.infoDate = infoDate;
    }
}
