/*    */ package com.imooc.myo2o.dto;
/*    */ 
/*    */ import com.imooc.myo2o.entity.UserProductMap;
/*    */ import com.imooc.myo2o.enums.UserProductMapStateEnum;
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
/*    */ public class UserProductMapExecution
/*    */ {
/*    */   private int state;
/*    */   private String stateInfo;
/*    */   private Integer count;
/*    */   private UserProductMap userProductMap;
/*    */   private List<UserProductMap> userProductMapList;
/*    */   
/*    */   public UserProductMapExecution() {}
/*    */   
/*    */   public UserProductMapExecution(UserProductMapStateEnum stateEnum)
/*    */   {
/* 29 */     this.state = stateEnum.getState();
/* 30 */     this.stateInfo = stateEnum.getStateInfo();
/*    */   }
/*    */   
/*    */ 
/*    */   public UserProductMapExecution(UserProductMapStateEnum stateEnum, UserProductMap userProductMap)
/*    */   {
/* 36 */     this.state = stateEnum.getState();
/* 37 */     this.stateInfo = stateEnum.getStateInfo();
/* 38 */     this.userProductMap = userProductMap;
/*    */   }
/*    */   
/*    */ 
/*    */   public UserProductMapExecution(UserProductMapStateEnum stateEnum, List<UserProductMap> userProductMapList)
/*    */   {
/* 44 */     this.state = stateEnum.getState();
/* 45 */     this.stateInfo = stateEnum.getStateInfo();
/* 46 */     this.userProductMapList = userProductMapList;
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
/*    */   public UserProductMap getUserProductMap() {
/* 74 */     return this.userProductMap;
/*    */   }
/*    */   
/*    */   public void setUserProductMap(UserProductMap userProductMap) {
/* 78 */     this.userProductMap = userProductMap;
/*    */   }
/*    */   
/*    */   public List<UserProductMap> getUserProductMapList() {
/* 82 */     return this.userProductMapList;
/*    */   }
/*    */   
/*    */   public void setUserProductMapList(List<UserProductMap> userProductMapList) {
/* 86 */     this.userProductMapList = userProductMapList;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dto\UserProductMapExecution.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */