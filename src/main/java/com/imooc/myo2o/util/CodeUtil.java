/*    */ package com.imooc.myo2o.util;
/*    */ 
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ 
/*    */ public class CodeUtil {
/*    */   public static boolean checkVerifyCode(HttpServletRequest request) {
/*  7 */     String verifyCodeExpected = (String)request.getSession().getAttribute("KAPTCHA_SESSION_KEY");
/*  8 */     String verifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");
/*  9 */     if ((verifyCodeActual == null) || (!verifyCodeActual.equalsIgnoreCase(verifyCodeExpected))) {
/* 10 */       return false;
/*    */     }
/* 12 */     return true;
/*    */   }
/*    */ }


