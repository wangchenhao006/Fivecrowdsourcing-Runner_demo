/**
  * Copyright 2018 bejson.com 
  */
package com.besjon.pojo;
import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2018-03-05 13:54:51
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Data {

    private Date shidu;
    private int pm25;
    private int pm10;
    private String quality;
    private String wendu;
    private String ganmao;
    private Yesterday yesterday;
    private List<Forecast> forecast;
    public void setShidu(Date shidu) {
         this.shidu = shidu;
     }
     public Date getShidu() {
         return shidu;
     }

    public void setPm25(int pm25) {
         this.pm25 = pm25;
     }
     public int getPm25() {
         return pm25;
     }

    public void setPm10(int pm10) {
         this.pm10 = pm10;
     }
     public int getPm10() {
         return pm10;
     }

    public void setQuality(String quality) {
         this.quality = quality;
     }
     public String getQuality() {
         return quality;
     }

    public void setWendu(String wendu) {
         this.wendu = wendu;
     }
     public String getWendu() {
         return wendu;
     }

    public void setGanmao(String ganmao) {
         this.ganmao = ganmao;
     }
     public String getGanmao() {
         return ganmao;
     }

    public void setYesterday(Yesterday yesterday) {
         this.yesterday = yesterday;
     }
     public Yesterday getYesterday() {
         return yesterday;
     }

    public void setForecast(List<Forecast> forecast) {
         this.forecast = forecast;
     }
     public List<Forecast> getForecast() {
         return forecast;
     }

}