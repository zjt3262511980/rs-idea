package com.domain;


import javax.persistence.Id;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

//打卡表
public class Punchcard {
@Id
  private Integer punchId;
  private Date punchStatusDate;
  private Date punchEndDate;
  private Integer empId;
  private Integer beondutyId;
//上班表
  private Beonduty beonduty;
  //员工表
  private Employee employee;

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Beonduty getBeonduty() {
    return beonduty;
  }

  public void setBeonduty(Beonduty beonduty) {
    this.beonduty = beonduty;
  }

  public Punchcard() {
  }

  public Punchcard(Integer punchId, Date punchStatusDate, Date punchEndDate, Integer empId, Integer beondutyId) {
    this.punchId = punchId;
    this.punchStatusDate = punchStatusDate;
    this.punchEndDate = punchEndDate;
    this.empId = empId;
    this.beondutyId = beondutyId;
  }

  @Override
  public String toString() {
    return "Punchcard{" +
            "punchId=" + punchId +
            ", punchStatusDate=" + punchStatusDate +
            ", punchEndDate=" + punchEndDate +
            ", empId=" + empId +
            ", beondutyId=" + beondutyId +
            '}';
  }

  public Integer getPunchId() {
    return punchId;
  }

  public void setPunchId(Integer punchId) {
    this.punchId = punchId;
  }


  public Date getPunchStatusDate() {
    return punchStatusDate;
  }

  public void setPunchStatusDate(java.sql.Timestamp punchStatusDate) {
    this.punchStatusDate = punchStatusDate;
  }


  public Date getPunchEndDate() {
    return punchEndDate;
  }

  public void setPunchEndDate(java.sql.Timestamp punchEndDate) {
    this.punchEndDate = punchEndDate;
  }


  public Integer getEmpId() {
    return empId;
  }

  public void setEmpId(Integer empId) {
    this.empId = empId;
  }


  public Integer getBeondutyId() {
    return beondutyId;
  }

  public void setBeondutyId(Integer beondutyId) {
    this.beondutyId = beondutyId;
  }

    public String getPunchStatusDatestring(){
        if(punchStatusDate!=null){
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.punchStatusDate);
        }
        return null;
    }

    public String getPunchEndDatestring(){
        if(punchEndDate!=null){
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(this.punchEndDate);
        }
        return null;
    }

}
