/*     */ package com.imooc.myo2o.entity;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Product
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -349433539553804024L;
/*     */   private Long productId;
/*     */   private String productName;
/*     */   private String productDesc;
/*     */   private String imgAddr;
/*     */   private String normalPrice;
/*     */   private String promotionPrice;
/*     */   private Integer priority;
/*     */   private Date createTime;
/*     */   private Date lastEditTime;
/*     */   private Integer enableStatus;
/*     */   private Integer point;
/*     */   private List<ProductImg> productImgList;
/*     */   private ProductCategory productCategory;
/*     */   private Shop shop;
/*     */   
/*     */   public Long getProductId()
/*     */   {
/*  31 */     return this.productId;
/*     */   }
/*     */   
/*     */   public void setProductId(Long productId) {
/*  35 */     this.productId = productId;
/*     */   }
/*     */   
/*     */   public String getProductName() {
/*  39 */     return this.productName;
/*     */   }
/*     */   
/*     */   public void setProductName(String productName) {
/*  43 */     this.productName = productName;
/*     */   }
/*     */   
/*     */   public String getProductDesc() {
/*  47 */     return this.productDesc;
/*     */   }
/*     */   
/*     */   public void setProductDesc(String productDesc) {
/*  51 */     this.productDesc = productDesc;
/*     */   }
/*     */   
/*     */   public String getImgAddr() {
/*  55 */     return this.imgAddr;
/*     */   }
/*     */   
/*     */   public void setImgAddr(String imgAddr) {
/*  59 */     this.imgAddr = imgAddr;
/*     */   }
/*     */   
/*     */   public String getNormalPrice() {
/*  63 */     return this.normalPrice;
/*     */   }
/*     */   
/*     */   public void setNormalPrice(String normalPrice) {
/*  67 */     this.normalPrice = normalPrice;
/*     */   }
/*     */   
/*     */   public String getPromotionPrice() {
/*  71 */     return this.promotionPrice;
/*     */   }
/*     */   
/*     */   public void setPromotionPrice(String promotionPrice) {
/*  75 */     this.promotionPrice = promotionPrice;
/*     */   }
/*     */   
/*     */   public Integer getPriority() {
/*  79 */     return this.priority;
/*     */   }
/*     */   
/*     */   public void setPriority(Integer priority) {
/*  83 */     this.priority = priority;
/*     */   }
/*     */   
/*     */   public Date getCreateTime() {
/*  87 */     return this.createTime;
/*     */   }
/*     */   
/*     */   public void setCreateTime(Date createTime) {
/*  91 */     this.createTime = createTime;
/*     */   }
/*     */   
/*     */   public Date getLastEditTime() {
/*  95 */     return this.lastEditTime;
/*     */   }
/*     */   
/*     */   public void setLastEditTime(Date lastEditTime) {
/*  99 */     this.lastEditTime = lastEditTime;
/*     */   }
/*     */   
/*     */   public Integer getEnableStatus() {
/* 103 */     return this.enableStatus;
/*     */   }
/*     */   
/*     */   public void setEnableStatus(Integer enableStatus) {
/* 107 */     this.enableStatus = enableStatus;
/*     */   }
/*     */   
/*     */   public Integer getPoint() {
/* 111 */     return this.point;
/*     */   }
/*     */   
/*     */   public void setPoint(Integer point) {
/* 115 */     this.point = point;
/*     */   }
/*     */   
/*     */   public List<ProductImg> getProductImgList() {
/* 119 */     return this.productImgList;
/*     */   }
/*     */   
/*     */   public void setProductImgList(List<ProductImg> productImgList) {
/* 123 */     this.productImgList = productImgList;
/*     */   }
/*     */   
/*     */   public ProductCategory getProductCategory() {
/* 127 */     return this.productCategory;
/*     */   }
/*     */   
/*     */   public void setProductCategory(ProductCategory productCategory) {
/* 131 */     this.productCategory = productCategory;
/*     */   }
/*     */   
/*     */   public Shop getShop() {
/* 135 */     return this.shop;
/*     */   }
/*     */   
/*     */   public void setShop(Shop shop) {
/* 139 */     this.shop = shop;
/*     */   }
/*     */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\entity\Product.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */