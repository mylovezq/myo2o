package com.imooc.myo2o.entity;

import java.util.Date;

public class Area {
  private Long areaId;
  private String areaName;
  private String areaDesc;
  private Integer priority;
  private Date createTime;
  private Date lastEditTime;

  public Long getAreaId() {
    return this.areaId;
  }

  public void setAreaId(Long areaId) {
    this.areaId = areaId;
  }

  public String getAreaName() {
    return this.areaName;
  }

  public void setAreaName(String areaName) {
    this.areaName = areaName;
  }

  public String getAreaDesc() {
    return this.areaDesc;
  }

  public void setAreaDesc(String areaDesc) {
    this.areaDesc = areaDesc;
  }

  public Integer getPriority() {
    return this.priority;
  }

  public void setPriority(Integer priority) {
    this.priority = priority;
  }

  public Date getCreateTime() {
    return this.createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getLastEditTime() {
    return this.lastEditTime;
  }

  public void setLastEditTime(Date lastEditTime) {
    this.lastEditTime = lastEditTime;
  }

  public String toString()
  {
    return "Area{areaId=" + this.areaId + ", areaName='" + this.areaName + '\'' + ", areaDesc='" + this.areaDesc + '\'' + ", priority=" + this.priority + ", createTime=" + this.createTime + ", lastEditTime=" + this.lastEditTime + '}';
  }
}

