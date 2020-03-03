/*    */ package com.imooc.myo2o.dto;
/*    */ 
/*    */ import com.imooc.myo2o.entity.WechatAuth;
/*    */ import com.imooc.myo2o.enums.WechatAuthStateEnum;
/*    */ import java.util.List;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WechatAuthExecution
/*    */ {
/*    */   private int state;
/*    */   private String stateInfo;
/*    */   private int count;
/*    */   private WechatAuth wechatAuth;
/*    */   private List<WechatAuth> wechatAuthList;
/*    */   
/*    */   public WechatAuthExecution() {}
/*    */   
/*    */   public WechatAuthExecution(WechatAuthStateEnum stateEnum)
/*    */   {
/* 26 */     this.state = stateEnum.getState();
/* 27 */     this.stateInfo = stateEnum.getStateInfo();
/*    */   }
/*    */   
/*    */   public WechatAuthExecution(WechatAuthStateEnum stateEnum, WechatAuth wechatAuth)
/*    */   {
/* 32 */     this.state = stateEnum.getState();
/* 33 */     this.stateInfo = stateEnum.getStateInfo();
/* 34 */     this.wechatAuth = wechatAuth;
/*    */   }
/*    */   
/*    */ 
/*    */   public WechatAuthExecution(WechatAuthStateEnum stateEnum, List<WechatAuth> wechatAuthList)
/*    */   {
/* 40 */     this.state = stateEnum.getState();
/* 41 */     this.stateInfo = stateEnum.getStateInfo();
/* 42 */     this.wechatAuthList = wechatAuthList;
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
/*    */   public WechatAuth getWechatAuth() {
/* 70 */     return this.wechatAuth;
/*    */   }
/*    */   
/*    */   public void setWechatAuth(WechatAuth wechatAuth) {
/* 74 */     this.wechatAuth = wechatAuth;
/*    */   }
/*    */   
/*    */   public List<WechatAuth> getWechatAuthList() {
/* 78 */     return this.wechatAuthList;
/*    */   }
/*    */   
/*    */   public void setWechatAuthList(List<WechatAuth> wechatAuthList) {
/* 82 */     this.wechatAuthList = wechatAuthList;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dto\WechatAuthExecution.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */