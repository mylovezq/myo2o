/*    */ package com.imooc.myo2o.dto;
/*    */ 
/*    */ import com.imooc.myo2o.entity.LocalAuth;
/*    */ import com.imooc.myo2o.enums.LocalAuthStateEnum;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LocalAuthExecution
/*    */ {
/*    */   private int state;
/*    */   private String stateInfo;
/*    */   private int count;
/*    */   private LocalAuth localAuth;
/*    */   private List<LocalAuth> localAuthList;
/*    */   
/*    */   public LocalAuthExecution() {}
/*    */   
/*    */   public LocalAuthExecution(LocalAuthStateEnum stateEnum)
/*    */   {
/* 26 */     this.state = stateEnum.getState();
/* 27 */     this.stateInfo = stateEnum.getStateInfo();
/*    */   }
/*    */   
/*    */   public LocalAuthExecution(LocalAuthStateEnum stateEnum, LocalAuth localAuth)
/*    */   {
/* 32 */     this.state = stateEnum.getState();
/* 33 */     this.stateInfo = stateEnum.getStateInfo();
/* 34 */     this.localAuth = localAuth;
/*    */   }
/*    */   
/*    */ 
/*    */   public LocalAuthExecution(LocalAuthStateEnum stateEnum, List<LocalAuth> localAuthList)
/*    */   {
/* 40 */     this.state = stateEnum.getState();
/* 41 */     this.stateInfo = stateEnum.getStateInfo();
/* 42 */     this.localAuthList = localAuthList;
/*    */   }
/*    */   
/*    */   public int getState() {
/* 46 */     return this.state;
/*    */   }
/*    */   
/*    */   public void setState(int state) {
/* 50 */     this.state = state;
/*    */   }
/*    */   
/*    */   public String getStateInfo() {
/* 54 */     return this.stateInfo;
/*    */   }
/*    */   
/*    */   public void setStateInfo(String stateInfo) {
/* 58 */     this.stateInfo = stateInfo;
/*    */   }
/*    */   
/*    */   public int getCount() {
/* 62 */     return this.count;
/*    */   }
/*    */   
/*    */   public void setCount(int count) {
/* 66 */     this.count = count;
/*    */   }
/*    */   
/*    */   public LocalAuth getLocalAuth() {
/* 70 */     return this.localAuth;
/*    */   }
/*    */   
/*    */   public void setLocalAuth(LocalAuth localAuth) {
/* 74 */     this.localAuth = localAuth;
/*    */   }
/*    */   
/*    */   public List<LocalAuth> getLocalAuthList() {
/* 78 */     return this.localAuthList;
/*    */   }
/*    */   
/*    */   public void setLocalAuthList(List<LocalAuth> localAuthList) {
/* 82 */     this.localAuthList = localAuthList;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dto\LocalAuthExecution.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */