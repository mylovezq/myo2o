/*    */ package com.imooc.myo2o.dto;
/*    */ 
/*    */ import com.imooc.myo2o.entity.UserShopMap;
/*    */ import com.imooc.myo2o.enums.UserShopMapStateEnum;
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
/*    */ public class UserShopMapExecution
/*    */ {
/*    */   private int state;
/*    */   private String stateInfo;
/*    */   private Integer count;
/*    */   private UserShopMap userShopMap;
/*    */   private List<UserShopMap> userShopMapList;
/*    */   
/*    */   public UserShopMapExecution() {}
/*    */   
/*    */   public UserShopMapExecution(UserShopMapStateEnum stateEnum)
/*    */   {
/* 29 */     this.state = stateEnum.getState();
/* 30 */     this.stateInfo = stateEnum.getStateInfo();
/*    */   }
/*    */   
/*    */ 
/*    */   public UserShopMapExecution(UserShopMapStateEnum stateEnum, UserShopMap userShopMap)
/*    */   {
/* 36 */     this.state = stateEnum.getState();
/* 37 */     this.stateInfo = stateEnum.getStateInfo();
/* 38 */     this.userShopMap = userShopMap;
/*    */   }
/*    */   
/*    */ 
/*    */   public UserShopMapExecution(UserShopMapStateEnum stateEnum, List<UserShopMap> userShopMapList)
/*    */   {
/* 44 */     this.state = stateEnum.getState();
/* 45 */     this.stateInfo = stateEnum.getStateInfo();
/* 46 */     this.userShopMapList = userShopMapList;
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
/*    */   public UserShopMap getUserShopMap() {
/* 74 */     return this.userShopMap;
/*    */   }
/*    */   
/*    */   public void setUserShopMap(UserShopMap userShopMap) {
/* 78 */     this.userShopMap = userShopMap;
/*    */   }
/*    */   
/*    */   public List<UserShopMap> getUserShopMapList() {
/* 82 */     return this.userShopMapList;
/*    */   }
/*    */   
/*    */   public void setUserShopMapList(List<UserShopMap> userShopMapList) {
/* 86 */     this.userShopMapList = userShopMapList;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dto\UserShopMapExecution.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */