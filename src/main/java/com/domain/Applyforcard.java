package com.domain;


import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Applyforcard {
  @Id
  private Integer applyId;
  private Integer beonId;
  private String applyCause;
  private Integer applyEmpId;
  private Integer empId;
  private Date applyDate;
  private String applyStatus;

  //员工表
  private Employee employee;
  //打卡表
  private Beonduty beonduty;

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

  public Applyforcard() {
  }

  @Override
  public String toString() {
    return "Applyforcard{" +
            "applyId=" + applyId +
            ", beonId=" + beonId +
            ", applyCause='" + applyCause + '\'' +
            ", applyEmpId=" + applyEmpId +
            ", empId=" + empId +
            ", applyDate=" + applyDate +
            ", applyStatus='" + applyStatus + '\'' +
            '}';
  }

  public Applyforcard(Integer applyId, Integer beonId, String applyCause, Integer applyEmpId, Integer empId, Date applyDate, String applyStatus) {
    this.applyId = applyId;
    this.beonId = beonId;
    this.applyCause = applyCause;
    this.applyEmpId = applyEmpId;
    this.empId = empId;
    this.applyDate = applyDate;
    this.applyStatus = applyStatus;
  }

  public Integer getApplyId() {
    return applyId;
  }

  public void setApplyId(Integer applyId) {
    this.applyId = applyId;
  }


  public Integer getBeonId() {
    return beonId;
  }

  public void setBeonId(Integer beonId) {
    this.beonId = beonId;
  }


  public String getApplyCause() {
    return applyCause;
  }

  public void setApplyCause(String applyCause) {
    this.applyCause = applyCause;
  }


  public Integer getApplyEmpId() {
    return applyEmpId;
  }

  public void setApplyEmpId(Integer applyEmpId) {
    this.applyEmpId = applyEmpId;
  }


  public Integer getEmpId() {
    return empId;
  }

  public void setEmpId(Integer empId) {
    this.empId = empId;
  }


  public java.util.Date getApplyDate() {
    return applyDate;
  }

  public void setApplyDate(java.util.Date applyDate) {
    this.applyDate = applyDate;
  }


  public String getApplyStatus() {
    return applyStatus;
  }

  public void setApplyStatus(String applyStatus) {
    this.applyStatus = applyStatus;
  }

    public String getApplyDatestring(){
        if(applyDate!=null){
            return new SimpleDateFormat("yyyy-MM-dd").format(this.applyDate);
        }
        return null;
    }
}
