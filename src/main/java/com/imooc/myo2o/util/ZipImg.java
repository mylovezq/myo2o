/*    */ package com.imooc.myo2o.util;
/*    */ 
/*    */ import net.coobird.thumbnailator.Thumbnails.Builder;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ public class ZipImg
/*    */ {
/*    */   public static MultipartFile zipImg(MultipartFile file)
/*    */   {
/*    */     try
/*    */     {
/* 12 */       java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 13 */       net.coobird.thumbnailator.Thumbnails.of(new java.io.InputStream[] { file.getInputStream() }).scale(0.30000001192092896D).outputQuality(0.4F).toOutputStream(baos);
/* 14 */       java.io.InputStream swapStream = new java.io.ByteArrayInputStream(baos.toByteArray());
/* 15 */       return new org.springframework.mock.web.MockMultipartFile(file.getName(), swapStream);
/*    */     }
/*    */     catch (Exception e) {
/* 18 */       new RuntimeException("压缩失败。。。" + e.getMessage());
/*    */     }
/* 20 */     return null;
/*    */   }
/*    */   
/*    */   public static MultipartFile zipImgs(MultipartFile file) {
/* 24 */     try { java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
/* 25 */       net.coobird.thumbnailator.Thumbnails.of(new java.io.InputStream[] { file.getInputStream() }).scale(1.0D).outputQuality(0.4F).toOutputStream(baos);
/* 26 */       java.io.InputStream swapStream = new java.io.ByteArrayInputStream(baos.toByteArray());
/* 27 */       return new org.springframework.mock.web.MockMultipartFile(file.getName(), swapStream);
/*    */     }
/*    */     catch (Exception e) {
/* 30 */       new RuntimeException("压缩失败。。。" + e.getMessage());
/*    */     }
/* 32 */     return null;
/*    */   }
/*    */ }


