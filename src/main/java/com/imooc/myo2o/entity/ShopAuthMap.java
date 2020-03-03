/*     */ package com.imooc.myo2o.entity;
/*     */ 
/*     */ import java.util.Date;
/*     */ 
/*     */ public class ShopAuthMap
/*     */ {
/*     */   private Long shopAuthId;
/*     */   private Long employeeId;
/*     */   private Long shopId;
/*     */   private String name;
/*     */   private String title;
/*     */   private Integer titleFlag;
/*     */   private Integer enableStatus;
/*     */   private Date createTime;
/*     */   private Date lastEditTime;
/*     */   private PersonInfo employee;
/*     */   private Shop shop;
/*     */   
/*     */   public Long getShopAuthId() {
/*  20 */     return this.shopAuthId;
/*     */   }
/*     */   
/*     */   public void setShopAuthId(Long shopAuthId) {
/*  24 */     this.shopAuthId = shopAuthId;
/*     */   }
/*     */   
/*     */   public Long getEmployeeId() {
/*  28 */     return this.employeeId;
/*     */   }
/*     */   
/*     */   public void setEmployeeId(Long employeeId) {
/*  32 */     this.employeeId = employeeId;
/*     */   }
/*     */   
/*     */   public Long getShopId() {
/*  36 */     return this.shopId;
/*     */   }
/*     */   
/*     */   public void setShopId(Long shopId) {
/*  40 */     this.shopId = shopId;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  44 */     return this.name;
/*     */   }
/*     */   
/*     */   public void setName(String name) {
/*  48 */     this.name = name;
/*     */   }
/*     */   
/*     */   public String getTitle() {
/*  52 */     return this.title;
/*     */   }
/*     */   
/*     */   public void setTitle(String title) {
/*  56 */     this.title = title;
/*     */   }
/*     */   
/*     */   public Integer getTitleFlag() {
/*  60 */     return this.titleFlag;
/*     */   }
/*     */   
/*     */   public void setTitleFlag(Integer titleFlag) {
/*  64 */     this.titleFlag = titleFlag;
/*     */   }
/*     */   
/*     */   public Integer getEnableStatus() {
/*  68 */     return this.enableStatus;
/*     */   }
/*     */   
/*     */   public void setEnableStatus(Integer enableStatus) {
/*  72 */     this.enableStatus = enableStatus;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/*  76 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/*  80 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Date getLastEditTime() {
/*  84 */     return this.lastEditTime;
/*     */   }
/*     */   
/*     */   public void setLastEditTime(Date lastEditTime) {
/*  88 */     this.lastEditTime = lastEditTime;
/*     */   }
/*     */   
/*     */   public PersonInfo getEmployee() {
/*  92 */     return this.employee;
/*     */   }
/*     */   
/*     */   public void setEmployee(PersonInfo employee) {
/*  96 */     this.employee = employee;
/*     */   }
/*     */   
/*     */   public Shop getShop() {
/* 100 */     return this.shop;
/*     */   }
/*     */   
/*     */   public void setShop(Shop shop) {
/* 104 */     this.shop = shop;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 108 */     return "[shopId=" + this.shopId + ", employeeId=" + this.employeeId + ", employeeName=" + this.name + "]";
/*     */   }
/*     */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\entity\ShopAuthMap.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */