/*    */ package com.imooc.myo2o.entity;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class ProductCategory {
/*    */   private Long productCategoryId;
/*    */   private Long shopId;
/*    */   private String productCategoryName;
/*    */   private String productCategoryDesc;
/*    */   private Integer priority;
/*    */   private Date createTime;
/*    */   private Date lastEditTime;
/*    */   
/*    */   public Long getProductCategoryId() {
/* 15 */     return this.productCategoryId;
/*    */   }
/*    */   
/*    */   public void setProductCategoryId(Long productCategoryId) {
/* 19 */     this.productCategoryId = productCategoryId;
/*    */   }
/*    */   
/*    */   public Long getShopId() {
/* 23 */     return this.shopId;
/*    */   }
/*    */   
/*    */   public void setShopId(Long shopId) {
/* 27 */     this.shopId = shopId;
/*    */   }
/*    */   
/*    */   public String getProductCategoryName() {
/* 31 */     return this.productCategoryName;
/*    */   }
/*    */   
/*    */   public void setProductCategoryName(String productCategoryName) {
/* 35 */     this.productCategoryName = productCategoryName;
/*    */   }
/*    */   
/*    */   public String getProductCategoryDesc() {
/* 39 */     return this.productCategoryDesc;
/*    */   }
/*    */   
/*    */   public void setProductCategoryDesc(String productCategoryDesc) {
/* 43 */     this.productCategoryDesc = productCategoryDesc;
/*    */   }
/*    */   
/*    */   public Integer getPriority() {
/* 47 */     return this.priority;
/*    */   }
/*    */   
/*    */   public void setPriority(Integer priority) {
/* 51 */     this.priority = priority;
/*    */   }
/*    */   
/*    */   public Date getCreateTime() {
/* 55 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public void setCreateTime(Date createTime) {
/* 59 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */   public Date getLastEditTime() {
/* 63 */     return this.lastEditTime;
/*    */   }
/*    */   
/*    */   public void setLastEditTime(Date lastEditTime) {
/* 67 */     this.lastEditTime = lastEditTime;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 71 */     return "[productCategoryId=" + this.productCategoryId + ", productCategoryIdName=" + this.productCategoryName + "]";
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\entity\ProductCategory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */