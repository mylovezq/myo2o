/*    */ package com.imooc.myo2o.dto;
/*    */ 
/*    */ import com.imooc.myo2o.entity.Product;
/*    */ import com.imooc.myo2o.enums.ProductStateEnum;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ProductExecution
/*    */ {
/*    */   private int state;
/*    */   private String stateInfo;
/*    */   private int count;
/*    */   private Product product;
/*    */   private List<Product> productList;
/*    */   
/*    */   public ProductExecution() {}
/*    */   
/*    */   public ProductExecution(ProductStateEnum stateEnum)
/*    */   {
/* 29 */     this.state = stateEnum.getState();
/* 30 */     this.stateInfo = stateEnum.getStateInfo();
/*    */   }
/*    */   
/*    */   public ProductExecution(ProductStateEnum stateEnum, Product product)
/*    */   {
/* 35 */     this.state = stateEnum.getState();
/* 36 */     this.stateInfo = stateEnum.getStateInfo();
/* 37 */     this.product = product;
/*    */   }
/*    */   
/*    */   public ProductExecution(ProductStateEnum stateEnum, List<Product> productList)
/*    */   {
/* 42 */     this.state = stateEnum.getState();
/* 43 */     this.stateInfo = stateEnum.getStateInfo();
/* 44 */     this.productList = productList;
/*    */   }
/*    */   
/*    */   public int getState() {
/* 48 */     return this.state;
/*    */   }
/*    */   
/*    */   public void setState(int state) {
/* 52 */     this.state = state;
/*    */   }
/*    */   
/*    */   public String getStateInfo() {
/* 56 */     return this.stateInfo;
/*    */   }
/*    */   
/*    */   public void setStateInfo(String stateInfo) {
/* 60 */     this.stateInfo = stateInfo;
/*    */   }
/*    */   
/*    */   public int getCount() {
/* 64 */     return this.count;
/*    */   }
/*    */   
/*    */   public void setCount(int count) {
/* 68 */     this.count = count;
/*    */   }
/*    */   
/*    */   public Product getProduct() {
/* 72 */     return this.product;
/*    */   }
/*    */   
/*    */   public void setProduct(Product product) {
/* 76 */     this.product = product;
/*    */   }
/*    */   
/*    */   public List<Product> getProductList() {
/* 80 */     return this.productList;
/*    */   }
/*    */   
/*    */   public void setProductList(List<Product> productList) {
/* 84 */     this.productList = productList;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dto\ProductExecution.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */