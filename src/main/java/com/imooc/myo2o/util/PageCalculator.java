/*    */ package com.imooc.myo2o.util;
/*    */ 
/*    */ public class PageCalculator {
/*    */   public static int calculatePageCount(int totalCount, int pageSize) {
/*  5 */     int idealPage = totalCount / pageSize;
/*  6 */     int totalPage = totalCount % pageSize == 0 ? idealPage : idealPage + 1;
/*  7 */     return totalPage;
/*    */   }
/*    */   
/*    */   public static int calculateRowIndex(int pageIndex, int pageSize) {
/* 11 */     return pageIndex > 0 ? (pageIndex - 1) * pageSize : 0;
/*    */   }
/*    */ }


