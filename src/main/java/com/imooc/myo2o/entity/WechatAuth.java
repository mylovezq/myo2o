/*    */ package com.imooc.myo2o.entity;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class WechatAuth {
/*    */   private Long wechatAuthId;
/*    */   private Long userId;
/*    */   private String openId;
/*    */   private Date createTime;
/*    */   private PersonInfo personInfo;
/*    */   
/*    */   public Long getWechatAuthId() {
/* 13 */     return this.wechatAuthId;
/*    */   }
/*    */   
/*    */   public void setWechatAuthId(Long wechatAuthId) {
/* 17 */     this.wechatAuthId = wechatAuthId;
/*    */   }
/*    */   
/*    */   public Long getUserId() {
/* 21 */     return this.userId;
/*    */   }
/*    */   
/*    */   public void setUserId(Long userId) {
/* 25 */     this.userId = userId;
/*    */   }
/*    */   
/*    */   public String getOpenId() {
/* 29 */     return this.openId;
/*    */   }
/*    */   
/*    */   public void setOpenId(String openId) {
/* 33 */     this.openId = openId;
/*    */   }
/*    */   
/*    */   public Date getCreateTime() {
/* 37 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public void setCreateTime(Date createTime) {
/* 41 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */   public PersonInfo getPersonInfo() {
/* 45 */     return this.personInfo;
/*    */   }
/*    */   
/*    */   public void setPersonInfo(PersonInfo personInfo) {
/* 49 */     this.personInfo = personInfo;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\entity\WechatAuth.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */