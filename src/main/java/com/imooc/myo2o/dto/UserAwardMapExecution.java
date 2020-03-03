/*    */ package com.imooc.myo2o.dto;
/*    */ 
/*    */ import com.imooc.myo2o.entity.UserAwardMap;
/*    */ import com.imooc.myo2o.enums.UserAwardMapStateEnum;
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
/*    */ public class UserAwardMapExecution
/*    */ {
/*    */   private int state;
/*    */   private String stateInfo;
/*    */   private Integer count;
/*    */   private UserAwardMap userAwardMap;
/*    */   private List<UserAwardMap> userAwardMapList;
/*    */   
/*    */   public UserAwardMapExecution() {}
/*    */   
/*    */   public UserAwardMapExecution(UserAwardMapStateEnum stateEnum)
/*    */   {
/* 29 */     this.state = stateEnum.getState();
/* 30 */     this.stateInfo = stateEnum.getStateInfo();
/*    */   }
/*    */   
/*    */ 
/*    */   public UserAwardMapExecution(UserAwardMapStateEnum stateEnum, UserAwardMap userAwardMap)
/*    */   {
/* 36 */     this.state = stateEnum.getState();
/* 37 */     this.stateInfo = stateEnum.getStateInfo();
/* 38 */     this.userAwardMap = userAwardMap;
/*    */   }
/*    */   
/*    */ 
/*    */   public UserAwardMapExecution(UserAwardMapStateEnum stateEnum, List<UserAwardMap> userAwardMapList)
/*    */   {
/* 44 */     this.state = stateEnum.getState();
/* 45 */     this.stateInfo = stateEnum.getStateInfo();
/* 46 */     this.userAwardMapList = userAwardMapList;
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
/*    */   public UserAwardMap getUserAwardMap() {
/* 74 */     return this.userAwardMap;
/*    */   }
/*    */   
/*    */   public void setUserAwardMap(UserAwardMap userAwardMap) {
/* 78 */     this.userAwardMap = userAwardMap;
/*    */   }
/*    */   
/*    */   public List<UserAwardMap> getUserAwardMapList() {
/* 82 */     return this.userAwardMapList;
/*    */   }
/*    */   
/*    */   public void setUserAwardMapList(List<UserAwardMap> userAwardMapList) {
/* 86 */     this.userAwardMapList = userAwardMapList;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dto\UserAwardMapExecution.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */