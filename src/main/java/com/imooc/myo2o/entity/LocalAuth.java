/*    */ package com.imooc.myo2o.entity;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class LocalAuth {
/*    */   private Long localAuthId;
/*    */   private String userName;
/*    */   private String password;
/*    */   private Long userId;
/*    */   private Date createTime;
/*    */   private Date lastEditTime;
/*    */   private PersonInfo personInfo;
/*    */   
/*    */   public Long getLocalAuthId() {
/* 15 */     return this.localAuthId;
/*    */   }
/*    */   
/*    */   public void setLocalAuthId(Long localAuthId) {
/* 19 */     this.localAuthId = localAuthId;
/*    */   }
/*    */   
/*    */   public String getUserName() {
/* 23 */     return this.userName;
/*    */   }
/*    */   
/*    */   public void setUserName(String userName) {
/* 27 */     this.userName = userName;
/*    */   }
/*    */   
/*    */   public String getPassword() {
/* 31 */     return this.password;
/*    */   }
/*    */   
/*    */   public void setPassword(String password) {
/* 35 */     this.password = password;
/*    */   }
/*    */   
/*    */   public Long getUserId() {
/* 39 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void setUserId(Long userId) {
/* 43 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   public Date getCreateTime() {
/* 47 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public void setCreateTime(Date createTime) {
/* 51 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */   public Date getLastEditTime() {
/* 55 */     return this.lastEditTime;
/*    */   }
/*    */   
/*    */   public void setLastEditTime(Date lastEditTime) {
/* 59 */     this.lastEditTime = lastEditTime;
/*    */   }
/*    */   
/*    */   public PersonInfo getPersonInfo() {
/* 63 */     return this.personInfo;
/*    */   }
/*    */   
/*    */   public void setPersonInfo(PersonInfo personInfo) {
/* 67 */     this.personInfo = personInfo;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\entity\LocalAuth.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */