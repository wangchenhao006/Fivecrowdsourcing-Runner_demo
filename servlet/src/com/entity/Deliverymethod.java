package com.entity;

public class Deliverymethod {
  private int delmethodid;//配送方式id
  private String name;//配送方式名
  private Double price;//配送基础价

  public int getDelmethodid() {
    return delmethodid;
  }

  public void setDelmethodid(int delmethodid) {
    this.delmethodid = delmethodid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }
}
