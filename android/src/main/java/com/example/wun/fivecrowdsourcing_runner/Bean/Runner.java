package com.example.wun.fivecrowdsourcing_runner.Bean;

import java.io.Serializable;

/**
 * Created by WUN on 2018/2/18.
 */

public class Runner implements Serializable {
    private Long runnerId;//跑腿人id
    private String phone;//电话
    private String password;//密码
    private String name;//跑腿人姓名
    private String IdCardNumber;//联系人身份证号
    private String photoOfIdCardInhand ;//联系人身份证照片正面
    private String photoOfIdCardOppo;//联系人身份证照片反面
    private String photoOfIdCardPosi;//联系人身份证地址
    private String photoOfHealCert;//联系人健康证
    private String balance;//联系人余额
    private int integral;//积分
    private short margin;//保证金提交状态：1：提交；2：未提交

    private Long tofgID;//待配送物件种类id

    private String token;//登陆码，待以后用

    //private String IdCardPhoto;//联系人身份证照片存储地址







    public Runner() {
    }
    public Runner(Long runnerId, Long tofgID, String name,  String IdCardNumber,  String password, String phone, String photoOfHealCert, short margin) {
        this.runnerId = runnerId;
        this.tofgID = tofgID;
        this.name = name;

        this.IdCardNumber = IdCardNumber;
        //this.IdCardPhoto = IdCardPhoto;
        this.password = password;

        this.phone = phone;


        this.margin = margin;
    }


    public Long getRunnerId() {
        return runnerId;
    }

    public void setRunnerId(Long runnerId) {
        this.runnerId = runnerId;
    }

    public Long getTofgID() {
        return tofgID;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getIdCardNumber() {
        return IdCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.IdCardNumber = idCardNumber;
    }

    /*public String getIdCardPhoto() {
        return IdCardPhoto;
    }

    public void setIdCardPhoto(String idCardPhoto) {
        this.IdCardPhoto = idCardPhoto;
    }*/

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




    public short getMargin() {
        return margin;
    }

    public void setMargin(short margin) {
        this.margin = margin;
    }

    public String getPhotoOfIdCardInhand() {
        return photoOfIdCardInhand;
    }

    public void setPhotoOfIdCardInhand(String photoOfIdCardInhand) {
        this.photoOfIdCardInhand = photoOfIdCardInhand;
    }

    public String getPhotoOfIdCardOppo() {
        return photoOfIdCardOppo;
    }

    public void setPhotoOfIdCardOppo(String photoOfIdCardOppo) {
        this.photoOfIdCardOppo = photoOfIdCardOppo;
    }

    public String getPhotoOfIdCardPosi() {
        return photoOfIdCardPosi;
    }

    public void setPhotoOfIdCardPosi(String photoOfIdCardPosi) {
        this.photoOfIdCardPosi = photoOfIdCardPosi;
    }

    public String getPhotoOfHealCert() {
        return photoOfHealCert;
    }

    public void setPhotoOfHealCert(String photoOfHealCert) {
        this.photoOfHealCert = photoOfHealCert;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }
}