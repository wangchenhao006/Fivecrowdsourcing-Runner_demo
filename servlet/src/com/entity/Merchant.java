package com.entity;

import java.io.Serializable;

public class Merchant implements Serializable{
  private Long merchantid;//商户id
  private Long tofgid;//待配送物件种类id
  private String name;//联系人姓名
  private String idcardnumber;//联系人身份证号
  private String idcardphoto;//联系人身份证照片存储地址
  private String password;//密码
  private String storename;//店铺名
  private String phone;//电话
  private String address;//地址
  private String buslicensephoto;//工商营业执照存储地址
  private String foodbuslicensephoto;//食品经营许可证存储地址
  private Long margin;//保证金提交状态：1：提交；2：未提交
  private Double longitude;//经度
  private Double latitude;//纬度
  private Double balance;//余额
  public Long getMerchantid() {
    return merchantid;
  }

  public void setMerchantid(Long merchantid) {
    this.merchantid = merchantid;
  }

  public Long getTofgid() {
    return tofgid;
  }

  public void setTofgid(Long tofgid) {
    this.tofgid = tofgid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getIdcardnumber() {
    return idcardnumber;
  }

  public void setIdcardnumber(String idcardnumber) {
    this.idcardnumber = idcardnumber;
  }

  public String getIdcardphoto() {
    return idcardphoto;
  }

  public void setIdcardphoto(String idcardphoto) {
    this.idcardphoto = idcardphoto;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getStorename() {
    return storename;
  }

  public void setStorename(String storename) {
    this.storename = storename;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getBuslicensephoto() {
    return buslicensephoto;
  }

  public void setBuslicensephoto(String buslicensephoto) {
    this.buslicensephoto = buslicensephoto;
  }

  public String getFoodbuslicensephoto() {
    return foodbuslicensephoto;
  }

  public void setFoodbuslicensephoto(String foodbuslicensephoto) {
    this.foodbuslicensephoto = foodbuslicensephoto;
  }

  public Long getMargin() {
    return margin;
  }

  public void setMargin(Long margin) {
    this.margin = margin;
  }

public Double getLongitude() {
	return longitude;
}

public void setLongitude(Double longitude) {
	this.longitude = longitude;
}

public Double getLatitude() {
	return latitude;
}

public void setLatitude(Double latitude) {
	this.latitude = latitude;
}

public Double getBalance() {
	return balance;
}

public void setBalance(Double balance) {
	this.balance = balance;
}
  
}
