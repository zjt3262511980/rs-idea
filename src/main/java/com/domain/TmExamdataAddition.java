package com.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

//职位表
public class TmExamdataAddition {
  @Id
  private Integer tmEADi;
  private String tmEAPosition;
  private String tmEABrief;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private Date tmEATime;

  public TmExamdataAddition(Integer tmEADi, String tmEAPosition, String tmEABrief, Date tmEATime) {
    this.tmEADi = tmEADi;
    this.tmEAPosition = tmEAPosition;
    this.tmEABrief = tmEABrief;
    this.tmEATime = tmEATime;
  }

  public TmExamdataAddition() {
  }

  @Override
  public String toString() {
    return "TmExamdataAddition{" +
            "tmEADi=" + tmEADi +
            ", tmEAPosition='" + tmEAPosition + '\'' +
            ", tmEABrief='" + tmEABrief + '\'' +
            ", tmEATime=" + tmEATime +
            '}';
  }

  public Integer getTmEADi() {
    return tmEADi;
  }

  public void setTmEADi(Integer tmEADi) {
    this.tmEADi = tmEADi;
  }


  public String getTmEAPosition() {
    return tmEAPosition;
  }

  public void setTmEAPosition(String tmEAPosition) {
    this.tmEAPosition = tmEAPosition;
  }


  public String getTmEABrief() {
    return tmEABrief;
  }

  public void setTmEABrief(String tmEABrief) {
    this.tmEABrief = tmEABrief;
  }


  public Date getTmEATime() {
    return tmEATime;
  }

  public void setTmEATime(Date tmEATime) {
    this.tmEATime = tmEATime;
  }

}
