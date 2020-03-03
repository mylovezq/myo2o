/*    */ package com.imooc.myo2o.dto;
/*    */ 
/*    */ import com.imooc.myo2o.entity.HeadLine;
/*    */ import com.imooc.myo2o.enums.HeadLineStateEnum;
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
/*    */ public class HeadLineExecution
/*    */ {
/*    */   private int state;
/*    */   private String stateInfo;
/*    */   private int count;
/*    */   private HeadLine headLine;
/*    */   private List<HeadLine> headLineList;
/*    */   
/*    */   public HeadLineExecution() {}
/*    */   
/*    */   public HeadLineExecution(HeadLineStateEnum stateEnum)
/*    */   {
/* 29 */     this.state = stateEnum.getState();
/* 30 */     this.stateInfo = stateEnum.getStateInfo();
/*    */   }
/*    */   
/*    */   public HeadLineExecution(HeadLineStateEnum stateEnum, HeadLine headLine)
/*    */   {
/* 35 */     this.state = stateEnum.getState();
/* 36 */     this.stateInfo = stateEnum.getStateInfo();
/* 37 */     this.headLine = headLine;
/*    */   }
/*    */   
/*    */   public HeadLineExecution(HeadLineStateEnum stateEnum, List<HeadLine> headLineList)
/*    */   {
/* 42 */     this.state = stateEnum.getState();
/* 43 */     this.stateInfo = stateEnum.getStateInfo();
/* 44 */     this.headLineList = headLineList;
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
/*    */   public HeadLine getHeadLine() {
/* 72 */     return this.headLine;
/*    */   }
/*    */   
/*    */   public void setHeadLine(HeadLine headLine) {
/* 76 */     this.headLine = headLine;
/*    */   }
/*    */   
/*    */   public List<HeadLine> getHeadLineList() {
/* 80 */     return this.headLineList;
/*    */   }
/*    */   
/*    */   public void setHeadLineList(List<HeadLine> headLineList) {
/* 84 */     this.headLineList = headLineList;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dto\HeadLineExecution.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */