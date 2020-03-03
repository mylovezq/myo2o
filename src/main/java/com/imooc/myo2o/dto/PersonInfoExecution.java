/*    */ package com.imooc.myo2o.dto;
/*    */ 
/*    */ import com.imooc.myo2o.entity.PersonInfo;
/*    */ import com.imooc.myo2o.enums.PersonInfoStateEnum;
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
/*    */ public class PersonInfoExecution
/*    */ {
/*    */   private int state;
/*    */   private String stateInfo;
/*    */   private int count;
/*    */   private PersonInfo personInfo;
/*    */   private List<PersonInfo> personInfoList;
/*    */   
/*    */   public PersonInfoExecution() {}
/*    */   
/*    */   public PersonInfoExecution(PersonInfoStateEnum stateEnum)
/*    */   {
/* 33 */     this.state = stateEnum.getState();
/* 34 */     this.stateInfo = stateEnum.getStateInfo();
/*    */   }
/*    */   
/*    */ 
/*    */   public PersonInfoExecution(PersonInfoStateEnum stateEnum, PersonInfo personInfo)
/*    */   {
/* 40 */     this.state = stateEnum.getState();
/* 41 */     this.stateInfo = stateEnum.getStateInfo();
/* 42 */     this.personInfo = personInfo;
/*    */   }
/*    */   
/*    */ 
/*    */   public PersonInfoExecution(PersonInfoStateEnum stateEnum, List<PersonInfo> personInfoList)
/*    */   {
/* 48 */     this.state = stateEnum.getState();
/* 49 */     this.stateInfo = stateEnum.getStateInfo();
/* 50 */     this.personInfoList = personInfoList;
/*    */   }
/*    */   
/*    */   public int getState() {
/* 54 */     return this.state;
/*    */   }
/*    */   
/*    */   public void setState(int state) {
/* 58 */     this.state = state;
/*    */   }
/*    */   
/*    */   public String getStateInfo() {
/* 62 */     return this.stateInfo;
/*    */   }
/*    */   
/*    */   public void setStateInfo(String stateInfo) {
/* 66 */     this.stateInfo = stateInfo;
/*    */   }
/*    */   
/*    */   public int getCount() {
/* 70 */     return this.count;
/*    */   }
/*    */   
/*    */   public void setCount(int count) {
/* 74 */     this.count = count;
/*    */   }
/*    */   
/*    */   public PersonInfo getPersonInfo() {
/* 78 */     return this.personInfo;
/*    */   }
/*    */   
/*    */   public void setPersonInfo(PersonInfo personInfo) {
/* 82 */     this.personInfo = personInfo;
/*    */   }
/*    */   
/*    */   public List<PersonInfo> getPersonInfoList() {
/* 86 */     return this.personInfoList;
/*    */   }
/*    */   
/*    */   public void setPersonInfoList(List<PersonInfo> personInfoList) {
/* 90 */     this.personInfoList = personInfoList;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dto\PersonInfoExecution.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */