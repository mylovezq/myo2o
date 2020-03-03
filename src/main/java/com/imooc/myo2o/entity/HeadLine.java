/*    */ package com.imooc.myo2o.entity;
/*    */ 
/*    */ import java.util.Date;
/*    */ 
/*    */ public class HeadLine {
/*    */   private Long lineId;
/*    */   private String lineName;
/*    */   private String lineLink;
/*    */   private String lineImg;
/*    */   private Integer priority;
/*    */   private Integer enableStatus;
/*    */   private Date createTime;
/*    */   private Date lastEditTime;
/*    */   
/*    */   public Long getLineId() {
/* 16 */     return this.lineId;
/*    */   }
/*    */   
/*    */   public void setLineId(Long lineId) {
/* 20 */     this.lineId = lineId;
/*    */   }
/*    */   
/*    */   public String getLineName() {
/* 24 */     return this.lineName;
/*    */   }
/*    */   
/*    */   public void setLineName(String lineName) {
/* 28 */     this.lineName = lineName;
/*    */   }
/*    */   
/*    */   public String getLineLink() {
/* 32 */     return this.lineLink;
/*    */   }
/*    */   
/*    */   public void setLineLink(String lineLink) {
/* 36 */     this.lineLink = lineLink;
/*    */   }
/*    */   
/*    */   public String getLineImg() {
/* 40 */     return this.lineImg;
/*    */   }
/*    */   
/*    */   public void setLineImg(String lineImg) {
/* 44 */     this.lineImg = lineImg;
/*    */   }
/*    */   
/*    */   public Integer getPriority() {
/* 48 */     return this.priority;
/*    */   }
/*    */   
/*    */   public void setPriority(Integer priority) {
/* 52 */     this.priority = priority;
/*    */   }
/*    */   
/*    */   public Integer getEnableStatus() {
/* 56 */     return this.enableStatus;
/*    */   }
/*    */   
/*    */   public void setEnableStatus(Integer enableStatus) {
/* 60 */     this.enableStatus = enableStatus;
/*    */   }
/*    */   
/*    */   public Date getCreateTime() {
/* 64 */     return this.createTime;
/*    */   }
/*    */   
/*    */   public void setCreateTime(Date createTime) {
/* 68 */     this.createTime = createTime;
/*    */   }
/*    */   
/*    */   public Date getLastEditTime() {
/* 72 */     return this.lastEditTime;
/*    */   }
/*    */   
/*    */   public void setLastEditTime(Date lastEditTime) {
/* 76 */     this.lastEditTime = lastEditTime;
/*    */   }
/*    */ }


