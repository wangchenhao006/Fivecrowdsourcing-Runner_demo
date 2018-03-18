package com.entity;

public class Evaluation {
  private Long delorderid;//对应的配送单id
  private Long deltime;//配送时间评分
  private Long delquality;//配送质量评分
  private Long delattitude;//配送态度评分
  private String content;//评价内容

  public Long getDelorderid() {
    return delorderid;
  }

  public void setDelorderid(Long delorderid) {
    this.delorderid = delorderid;
  }

  public Long getDeltime() {
    return deltime;
  }

  public void setDeltime(Long deltime) {
    this.deltime = deltime;
  }

  public Long getDelquality() {
    return delquality;
  }

  public void setDelquality(Long delquality) {
    this.delquality = delquality;
  }

  public Long getDelattitude() {
    return delattitude;
  }

  public void setDelattitude(Long delattitude) {
    this.delattitude = delattitude;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}
