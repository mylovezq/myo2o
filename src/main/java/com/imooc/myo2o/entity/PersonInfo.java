/*     */ package com.imooc.myo2o.entity;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class PersonInfo
/*     */ {
/*     */   private Long userId;
/*     */   private String name;
/*     */   private Date birthday;
/*     */   private String gender;
/*     */   private String phone;
/*     */   private String email;
/*     */   private String profileImg;
/*     */   private Integer customerFlag;
/*     */   private Integer shopOwnerFlag;
/*     */   private Integer adminFlag;
/*     */   private Date createTime;
/*     */   private Date lastEditTime;
/*     */   private Integer enableStatus;
/*     */   
/*     */   public Long getUserId() {
/*  22 */     return this.userId;
/*     */   }
/*     */   
/*     */   public void setUserId(Long userId) {
/*  26 */     this.userId = userId;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  30 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  34 */     this.name = name;
/*     */   }
/*     */   
/*     */   public Date getBirthday() {
/*  38 */     return this.birthday;
/*     */   }
/*     */   
/*     */   public void setBirthday(Date birthday) {
/*  42 */     this.birthday = birthday;
/*     */   }
/*     */   
/*     */   public String getGender() {
/*  46 */     return this.gender;
/*     */   }
/*     */   
/*     */   public void setGender(String gender) {
/*  50 */     this.gender = gender;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/*  54 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/*  58 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   public String getEmail() {
/*  62 */     return this.email;
/*     */   }
/*     */   
/*     */   public void setEmail(String email) {
/*  66 */     this.email = email;
/*     */   }
/*     */   
/*     */   public String getProfileImg() {
/*  70 */     return this.profileImg;
/*     */   }
/*     */   
/*     */   public void setProfileImg(String profileImg) {
/*  74 */     this.profileImg = profileImg;
/*     */   }
/*     */   
/*     */   public Integer getCustomerFlag() {
/*  78 */     return this.customerFlag;
/*     */   }
/*     */   
/*     */   public void setCustomerFlag(Integer customerFlag) {
/*  82 */     this.customerFlag = customerFlag;
/*     */   }
/*     */   
/*     */   public Integer getShopOwnerFlag() {
/*  86 */     return this.shopOwnerFlag;
/*     */   }
/*     */   
/*     */   public void setShopOwnerFlag(Integer shopOwnerFlag) {
/*  90 */     this.shopOwnerFlag = shopOwnerFlag;
/*     */   }
/*     */   
/*     */   public Integer getAdminFlag() {
/*  94 */     return this.adminFlag;
/*     */   }
/*     */   
/*     */   public void setAdminFlag(Integer adminFlag) {
/*  98 */     this.adminFlag = adminFlag;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/* 102 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 106 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Date getLastEditTime() {
/* 110 */     return this.lastEditTime;
/*     */   }
/*     */   
/*     */   public void setLastEditTime(Date lastEditTime) {
/* 114 */     this.lastEditTime = lastEditTime;
/*     */   }
/*     */   
/*     */   public Integer getEnableStatus() {
/* 118 */     return this.enableStatus;
/*     */   }
/*     */   
/*     */   public void setEnableStatus(Integer enableStatus) {
/* 122 */     this.enableStatus = enableStatus;
/*     */   }
/*     */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\entity\PersonInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */