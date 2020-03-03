/*    */ package com.imooc.myo2o.dto;
/*    */ 
/*    */ import com.imooc.myo2o.entity.Shop;
/*    */ import com.imooc.myo2o.enums.ShopStateEnum;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ShopExecution
/*    */ {
/*    */   private int state;
/*    */   private String stateInfo;
/*    */   private int count;
/*    */   private Shop shop;
/*    */   private List<Shop> shopList;
/*    */   
/*    */   public ShopExecution() {}
/*    */   
/*    */   public ShopExecution(ShopStateEnum stateEnum)
/*    */   {
/* 33 */     this.state = stateEnum.getState();
/* 34 */     this.stateInfo = stateEnum.getStateInfo();
/*    */   }
/*    */   
/*    */   public ShopExecution(ShopStateEnum stateEnum, Shop shop)
/*    */   {
/* 39 */     this.state = stateEnum.getState();
/* 40 */     this.stateInfo = stateEnum.getStateInfo();
/* 41 */     this.shop = shop;
/*    */   }
/*    */   
/*    */   public ShopExecution(ShopStateEnum stateEnum, List<Shop> shopList)
/*    */   {
/* 46 */     this.state = stateEnum.getState();
/* 47 */     this.stateInfo = stateEnum.getStateInfo();
/* 48 */     this.shopList = shopList;
/*    */   }
/*    */   
/*    */   public int getState() {
/* 52 */     return this.state;
/*    */   }
/*    */   
/*    */   public void setState(int state) {
/* 56 */     this.state = state;
/*    */   }
/*    */   
/*    */   public String getStateInfo() {
/* 60 */     return this.stateInfo;
/*    */   }
/*    */   
/*    */   public void setStateInfo(String stateInfo) {
/* 64 */     this.stateInfo = stateInfo;
/*    */   }
/*    */   
/*    */   public int getCount() {
/* 68 */     return this.count;
/*    */   }
/*    */   
/*    */   public void setCount(int count) {
/* 72 */     this.count = count;
/*    */   }
/*    */   
/*    */   public Shop getShop() {
/* 76 */     return this.shop;
/*    */   }
/*    */   
/*    */   public void setShop(Shop shop) {
/* 80 */     this.shop = shop;
/*    */   }
/*    */   
/*    */   public List<Shop> getShopList() {
/* 84 */     return this.shopList;
/*    */   }
/*    */   
/*    */   public void setShopList(List<Shop> shopList) {
/* 88 */     this.shopList = shopList;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dto\ShopExecution.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */