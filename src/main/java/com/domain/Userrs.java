package com.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name="user")
public class Userrs {
    @Id

    private Integer userId;

    private Integer empId;

    private String userName;

    private String userPawd;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private java.sql.Timestamp userDate;

    private String userSalt;
    private Employee employee;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Userrs() {
    }

    public Userrs(Integer userId, Integer empId, String userName, String userPawd, Timestamp userDate, String userSalt) {
        this.userId = userId;
        this.empId = empId;
        this.userName = userName;
        this.userPawd = userPawd;
        this.userDate = userDate;
        this.userSalt = userSalt;
    }

    @Override
    public String toString() {
        return "UserrsService{" +
                "userId=" + userId +
                ", empId=" + empId +
                ", userName='" + userName + '\'' +
                ", userPawd='" + userPawd + '\'' +
                ", userDate=" + userDate +
                ", userSalt='" + userSalt + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getUserPawd() {
        return userPawd;
    }

    public void setUserPawd(String userPawd) {
        this.userPawd = userPawd;
    }


    public java.sql.Timestamp getUserDate() {
        return userDate;
    }

    public void setUserDate(java.sql.Timestamp userDate) {
        this.userDate = userDate;
    }


    public String getUserSalt() {
        return userSalt;
    }

    public void setUserSalt(String userSalt) {
        this.userSalt = userSalt;
    }

}
