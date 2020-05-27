package com.domain;


import javax.persistence.Id;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Remuneration {
@Id
  private Integer remId;
  private java.util.Date remMonth;
  private Integer empId;
  private Double remSalary;
  private Integer remTiem;
  private Integer remOut;
  private Integer remPresent;
  private Double remMachin;
  private Double remFund;
  private Double remWithhold;
  private Double remMoney;
  private Double remUseSalary;
  private Double remNetPay;
  private Integer remZjlYj;
  private Integer remCwYj;

  //员工
  private Employee employee;
  //部门
  private Dept dept;
  //职位
  private TmExamdataAddition tmExamdataAddition;

  public Employee getEmployee() {
    return employee;
  }

  public void setEmployee(Employee employee) {
    this.employee = employee;
  }

  public Dept getDept() {
    return dept;
  }

  public void setDept(Dept dept) {
    this.dept = dept;
  }

  public TmExamdataAddition getTmExamdataAddition() {
    return tmExamdataAddition;
  }

  public void setTmExamdataAddition(TmExamdataAddition tmExamdataAddition) {
    this.tmExamdataAddition = tmExamdataAddition;
  }

  @Override
  public String toString() {
    return "Remuneration{" +
            "remId=" + remId +
            ", remMonth=" + remMonth +
            ", empId=" + empId +
            ", remSalary=" + remSalary +
            ", remTiem=" + remTiem +
            ", remOut=" + remOut +
            ", remPresent=" + remPresent +
            ", remMachin=" + remMachin +
            ", remFund=" + remFund +
            ", remWithhold=" + remWithhold +
            ", remMoney=" + remMoney +
            ", remUseSalary=" + remUseSalary +
            ", remNetPay=" + remNetPay +
            ", remZjlYj=" + remZjlYj +
            ", remCwYj=" + remCwYj +
            '}';
  }

  public Remuneration() {
  }

  public Remuneration(Integer remId, Date remMonth, Integer empId, Double remSalary, Integer remTiem, Integer remOut, Integer remPresent, Double remMachin, Double remFund, Double remWithhold, Double remMoney, Double remUseSalary, Double remNetPay, Integer remZjlYj, Integer remCwYj) {
    this.remId = remId;
    this.remMonth = remMonth;
    this.empId = empId;
    this.remSalary = remSalary;
    this.remTiem = remTiem;
    this.remOut = remOut;
    this.remPresent = remPresent;
    this.remMachin = remMachin;
    this.remFund = remFund;
    this.remWithhold = remWithhold;
    this.remMoney = remMoney;
    this.remUseSalary = remUseSalary;
    this.remNetPay = remNetPay;
    this.remZjlYj = remZjlYj;
    this.remCwYj = remCwYj;
  }

  public Integer getRemId() {
    return remId;
  }

  public void setRemId(Integer remId) {
    this.remId = remId;
  }


  public java.util.Date getRemMonth() {
    return remMonth;
  }

  public void setRemMonth(java.util.Date remMonth) {
    this.remMonth = remMonth;
  }


  public Integer getEmpId() {
    return empId;
  }

  public void setEmpId(Integer empId) {
    this.empId = empId;
  }


  public Double getRemSalary() {
    return remSalary;
  }

  public void setRemSalary(Double remSalary) {
    this.remSalary = remSalary;
  }


  public Integer getRemTiem() {
    return remTiem;
  }

  public void setRemTiem(Integer remTiem) {
    this.remTiem = remTiem;
  }


  public Integer getRemOut() {
    return remOut;
  }

  public void setRemOut(Integer remOut) {
    this.remOut = remOut;
  }


  public Integer getRemPresent() {
    return remPresent;
  }

  public void setRemPresent(Integer remPresent) {
    this.remPresent = remPresent;
  }


  public Double getRemMachin() {
    return remMachin;
  }

  public void setRemMachin(Double remMachin) {
    this.remMachin = remMachin;
  }


  public Double getRemFund() {
    return remFund;
  }

  public void setRemFund(Double remFund) {
    this.remFund = remFund;
  }


  public Double getRemWithhold() {
    return remWithhold;
  }

  public void setRemWithhold(Double remWithhold) {
    this.remWithhold = remWithhold;
  }


  public Double getRemMoney() {
    return remMoney;
  }

  public void setRemMoney(Double remMoney) {
    this.remMoney = remMoney;
  }


  public Double getRemUseSalary() {
    return remUseSalary;
  }

  public void setRemUseSalary(Double remUseSalary) {
    this.remUseSalary = remUseSalary;
  }


  public Double getRemNetPay() {
    return remNetPay;
  }

  public void setRemNetPay(Double remNetPay) {
    this.remNetPay = remNetPay;
  }


  public Integer getRemZjlYj() {
    return remZjlYj;
  }

  public void setRemZjlYj(Integer remZjlYj) {
    this.remZjlYj = remZjlYj;
  }


  public Integer getRemCwYj() {
    return remCwYj;
  }

  public void setRemCwYj(Integer remCwYj) {
    this.remCwYj = remCwYj;
  }

  public String getRemMonthstring(){
    if(remMonth!=null){
      return new SimpleDateFormat("yyyy-MM").format(this.remMonth);
    }
    return null;
  }
}
