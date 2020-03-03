/*    */ package com.imooc.myo2o.dto;
/*    */ 
/*    */ import com.imooc.myo2o.entity.ProductCategory;
/*    */ import com.imooc.myo2o.enums.ProductCategoryStateEnum;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ProductCategoryExecution
/*    */ {
/*    */   private int state;
/*    */   private String stateInfo;
/*    */   private List<ProductCategory> productCategoryList;
/*    */   
/*    */   public ProductCategoryExecution() {}
/*    */   
/*    */   public ProductCategoryExecution(ProductCategoryStateEnum stateEnum)
/*    */   {
/* 23 */     this.state = stateEnum.getState();
/* 24 */     this.stateInfo = stateEnum.getStateInfo();
/*    */   }
/*    */   
/*    */   public ProductCategoryExecution(ProductCategoryStateEnum stateEnum, List<ProductCategory> productCategoryList)
/*    */   {
/* 29 */     this.state = stateEnum.getState();
/* 30 */     this.stateInfo = stateEnum.getStateInfo();
/* 31 */     this.productCategoryList = productCategoryList;
/*    */   }
/*    */   
/*    */   public int getState() {
/* 35 */     return this.state;
/*    */   }
/*    */   
/*    */   public void setState(int state) {
/* 39 */     this.state = state;
/*    */   }
/*    */   
/*    */   public String getStateInfo() {
/* 43 */     return this.stateInfo;
/*    */   }
/*    */   
/*    */   public void setStateInfo(String stateInfo) {
/* 47 */     this.stateInfo = stateInfo;
/*    */   }
/*    */   
/*    */   public List<ProductCategory> getProductCategoryList() {
/* 51 */     return this.productCategoryList;
/*    */   }
/*    */   
/*    */   public void setProductCategoryList(List<ProductCategory> productCategoryList) {
/* 55 */     this.productCategoryList = productCategoryList;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dto\ProductCategoryExecution.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */