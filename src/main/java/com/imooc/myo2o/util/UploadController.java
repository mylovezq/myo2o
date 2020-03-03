/*    */ package com.imooc.myo2o.util;
/*    */ 
/*    */ import com.imooc.myo2o.dto.Result;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.multipart.MultipartFile;
/*    */ 
/*    */ public class UploadController
/*    */ {
/*    */   @RequestMapping({"/upload"})
/*    */   public Result upload(MultipartFile file)
/*    */   {
/* 12 */     String originalFilername = file.getOriginalFilename();
/* 13 */     String exName = originalFilername.substring(originalFilername.lastIndexOf(".") + 1);
/*    */     try {
/* 15 */       FastDFSClient client = new FastDFSClient("config/fdfs_client.conf");
/* 16 */       String fileId = client.uploadFile(file.getBytes(), exName);
/* 17 */       String url = "http://39.105.24.155:9870/" + fileId;
/* 18 */       return new Result(true, url);
/*    */     } catch (Exception e) {
/* 20 */       e.printStackTrace(); }
/* 21 */     return new Result(false, -1, "上传失败！");
/*    */   }
/*    */ }

