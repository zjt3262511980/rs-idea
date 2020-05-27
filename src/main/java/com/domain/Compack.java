package com.domain;


import javax.persistence.Id;

public class Compack {
  //薪酬id
  @Id
  private Integer codeId;
  //员工工资
  private Double empSalary;
  //主管工资
  private Double empChargeSalary;
  //经理工资
  private Double empManagerSalary;
  //总经理工资
  private Double empZongmanagerSalary;
  //全勤奖
  private Double comAward;
  //补伙食费
  private Double comBoard;
  //公积金百分比
  private Double comAccumulation;
  //社保百分比
  private Double comSocial;
  //迟到扣款
  private Double comLate;

  @Override
  public String toString() {
    return "Compack{" +
            "codeId=" + codeId +
            ", empSalary=" + empSalary +
            ", empChargeSalary=" + empChargeSalary +
            ", empManagerSalary=" + empManagerSalary +
            ", empZongmanagerSalary=" + empZongmanagerSalary +
            ", comAward=" + comAward +
            ", comBoard=" + comBoard +
            ", comAccumulation=" + comAccumulation +
            ", comSocial=" + comSocial +
            ", comLate=" + comLate +
            '}';
  }

  public Compack() {
  }

  public Compack(Integer codeId, Double empSalary, Double empChargeSalary, Double empManagerSalary, Double empZongmanagerSalary, Double comAward, Double comBoard, Double comAccumulation, Double comSocial, Double comLate) {
    this.codeId = codeId;
    this.empSalary = empSalary;
    this.empChargeSalary = empChargeSalary;
    this.empManagerSalary = empManagerSalary;
    this.empZongmanagerSalary = empZongmanagerSalary;
    this.comAward = comAward;
    this.comBoard = comBoard;
    this.comAccumulation = comAccumulation;
    this.comSocial = comSocial;
    this.comLate = comLate;
  }

  public Integer getCodeId() {
    return codeId;
  }

  public void setCodeId(Integer codeId) {
    this.codeId = codeId;
  }


  public Double getEmpSalary() {
    return empSalary;
  }

  public void setEmpSalary(Double empSalary) {
    this.empSalary = empSalary;
  }


  public Double getEmpChargeSalary() {
    return empChargeSalary;
  }

  public void setEmpChargeSalary(Double empChargeSalary) {
    this.empChargeSalary = empChargeSalary;
  }


  public Double getEmpManagerSalary() {
    return empManagerSalary;
  }

  public void setEmpManagerSalary(Double empManagerSalary) {
    this.empManagerSalary = empManagerSalary;
  }


  public Double getEmpZongmanagerSalary() {
    return empZongmanagerSalary;
  }

  public void setEmpZongmanagerSalary(Double empZongmanagerSalary) {
    this.empZongmanagerSalary = empZongmanagerSalary;
  }


  public Double getComAward() {
    return comAward;
  }

  public void setComAward(Double comAward) {
    this.comAward = comAward;
  }


  public Double getComBoard() {
    return comBoard;
  }

  public void setComBoard(Double comBoard) {
    this.comBoard = comBoard;
  }


  public Double getComAccumulation() {
    return comAccumulation;
  }

  public void setComAccumulation(Double comAccumulation) {
    this.comAccumulation = comAccumulation;
  }


  public Double getComSocial() {
    return comSocial;
  }

  public void setComSocial(Double comSocial) {
    this.comSocial = comSocial;
  }


  public Double getComLate() {
    return comLate;
  }

  public void setComLate(Double comLate) {
    this.comLate = comLate;
  }

}
