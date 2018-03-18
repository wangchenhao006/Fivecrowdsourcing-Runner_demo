package com.entity;

public class Typeofgoods {
  private Long tofgid;//待配送物件种类id
  private String name;//待配送物件种类名
  private Long delmethodid;//推荐配送方式id

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

  public Long getDelmethodid() {
    return delmethodid;
  }

  public void setDelmethodid(Long delmethodid) {
    this.delmethodid = delmethodid;
  }
}
