/*    */ package com.imooc.myo2o.dto;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Result<T>
/*    */ {
/*    */   private boolean success;
/*    */   
/*    */   private T data;
/*    */   
/*    */   private String errorMsg;
/*    */   
/*    */   private int errorCode;
/*    */   
/*    */ 
/*    */   public Result() {}
/*    */   
/*    */ 
/*    */   public Result(boolean success, T data)
/*    */   {
/* 21 */     this.success = success;
/* 22 */     this.data = data;
/*    */   }
/*    */   
/*    */   public Result(boolean success, int errorCode, String errorMsg)
/*    */   {
/* 27 */     this.success = success;
/* 28 */     this.errorMsg = errorMsg;
/* 29 */     this.errorCode = errorCode;
/*    */   }
/*    */   
/*    */   public boolean isSuccess() {
/* 33 */     return this.success;
/*    */   }
/*    */   
/*    */   public void setSuccess(boolean success) {
/* 37 */     this.success = success;
/*    */   }
/*    */   
/*    */   public T getData() {
/* 41 */     return (T)this.data;
/*    */   }
/*    */   
/*    */   public void setData(T data) {
/* 45 */     this.data = data;
/*    */   }
/*    */   
/*    */   public String getErrorMsg() {
/* 49 */     return this.errorMsg;
/*    */   }
/*    */   
/*    */   public void setErrorMsg(String errorMsg) {
/* 53 */     this.errorMsg = errorMsg;
/*    */   }
/*    */   
/*    */   public int getErrorCode() {
/* 57 */     return this.errorCode;
/*    */   }
/*    */   
/*    */   public void setErrorCode(int errorCode) {
/* 61 */     this.errorCode = errorCode;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dto\Result.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */