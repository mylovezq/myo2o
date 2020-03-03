/*     */ package com.imooc.myo2o.entity;
/*     */ 
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ public class Shop
/*     */ {
/*     */   private Long shopId;
/*     */   private Long ownerId;
/*     */   private Long shopCategoryId;
/*     */   private String shopName;
/*     */   private String shopDesc;
/*     */   private String shopAddr;
/*     */   private String phone;
/*     */   private String shopImg;
/*     */   private Double longitude;
/*     */   private Double latitude;
/*     */   private Integer priority;
/*     */   private Date createTime;
/*     */   private Date lastEditTime;
/*     */   private Integer enableStatus;
/*     */   private String advice;
/*     */   private List<ShopAuthMap> staffList;
/*     */   private Area area;
/*     */   private ShopCategory shopCategory;
/*     */   private ShopCategory parentCategory;
/*     */   
/*     */   public Long getShopId()
/*     */   {
/*  30 */     return this.shopId;
/*     */   }
/*     */   
/*     */   public void setShopId(Long shopId) {
/*  34 */     this.shopId = shopId;
/*     */   }
/*     */   
/*     */   public Long getOwnerId() {
/*  38 */     return this.ownerId;
/*     */   }
/*     */   
/*     */   public void setOwnerId(Long ownerId) {
/*  42 */     this.ownerId = ownerId;
/*     */   }
/*     */   
/*     */   public Long getShopCategoryId() {
/*  46 */     return this.shopCategoryId;
/*     */   }
/*     */   
/*     */   public void setShopCategoryId(Long shopCategoryId) {
/*  50 */     this.shopCategoryId = shopCategoryId;
/*     */   }
/*     */   
/*     */   public String getShopName() {
/*  54 */     return this.shopName;
/*     */   }
/*     */   
/*     */   public void setShopName(String shopName) {
/*  58 */     this.shopName = shopName;
/*     */   }
/*     */   
/*     */   public String getShopDesc() {
/*  62 */     return this.shopDesc;
/*     */   }
/*     */   
/*     */   public void setShopDesc(String shopDesc) {
/*  66 */     this.shopDesc = shopDesc;
/*     */   }
/*     */   
/*     */   public String getShopAddr() {
/*  70 */     return this.shopAddr;
/*     */   }
/*     */   
/*     */   public void setShopAddr(String shopAddr) {
/*  74 */     this.shopAddr = shopAddr;
/*     */   }
/*     */   
/*     */   public String getPhone() {
/*  78 */     return this.phone;
/*     */   }
/*     */   
/*     */   public void setPhone(String phone) {
/*  82 */     this.phone = phone;
/*     */   }
/*     */   
/*     */   public String getShopImg() {
/*  86 */     return this.shopImg;
/*     */   }
/*     */   
/*     */   public void setShopImg(String shopImg) {
/*  90 */     this.shopImg = shopImg;
/*     */   }
/*     */   
/*     */   public Double getLongitude() {
/*  94 */     return this.longitude;
/*     */   }
/*     */   
/*     */   public void setLongitude(Double longitude) {
/*  98 */     this.longitude = longitude;
/*     */   }
/*     */   
/*     */   public Double getLatitude() {
/* 102 */     return this.latitude;
/*     */   }
/*     */   
/*     */   public void setLatitude(Double latitude) {
/* 106 */     this.latitude = latitude;
/*     */   }
/*     */   
/*     */   public Integer getPriority() {
/* 110 */     return this.priority;
/*     */   }
/*     */   
/*     */   public void setPriority(Integer priority) {
/* 114 */     this.priority = priority;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/* 118 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/* 122 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Date getLastEditTime() {
/* 126 */     return this.lastEditTime;
/*     */   }
/*     */   
/*     */   public void setLastEditTime(Date lastEditTime) {
/* 130 */     this.lastEditTime = lastEditTime;
/*     */   }
/*     */   
/*     */   public Integer getEnableStatus() {
/* 134 */     return this.enableStatus;
/*     */   }
/*     */   
/*     */   public void setEnableStatus(Integer enableStatus) {
/* 138 */     this.enableStatus = enableStatus;
/*     */   }
/*     */   
/*     */   public List<ShopAuthMap> getStaffList() {
/* 142 */     return this.staffList;
/*     */   }
/*     */   
/*     */   public void setStaffList(List<ShopAuthMap> staffList) {
/* 146 */     this.staffList = staffList;
/*     */   }
/*     */   
/*     */   public Area getArea() {
/* 150 */     return this.area;
/*     */   }
/*     */   
/*     */   public void setArea(Area area) {
/* 154 */     this.area = area;
/*     */   }
/*     */   
/*     */   public ShopCategory getShopCategory() {
/* 158 */     return this.shopCategory;
/*     */   }
/*     */   
/*     */   public void setShopCategory(ShopCategory shopCategory) {
/* 162 */     this.shopCategory = shopCategory;
/*     */   }
/*     */   
/*     */   public String getAdvice() {
/* 166 */     return this.advice;
/*     */   }
/*     */   
/*     */   public void setAdvice(String advice) {
/* 170 */     this.advice = advice;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 174 */     return "[shopId=" + this.shopId + ", shopName=" + this.shopName + "]";
/*     */   }
/*     */   
/*     */   public ShopCategory getParentCategory() {
/* 178 */     return this.parentCategory;
/*     */   }
/*     */   
/*     */   public void setParentCategory(ShopCategory parentCategory) {
/* 182 */     this.parentCategory = parentCategory;
/*     */   }
/*     */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\entity\Shop.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */