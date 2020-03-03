/*    */ package com.imooc.myo2o.dto;
/*    */ 
/*    */ import com.imooc.myo2o.entity.Award;
/*    */ import com.imooc.myo2o.enums.AwardStateEnum;
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
/*    */ public class AwardExecution
/*    */ {
/*    */   private int state;
/*    */   private String stateInfo;
/*    */   private int count;
/*    */   private Award award;
/*    */   private List<Award> awardList;
/*    */   
/*    */   public AwardExecution() {}
/*    */   
/*    */   public AwardExecution(AwardStateEnum stateEnum)
/*    */   {
/* 29 */     this.state = stateEnum.getState();
/* 30 */     this.stateInfo = stateEnum.getStateInfo();
/*    */   }
/*    */   
/*    */   public AwardExecution(AwardStateEnum stateEnum, Award award)
/*    */   {
/* 35 */     this.state = stateEnum.getState();
/* 36 */     this.stateInfo = stateEnum.getStateInfo();
/* 37 */     this.award = award;
/*    */   }
/*    */   
/*    */ 
/*    */   public AwardExecution(AwardStateEnum stateEnum, List<Award> awardList)
/*    */   {
/* 43 */     this.state = stateEnum.getState();
/* 44 */     this.stateInfo = stateEnum.getStateInfo();
/* 45 */     this.awardList = awardList;
/*    */   }
/*    */   
/*    */   public int getState() {
/* 49 */     return this.state;
/*    */   }
/*    */   
/*    */   public void setState(int state) {
/* 53 */     this.state = state;
/*    */   }
/*    */   
/*    */   public String getStateInfo() {
/* 57 */     return this.stateInfo;
/*    */   }
/*    */   
/*    */   public void setStateInfo(String stateInfo) {
/* 61 */     this.stateInfo = stateInfo;
/*    */   }
/*    */   
/*    */   public int getCount() {
/* 65 */     return this.count;
/*    */   }
/*    */   
/*    */   public void setCount(int count) {
/* 69 */     this.count = count;
/*    */   }
/*    */   
/*    */   public Award getAward() {
/* 73 */     return this.award;
/*    */   }
/*    */   
/*    */   public void setAward(Award award) {
/* 77 */     this.award = award;
/*    */   }
/*    */   
/*    */   public List<Award> getAwardList() {
/* 81 */     return this.awardList;
/*    */   }
/*    */   
/*    */   public void setAwardList(List<Award> awardList) {
/* 85 */     this.awardList = awardList;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dto\AwardExecution.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */