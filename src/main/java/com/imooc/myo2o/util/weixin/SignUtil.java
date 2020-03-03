/*    */ package com.imooc.myo2o.util.weixin;
/*    */ 
/*    */ import java.security.MessageDigest;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import java.util.Arrays;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class SignUtil
/*    */ {
/* 12 */   private static String token = "myo2o";
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   public static boolean checkSignature(String signature, String timestamp, String nonce)
/*    */   {
/* 23 */     String[] arr = { token, timestamp, nonce };
/*    */     
/* 25 */     Arrays.sort(arr);
/* 26 */     StringBuilder content = new StringBuilder();
/* 27 */     for (int i = 0; i < arr.length; i++) {
/* 28 */       content.append(arr[i]);
/*    */     }
/* 30 */     MessageDigest md = null;
/* 31 */     String tmpStr = null;
/*    */     try
/*    */     {
/* 34 */       md = MessageDigest.getInstance("SHA-1");
/*    */       
/* 36 */       byte[] digest = md.digest(content.toString().getBytes());
/* 37 */       tmpStr = byteToStr(digest);
/*    */     } catch (NoSuchAlgorithmException e) {
/* 39 */       e.printStackTrace();
/*    */     }
/*    */     
/* 42 */     content = null;
/*    */     
/* 44 */     return tmpStr != null ? tmpStr.equals(signature.toUpperCase()) : false;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static String byteToStr(byte[] byteArray)
/*    */   {
/* 54 */     String strDigest = "";
/* 55 */     for (int i = 0; i < byteArray.length; i++) {
/* 56 */       strDigest = strDigest + byteToHexStr(byteArray[i]);
/*    */     }
/* 58 */     return strDigest;
/*    */   }
/*    */   
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   private static String byteToHexStr(byte mByte)
/*    */   {
/* 68 */     char[] Digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
/* 69 */     char[] tempArr = new char[2];
/* 70 */     tempArr[0] = Digit[(mByte >>> 4 & 0xF)];
/* 71 */     tempArr[1] = Digit[(mByte & 0xF)];
/*    */     
/* 73 */     String s = new String(tempArr);
/* 74 */     return s;
/*    */   }
/*    */ }

