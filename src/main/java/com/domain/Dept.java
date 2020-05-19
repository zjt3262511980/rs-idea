package com.domain;


import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Id;
import java.util.Date;
//部门表
public class Dept {
  @Id
  private Integer depId;
  private String depDepartment;
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  private String depIntroduction;
  private Date depTime;

  public Dept() {
  }

  public Dept(Integer depId, String depDepartment, String depIntroduction, Date depTime) {
    this.depId = depId;
    this.depDepartment = depDepartment;
    this.depIntroduction = depIntroduction;
    this.depTime = depTime;
  }

  @Override
  public String toString() {
    return "Dept{" +
            "depId=" + depId +
            ", depDepartment='" + depDepartment + '\'' +
            ", depIntroduction='" + depIntroduction + '\'' +
            ", depTime=" + depTime +
            '}';
  }

  public Integer getDepId() {
    return depId;
  }

  public void setDepId(Integer depId) {
    this.depId = depId;
  }


  public String getDepDepartment() {
    return depDepartment;
  }

  public void setDepDepartment(String depDepartment) {
    this.depDepartment = depDepartment;
  }


  public String getDepIntroduction() {
    return depIntroduction;
  }

  public void setDepIntroduction(String depIntroduction) {
    this.depIntroduction = depIntroduction;
  }


  public Date getDepTime() {
    return depTime;
  }

  public void setDepTime(Date depTime) {
    this.depTime = depTime;
  }

}
