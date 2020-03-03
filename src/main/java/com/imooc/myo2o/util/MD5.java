/*    */ package com.imooc.myo2o.util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.security.MessageDigest;
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
/*    */ public class MD5
/*    */ {
/*    */   public static final String getMd5(String s)
/*    */   {
/* 23 */     char[] hexDigits = { '5', '0', '5', '6', '2', '9', '6', '2', '5', 'q', 'b', 'l', 'e', 's', 's', 'y' };
/*    */     
/*    */ 
/*    */ 
/*    */     try
/*    */     {
/* 29 */       byte[] strTemp = s.getBytes();
/* 30 */       MessageDigest mdTemp = MessageDigest.getInstance("MD5");
/* 31 */       mdTemp.update(strTemp);
/* 32 */       byte[] md = mdTemp.digest();
/* 33 */       int j = md.length;
/* 34 */       char[] str = new char[j * 2];
/* 35 */       int k = 0;
/* 36 */       for (int i = 0; i < j; i++)
/*    */       {
/* 38 */         byte byte0 = md[i];
/* 39 */         str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
/* 40 */         str[(k++)] = hexDigits[(byte0 & 0xF)];
/*    */       }
/*    */       
/* 43 */       return new String(str);
/*    */     } catch (Exception e) {}
/* 45 */     return null;
/*    */   }
/*    */   
/*    */   public static void main(String[] args)
/*    */   {
/* 50 */     System.out.println(getMd5("admin"));
/*    */   }
/*    */ }


