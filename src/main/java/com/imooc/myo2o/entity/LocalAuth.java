 package com.imooc.myo2o.entity;

 import java.util.Date;

 public class LocalAuth {
   private Long localAuthId;
   private String userName;
   private String password;
   private Long userId;
   private Date createTime;
   private Date lastEditTime;
   private PersonInfo personInfo;

   public Long getLocalAuthId() {
     return this.localAuthId;
   }

   public void setLocalAuthId(Long localAuthId) {
     this.localAuthId = localAuthId;
   }

   public String getUserName() {
     return this.userName;
   }

   public void setUserName(String userName) {
     this.userName = userName;
   }

   public String getPassword() {
     return this.password;
   }

   public void setPassword(String password) {
     this.password = password;
   }

   public Long getUserId() {
     return this.userId;
   }

   public void setUserId(Long userId) {
     this.userId = userId;
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

   public PersonInfo getPersonInfo() {
     return this.personInfo;
   }

   public void setPersonInfo(PersonInfo personInfo) {
     this.personInfo = personInfo;
   }
 }

