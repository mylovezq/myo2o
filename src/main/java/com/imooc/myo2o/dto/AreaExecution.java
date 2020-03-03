/*    */ package com.imooc.myo2o.dto;
/*    */ 
/*    */ import com.imooc.myo2o.entity.Area;
/*    */ import com.imooc.myo2o.enums.AreaStateEnum;
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
/*    */ public class AreaExecution
/*    */ {
/*    */   private int state;
/*    */   private String stateInfo;
/*    */   private int count;
/*    */   private Area area;
/*    */   private List<Area> areaList;
/*    */   
/*    */   public AreaExecution() {}
/*    */   
/*    */   public AreaExecution(AreaStateEnum stateEnum)
/*    */   {
/* 29 */     this.state = stateEnum.getState();
/* 30 */     this.stateInfo = stateEnum.getStateInfo();
/*    */   }
/*    */   
/*    */   public AreaExecution(AreaStateEnum stateEnum, Area area)
/*    */   {
/* 35 */     this.state = stateEnum.getState();
/* 36 */     this.stateInfo = stateEnum.getStateInfo();
/* 37 */     this.area = area;
/*    */   }
/*    */   
/*    */   public AreaExecution(AreaStateEnum stateEnum, List<Area> areaList)
/*    */   {
/* 42 */     this.state = stateEnum.getState();
/* 43 */     this.stateInfo = stateEnum.getStateInfo();
/* 44 */     this.areaList = areaList;
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
/*    */   public Area getArea() {
/* 72 */     return this.area;
/*    */   }
/*    */   
/*    */   public void setArea(Area area) {
/* 76 */     this.area = area;
/*    */   }
/*    */   
/*    */   public List<Area> getAreaList() {
/* 80 */     return this.areaList;
/*    */   }
/*    */   
/*    */   public void setAreaList(List<Area> areaList) {
/* 84 */     this.areaList = areaList;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dto\AreaExecution.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */