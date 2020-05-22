package com.domain;


import javax.persistence.Id;

public class Checkingin {
  @Id
  private Integer cheId;
  private Integer empId;
  private Integer cheLate;
  private Integer cheEarly;
  private Integer cheAbsenteeism;
  private Integer cheOut;
  private Integer chePractical;
  private String cheMoth;
  private String cheRemark;

  //员工
  private Employee employee;

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Checkingin(Integer cheId, Integer empId, Integer cheLate, Integer cheEarly, Integer cheAbsenteeism, Integer cheOut, Integer chePractical, String cheMoth, String cheRemark) {
    this.cheId = cheId;
    this.empId = empId;
    this.cheLate = cheLate;
    this.cheEarly = cheEarly;
    this.cheAbsenteeism = cheAbsenteeism;
    this.cheOut = cheOut;
    this.chePractical = chePractical;
    this.cheMoth = cheMoth;
    this.cheRemark = cheRemark;
  }

  public Checkingin() {
  }

  @Override
  public String toString() {
    return "Checkingin{" +
            "cheId=" + cheId +
            ", empId=" + empId +
            ", cheLate=" + cheLate +
            ", cheEarly=" + cheEarly +
            ", cheAbsenteeism=" + cheAbsenteeism +
            ", cheOut=" + cheOut +
            ", chePractical=" + chePractical +
            ", cheMoth='" + cheMoth + '\'' +
            ", cheRemark=" + cheRemark +
            '}';
  }

  public Integer getCheId() {
    return cheId;
  }

  public void setCheId(Integer cheId) {
    this.cheId = cheId;
  }


  public Integer getEmpId() {
    return empId;
  }

  public void setEmpId(Integer empId) {
    this.empId = empId;
  }


  public Integer getCheLate() {
    return cheLate;
  }

  public void setCheLate(Integer cheLate) {
    this.cheLate = cheLate;
  }


  public Integer getCheEarly() {
    return cheEarly;
  }

  public void setCheEarly(Integer cheEarly) {
    this.cheEarly = cheEarly;
  }


  public Integer getCheAbsenteeism() {
    return cheAbsenteeism;
  }

  public void setCheAbsenteeism(Integer cheAbsenteeism) {
    this.cheAbsenteeism = cheAbsenteeism;
  }


  public Integer getCheOut() {
    return cheOut;
  }

  public void setCheOut(Integer cheOut) {
    this.cheOut = cheOut;
  }


  public Integer getChePractical() {
    return chePractical;
  }

  public void setChePractical(Integer chePractical) {
    this.chePractical = chePractical;
  }


  public String getCheMoth() {
    return cheMoth;
  }

  public void setCheMoth(String cheMoth) {
    this.cheMoth = cheMoth;
  }


  public String getCheRemark() {
    return cheRemark;
  }

  public void setCheRemark(String cheRemark) {
    this.cheRemark = cheRemark;
  }

}
