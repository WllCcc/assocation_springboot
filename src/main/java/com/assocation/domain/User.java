package com.assocation.domain;

/**
 *  学生实体
 */
public class User {
    private String userId;//编号
    private String userName;//姓名
    private String userSex;//性别
    private String userGrade;//年级
    private String userClass;//班级
    private String userCollege;//学院
    private String userAssocation;//所属社团
    private String userPassword;//登录密码
    private String userRePassword;//重复登录密码
    private String userPhone;//联系电话
    private String userIdentity;//用户身份

    public User(String userId, String userName, String userSex, String userGrade, String userClass, String userCollege, String userAssocation, String userPassword, String userRePassword, String userPhone, String userIdentity) {
        this.userId = userId;
        this.userName = userName;
        this.userSex = userSex;
        this.userGrade = userGrade;
        this.userClass = userClass;
        this.userCollege = userCollege;
        this.userAssocation = userAssocation;
        this.userPassword = userPassword;
        this.userRePassword = userRePassword;
        this.userPhone = userPhone;
        this.userIdentity = userIdentity;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserGrade() {
        return userGrade;
    }

    public void setUserGrade(String userGrade) {
        this.userGrade = userGrade;
    }

    public String getUserClass() {
        return userClass;
    }

    public void setUserClass(String userClass) {
        this.userClass = userClass;
    }

    public String getUserCollege() {
        return userCollege;
    }

    public void setUserCollege(String userCollege) {
        this.userCollege = userCollege;
    }

    public String getUserAssocation() {
        return userAssocation;
    }

    public void setUserAssocation(String userAssocation) {
        this.userAssocation = userAssocation;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRePassword() {
        return userRePassword;
    }

    public void setUserRePassword(String userRePassword) {
        this.userRePassword = userRePassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserIdentity() {
        return userIdentity;
    }

    public void setUserIdentity(String userIdentity) {
        this.userIdentity = userIdentity;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", userSex='" + userSex + '\'' +
                ", userGrade='" + userGrade + '\'' +
                ", userClass='" + userClass + '\'' +
                ", userCollege='" + userCollege + '\'' +
                ", userAssocation='" + userAssocation + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRePassword='" + userRePassword + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", userIdentity='" + userIdentity + '\'' +
                '}';
    }
}
