/*    */ package com.imooc.myo2o.dto;
/*    */ 
/*    */ import com.imooc.myo2o.entity.ShopAuthMap;
/*    */ import com.imooc.myo2o.enums.ShopAuthMapStateEnum;
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
/*    */ public class ShopAuthMapExecution
/*    */ {
/*    */   private int state;
/*    */   private String stateInfo;
/*    */   private Integer count;
/*    */   private ShopAuthMap shopAuthMap;
/*    */   private List<ShopAuthMap> shopAuthMapList;
/*    */   
/*    */   public ShopAuthMapExecution() {}
/*    */   
/*    */   public ShopAuthMapExecution(ShopAuthMapStateEnum stateEnum)
/*    */   {
/* 29 */     this.state = stateEnum.getState();
/* 30 */     this.stateInfo = stateEnum.getStateInfo();
/*    */   }
/*    */   
/*    */ 
/*    */   public ShopAuthMapExecution(ShopAuthMapStateEnum stateEnum, ShopAuthMap shopAuthMap)
/*    */   {
/* 36 */     this.state = stateEnum.getState();
/* 37 */     this.stateInfo = stateEnum.getStateInfo();
/* 38 */     this.shopAuthMap = shopAuthMap;
/*    */   }
/*    */   
/*    */ 
/*    */   public ShopAuthMapExecution(ShopAuthMapStateEnum stateEnum, List<ShopAuthMap> shopAuthMapList)
/*    */   {
/* 44 */     this.state = stateEnum.getState();
/* 45 */     this.stateInfo = stateEnum.getStateInfo();
/* 46 */     this.shopAuthMapList = shopAuthMapList;
/*    */   }
/*    */   
/*    */   public int getState() {
/* 50 */     return this.state;
/*    */   }
/*    */   
/*    */   public void setState(int state) {
/* 54 */     this.state = state;
/*    */   }
/*    */   
/*    */   public String getStateInfo() {
/* 58 */     return this.stateInfo;
/*    */   }
/*    */   
/*    */   public void setStateInfo(String stateInfo) {
/* 62 */     this.stateInfo = stateInfo;
/*    */   }
/*    */   
/*    */   public Integer getCount() {
/* 66 */     return this.count;
/*    */   }
/*    */   
/*    */   public void setCount(Integer count) {
/* 70 */     this.count = count;
/*    */   }
/*    */   
/*    */   public ShopAuthMap getShopAuthMap() {
/* 74 */     return this.shopAuthMap;
/*    */   }
/*    */   
/*    */   public void setShopAuthMap(ShopAuthMap shopAuthMap) {
/* 78 */     this.shopAuthMap = shopAuthMap;
/*    */   }
/*    */   
/*    */   public List<ShopAuthMap> getShopAuthMapList() {
/* 82 */     return this.shopAuthMapList;
/*    */   }
/*    */   
/*    */   public void setShopAuthMapList(List<ShopAuthMap> shopAuthMapList) {
/* 86 */     this.shopAuthMapList = shopAuthMapList;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dto\ShopAuthMapExecution.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */