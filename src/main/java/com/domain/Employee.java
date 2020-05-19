package com.domain;


import javax.persistence.Id;
import java.sql.Date;
import java.sql.Timestamp;

public class Employee {
@Id
  private Integer empId;
  private String empName;
  private String empSex;
  private Integer empAge;
  private Integer empDept;
  private Integer empPosition;
  private String empDetail;
  private String empPhone;
  private String empEdu;
  private String empImg;
  private java.sql.Timestamp empDate;
  private String empMajor;
  private String empAddress;
  private String empIdentity;
  private String empStatus;
  private Integer empSuperior;
  private java.sql.Date empOutDate;

  //部门
  private Dept dept;
  //职位
  private  TmExamdataAddition tmExamdataAddition;
  //上级
  private Employee superior;

  public Employee getSuperior() {
    return superior;
  }

  public void setSuperior(Employee superior) {
    this.superior = superior;
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

  public Employee() {
  }

  @Override
  public String toString() {
    return "EmployeeDao{" +
            "empId=" + empId +
            ", empName='" + empName + '\'' +
            ", empSex='" + empSex + '\'' +
            ", empAge=" + empAge +
            ", empDept=" + empDept +
            ", empPosition=" + empPosition +
            ", empDetail='" + empDetail + '\'' +
            ", empPhone='" + empPhone + '\'' +
            ", empEdu='" + empEdu + '\'' +
            ", empImg='" + empImg + '\'' +
            ", empDate=" + empDate +
            ", empMajor='" + empMajor + '\'' +
            ", empAddress='" + empAddress + '\'' +
            ", empIdentity='" + empIdentity + '\'' +
            ", empStatus='" + empStatus + '\'' +
            ", empSuperior=" + empSuperior +
            ", empOutDate=" + empOutDate +
            '}';
  }

  public Employee(Integer empId, String empName, String empSex, Integer empAge, Integer empDept, Integer empPosition, String empDetail, String empPhone, String empEdu, String empImg, Timestamp empDate, String empMajor, String empAddress, String empIdentity, String empStatus, Integer empSuperior, Date empOutDate) {
    this.empId = empId;
    this.empName = empName;
    this.empSex = empSex;
    this.empAge = empAge;
    this.empDept = empDept;
    this.empPosition = empPosition;
    this.empDetail = empDetail;
    this.empPhone = empPhone;
    this.empEdu = empEdu;
    this.empImg = empImg;
    this.empDate = empDate;
    this.empMajor = empMajor;
    this.empAddress = empAddress;
    this.empIdentity = empIdentity;
    this.empStatus = empStatus;
    this.empSuperior = empSuperior;
    this.empOutDate = empOutDate;
  }

  public Integer getEmpId() {
    return empId;
  }

  public void setEmpId(Integer empId) {
    this.empId = empId;
  }


  public String getEmpName() {
    return empName;
  }

  public void setEmpName(String empName) {
    this.empName = empName;
  }


  public String getEmpSex() {
    return empSex;
  }

  public void setEmpSex(String empSex) {
    this.empSex = empSex;
  }


  public Integer getEmpAge() {
    return empAge;
  }

  public void setEmpAge(Integer empAge) {
    this.empAge = empAge;
  }


  public Integer getEmpDept() {
    return empDept;
  }

  public void setEmpDept(Integer empDept) {
    this.empDept = empDept;
  }


  public Integer getEmpPosition() {
    return empPosition;
  }

  public void setEmpPosition(Integer empPosition) {
    this.empPosition = empPosition;
  }


  public String getEmpDetail() {
    return empDetail;
  }

  public void setEmpDetail(String empDetail) {
    this.empDetail = empDetail;
  }


  public String getEmpPhone() {
    return empPhone;
  }

  public void setEmpPhone(String empPhone) {
    this.empPhone = empPhone;
  }


  public String getEmpEdu() {
    return empEdu;
  }

  public void setEmpEdu(String empEdu) {
    this.empEdu = empEdu;
  }


  public String getEmpImg() {
    return empImg;
  }

  public void setEmpImg(String empImg) {
    this.empImg = empImg;
  }


  public java.sql.Timestamp getEmpDate() {
    return empDate;
  }

  public void setEmpDate(java.sql.Timestamp empDate) {
    this.empDate = empDate;
  }


  public String getEmpMajor() {
    return empMajor;
  }

  public void setEmpMajor(String empMajor) {
    this.empMajor = empMajor;
  }


  public String getEmpAddress() {
    return empAddress;
  }

  public void setEmpAddress(String empAddress) {
    this.empAddress = empAddress;
  }


  public String getEmpIdentity() {
    return empIdentity;
  }

  public void setEmpIdentity(String empIdentity) {
    this.empIdentity = empIdentity;
  }


  public String getEmpStatus() {
    return empStatus;
  }

  public void setEmpStatus(String empStatus) {
    this.empStatus = empStatus;
  }


  public Integer getEmpSuperior() {
    return empSuperior;
  }

  public void setEmpSuperior(Integer empSuperior) {
    this.empSuperior = empSuperior;
  }


  public java.sql.Date getEmpOutDate() {
    return empOutDate;
  }

  public void setEmpOutDate(Date empOutDate) {
    this.empOutDate = empOutDate;
  }

}
