/*     */ package com.imooc.myo2o.entity;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class UserAwardMap
/*     */ {
/*     */   private Long userAwardId;
/*     */   private Long userId;
/*     */   private Long awardId;
/*     */   private Long shopId;
/*     */   private String userName;
/*     */   private String awardName;
/*     */   private Date expireTime;
/*     */   private Date createTime;
/*     */   private Integer usedStatus;
/*     */   private Integer point;
/*     */   private PersonInfo user;
/*     */   private Award award;
/*     */   private Shop shop;
/*     */   
/*     */   public Long getUserAwardId() {
/*  22 */     return this.userAwardId;
/*     */   }
/*     */   
/*     */   public void setUserAwardId(Long userAwardId) {
/*  26 */     this.userAwardId = userAwardId;
/*     */   }
/*     */   
/*     */   public Long getUserId() {
/*  30 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Long userId) {
/*  34 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public Long getAwardId() {
/*  38 */     return this.awardId;
/*     */   }
/*     */   
/*     */   public void setAwardId(Long awardId) {
/*  42 */     this.awardId = awardId;
/*     */   }
/*     */   
/*     */   public Long getShopId() {
/*  46 */     return this.shopId;
/*     */   }
/*     */   
/*     */   public void setShopId(Long shopId) {
/*  50 */     this.shopId = shopId;
/*     */   }
/*     */   
/*     */   public String getUserName() {
/*  54 */     return this.userName;
/*     */   }
/*     */   
/*     */   public void setUserName(String userName) {
/*  58 */     this.userName = userName;
/*     */   }
/*     */   
/*     */   public String getAwardName() {
/*  62 */     return this.awardName;
/*     */   }
/*     */   
/*     */   public void setAwardName(String awardName) {
/*  66 */     this.awardName = awardName;
/*     */   }
/*     */   
/*     */   public Date getExpireTime() {
/*  70 */     return this.expireTime;
/*     */   }
/*     */   
/*     */   public void setExpireTime(Date expireTime) {
/*  74 */     this.expireTime = expireTime;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/*  78 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/*  82 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Integer getUsedStatus() {
/*  86 */     return this.usedStatus;
/*     */   }
/*     */   
/*     */   public void setUsedStatus(Integer usedStatus) {
/*  90 */     this.usedStatus = usedStatus;
/*     */   }
/*     */   
/*     */   public Integer getPoint() {
/*  94 */     return this.point;
/*     */   }
/*     */   
/*     */   public void setPoint(Integer point) {
/*  98 */     this.point = point;
/*     */   }
/*     */   
/*     */   public PersonInfo getUser() {
/* 102 */     return this.user;
/*     */   }
/*     */   
/*     */   public void setUser(PersonInfo user) {
/* 106 */     this.user = user;
/*     */   }
/*     */   
/*     */   public Award getAward() {
/* 110 */     return this.award;
/*     */   }
/*     */   
/*     */   public void setAward(Award award) {
/* 114 */     this.award = award;
/*     */   }
/*     */   
/*     */   public Shop getShop() {
/* 118 */     return this.shop;
/*     */   }
/*     */   
/*     */   public void setShop(Shop shop) {
/* 122 */     this.shop = shop;
/*     */   }
/*     */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\entity\UserAwardMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */