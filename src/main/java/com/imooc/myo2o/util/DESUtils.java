/*    */ package com.imooc.myo2o.util;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.security.Key;
/*    */ import java.security.SecureRandom;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.KeyGenerator;
/*    */ import sun.misc.BASE64Decoder;
/*    */ import sun.misc.BASE64Encoder;
/*    */ 
/*    */ 
/*    */ public class DESUtils
/*    */ {
/*    */   private static Key key;
/* 15 */   private static String KEY_STR = "myKey";
/* 16 */   private static String CHARSETNAME = "UTF-8";
/* 17 */   private static String ALGORITHM = "DES";
/*    */   
/*    */   static {
/*    */     try {
/* 21 */       KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
/* 22 */       SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
/* 23 */       secureRandom.setSeed(KEY_STR.getBytes());
/* 24 */       generator.init(secureRandom);
/* 25 */       key = generator.generateKey();
/* 26 */       generator = null;
/*    */     } catch (Exception e) {
/* 28 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */   
/*    */   public static String getEncryptString(String str) {
/* 33 */     BASE64Encoder base64encoder = new BASE64Encoder();
/*    */     try {
/* 35 */       byte[] bytes = str.getBytes(CHARSETNAME);
/* 36 */       Cipher cipher = Cipher.getInstance(ALGORITHM);
/* 37 */       cipher.init(1, key);
/* 38 */       byte[] doFinal = cipher.doFinal(bytes);
/* 39 */       return base64encoder.encode(doFinal);
/*    */     }
/*    */     catch (Exception e) {
/* 42 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */   
/*    */   public static String getDecryptString(String str)
/*    */   {
/* 48 */     BASE64Decoder base64decoder = new BASE64Decoder();
/*    */     try {
/* 50 */       byte[] bytes = base64decoder.decodeBuffer(str);
/* 51 */       Cipher cipher = Cipher.getInstance(ALGORITHM);
/* 52 */       cipher.init(2, key);
/* 53 */       byte[] doFinal = cipher.doFinal(bytes);
/* 54 */       return new String(doFinal, CHARSETNAME);
/*    */     }
/*    */     catch (Exception e) {
/* 57 */       throw new RuntimeException(e);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void main(String[] args) {
/* 62 */     System.out.println(getEncryptString("123456"));
/*    */   }
/*    */ }


