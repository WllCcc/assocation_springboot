package com.assocation.domain;

import java.util.Date;

/**
 *  系统公告
 */
public class Announcement {
    private String annoId;//公告编号
    private String annoTitle;//公告标题
    private String annoTitleColor;//公告标题颜色
    private Date annoStartDate;//公告起始时间
    private Date annoEndDate;//公告结束时间
    private String annoContent;//公告内容
    private AnnouncementStatus annoStatus;//公告状态（有效/失效）

    public Announcement(String annoId, String annoTitle, String annoTitleColor, Date annoStartDate, Date annoEndDate, String annoContent, AnnouncementStatus annoStatus) {
        this.annoId = annoId;
        this.annoTitle = annoTitle;
        this.annoTitleColor = annoTitleColor;
        this.annoStartDate = annoStartDate;
        this.annoEndDate = annoEndDate;
        this.annoContent = annoContent;
        this.annoStatus = annoStatus;
    }

    public String getAnnoId() {
        return annoId;
    }

    public void setAnnoId(String annoId) {
        this.annoId = annoId;
    }

    public String getAnnoTitle() {
        return annoTitle;
    }

    public void setAnnoTitle(String annoTitle) {
        this.annoTitle = annoTitle;
    }

    public String getAnnoTitleColor() {
        return annoTitleColor;
    }

    public void setAnnoTitleColor(String annoTitleColor) {
        this.annoTitleColor = annoTitleColor;
    }

    public Date getAnnoStartDate() {
        return annoStartDate;
    }

    public void setAnnoStartDate(Date annoStartDate) {
        this.annoStartDate = annoStartDate;
    }

    public Date getAnnoEndDate() {
        return annoEndDate;
    }

    public void setAnnoEndDate(Date annoEndDate) {
        this.annoEndDate = annoEndDate;
    }

    public String getAnnoContent() {
        return annoContent;
    }

    public void setAnnoContent(String annoContent) {
        this.annoContent = annoContent;
    }

    public AnnouncementStatus getAnnoStatus() {
        return annoStatus;
    }

    public void setAnnoStatus(AnnouncementStatus annoStatus) {
        this.annoStatus = annoStatus;
    }
}
