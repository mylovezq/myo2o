/*    */ package com.imooc.myo2o.entity;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class ShopCategory
/*    */ {
/*    */   private Long shopCategoryId;
/*    */   private String shopCategoryName;
/*    */   private String shopCategoryDesc;
/*    */   private String shopCategoryImg;
/*    */   private Integer priority;
/*    */   private Date createTime;
/*    */   private Date lastEditTime;
/*    */   private Long parentId;
/*    */   
/*    */   public Long getShopCategoryId() {
/* 17 */     return this.shopCategoryId;
/*    */   }
/*    */   
/*    */   public void setShopCategoryId(Long shopCategoryId) {
/* 21 */     this.shopCategoryId = shopCategoryId;
/*    */   }
/*    */   
/*    */   public String getShopCategoryName() {
/* 25 */     return this.shopCategoryName;
/*    */   }
/*    */   
/*    */   public void setShopCategoryName(String shopCategoryName) {
/* 29 */     this.shopCategoryName = shopCategoryName;
/*    */   }
/*    */   
/*    */   public String getShopCategoryDesc() {
/* 33 */     return this.shopCategoryDesc;
/*    */   }
/*    */   
/*    */   public void setShopCategoryDesc(String shopCategoryDesc) {
/* 37 */     this.shopCategoryDesc = shopCategoryDesc;
/*    */   }
/*    */   
/*    */   public String getShopCategoryImg() {
/* 41 */     return this.shopCategoryImg;
/*    */   }
/*    */   
/*    */   public void setShopCategoryImg(String shopCategoryImg) {
/* 45 */     this.shopCategoryImg = shopCategoryImg;
/*    */   }
/*    */   
/*    */   public Integer getPriority() {
/* 49 */     return this.priority;
/*    */   }
/*    */   
/*    */   public void setPriority(Integer priority) {
/* 53 */     this.priority = priority;
/*    */   }
/*    */   
/*    */   public Date getCreateTime() {
/* 57 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public void setCreateTime(Date createTime) {
/* 61 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */   public Date getLastEditTime() {
/* 65 */     return this.lastEditTime;
/*    */   }
/*    */   
/*    */   public void setLastEditTime(Date lastEditTime) {
/* 69 */     this.lastEditTime = lastEditTime;
/*    */   }
/*    */   
/*    */   public Long getParentId() {
/* 73 */     return this.parentId;
/*    */   }
/*    */   
/*    */   public void setParentId(Long parentId) {
/* 77 */     this.parentId = parentId;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\entity\ShopCategory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */