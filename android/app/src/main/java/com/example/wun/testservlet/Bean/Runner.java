package com.example.wun.testservlet.Bean;

import java.io.Serializable;

/**
 * Created by WUN on 2018/2/18.
 */

public class Runner implements Serializable {
    private Long runnerID;//跑腿人id
    private Long tofgID;//待配送物件种类id
    private String name;//跑腿人姓名
    private String token;//登陆码，待以后用
    private String IDCardNumber;//联系人身份证号
    private String IDCardPhoto;//联系人身份证照片存储地址
    private String password;//密码
    private String phone;//电话
    private String photoOfHealCer;//健康证


    private Long margin;//保证金提交状态：1：提交；2：未提交

    public Runner() {
    }
    public Runner(Long runnerID, Long tofgID, String name,  String token,String IDCardNumber, String IDCardPhoto, String password,  String phone, String photoOfHealCer, Long margin) {
        this.runnerID = runnerID;
        this.tofgID = tofgID;
        this.name = name;
        this.token = token;
        this.IDCardNumber = IDCardNumber;
        this.IDCardPhoto = IDCardPhoto;
        this.password = password;

        this.phone = phone;
        this.photoOfHealCer = photoOfHealCer;

        this.margin = margin;
    }


    public Long getRunnerID() {
        return runnerID;
    }

    public void setRunnerID(Long merchantid) {
        this.runnerID = runnerID;
    }

    public Long getTofgID() {
        return tofgID;
    }

    public void setTofgID(Long tofgID) {
        this.tofgID = tofgID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.name = token;
    }

    public String getIDCardNumber() {
        return IDCardNumber;
    }

    public void setIDCardNumber(String IDCardNumber) {
        this.IDCardNumber = IDCardNumber;
    }

    public String getIDCardPhoto() {
        return IDCardPhoto;
    }

    public void setIDCardPhoto(String IDCardPhoto) {
        this.IDCardPhoto = IDCardPhoto;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

   public String getPhotoOfHealCer(){return  photoOfHealCer;}


    public Long getMargin() {
        return margin;
    }

    public void setMargin(Long margin) {
        this.margin = margin;
    }
}