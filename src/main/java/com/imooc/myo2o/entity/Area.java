/*    */ package com.imooc.myo2o.entity;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class Area {
/*    */   private Long areaId;
/*    */   private String areaName;
/*    */   private String areaDesc;
/*    */   private Integer priority;
/*    */   private Date createTime;
/*    */   private Date lastEditTime;
/*    */   
/*    */   public Long getAreaId() {
/* 14 */     return this.areaId;
/*    */   }
/*    */   
/*    */   public void setAreaId(Long areaId) {
/* 18 */     this.areaId = areaId;
/*    */   }
/*    */   
/*    */   public String getAreaName() {
/* 22 */     return this.areaName;
/*    */   }
/*    */   
/*    */   public void setAreaName(String areaName) {
/* 26 */     this.areaName = areaName;
/*    */   }
/*    */   
/*    */   public String getAreaDesc() {
/* 30 */     return this.areaDesc;
/*    */   }
/*    */   
/*    */   public void setAreaDesc(String areaDesc) {
/* 34 */     this.areaDesc = areaDesc;
/*    */   }
/*    */   
/*    */   public Integer getPriority() {
/* 38 */     return this.priority;
/*    */   }
/*    */   
/*    */   public void setPriority(Integer priority) {
/* 42 */     this.priority = priority;
/*    */   }
/*    */   
/*    */   public Date getCreateTime() {
/* 46 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public void setCreateTime(Date createTime) {
/* 50 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */   public Date getLastEditTime() {
/* 54 */     return this.lastEditTime;
/*    */   }
/*    */   
/*    */   public void setLastEditTime(Date lastEditTime) {
/* 58 */     this.lastEditTime = lastEditTime;
/*    */   }
/*    */   
/*    */   public String toString()
/*    */   {
/* 63 */     return "Area{areaId=" + this.areaId + ", areaName='" + this.areaName + '\'' + ", areaDesc='" + this.areaDesc + '\'' + ", priority=" + this.priority + ", createTime=" + this.createTime + ", lastEditTime=" + this.lastEditTime + '}';
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\entity\Area.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */