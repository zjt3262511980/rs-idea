package com.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

//上班表
public class Beonduty {
  @Id
  private Integer beondutyId;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date beondutyDay;
  private Integer beondutyMonth;

  public Beonduty() {
  }

  public Beonduty(Integer beondutyId, Date beondutyDay, Integer beondutyMonth) {
    this.beondutyId = beondutyId;
    this.beondutyDay = beondutyDay;
    this.beondutyMonth = beondutyMonth;
  }

  @Override
  public String toString() {
    return "Beonduty{" +
            "beondutyId=" + beondutyId +
            ", beondutyDay=" + beondutyDay +
            ", beondutyMonth=" + beondutyMonth +
            '}';
  }

  public Integer getBeondutyId() {
    return beondutyId;
  }

  public void setBeondutyId(Integer beondutyId) {
    this.beondutyId = beondutyId;
  }


  public Date getBeondutyDay() {
    return beondutyDay;
  }

  public void setBeondutyDay(Date beondutyDay) {
    this.beondutyDay = beondutyDay;
  }


  public Integer getBeondutyMonth() {
    return beondutyMonth;
  }

  public void setBeondutyMonth(Integer beondutyMonth) {
    this.beondutyMonth = beondutyMonth;
  }

  public String getBeondutyDaystring(){
    if(beondutyDay!=null){
      return new SimpleDateFormat("yyyy-MM-dd").format(this.beondutyDay);
    }
    return null;
  }

}
