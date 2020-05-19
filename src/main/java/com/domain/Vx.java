package com.domain;


import javax.persistence.Id;

public class Vx {
@Id
  private Integer id;
  private Integer userrsid;
  private String vxid;

  public Vx() {
  }

  public Vx(Integer id, Integer userrsid, String vxid) {
    this.id = id;
    this.userrsid = userrsid;
    this.vxid = vxid;
  }

  @Override
  public String toString() {
    return "Vx{" +
            "id=" + id +
            ", userrsid=" + userrsid +
            ", vxid='" + vxid + '\'' +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


  public Integer getUserrsid() {
    return userrsid;
  }

  public void setUserrsid(Integer userrsid) {
    this.userrsid = userrsid;
  }


  public String getVxid() {
    return vxid;
  }

  public void setVxid(String vxid) {
    this.vxid = vxid;
  }

}
