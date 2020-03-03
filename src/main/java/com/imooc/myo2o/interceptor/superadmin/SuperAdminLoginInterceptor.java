/*    */ package com.imooc.myo2o.interceptor.superadmin;
/*    */ 
/*    */ import com.imooc.myo2o.entity.PersonInfo;
/*    */ import java.io.PrintWriter;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*    */ 
/*    */ public class SuperAdminLoginInterceptor
/*    */   extends HandlerInterceptorAdapter
/*    */ {
/*    */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
/*    */     throws Exception
/*    */   {
/* 16 */     Object userObj = request.getSession().getAttribute("user");
/* 17 */     if (userObj != null) {
/* 18 */       PersonInfo user = (PersonInfo)userObj;
/* 19 */       if ((user != null) && (user.getUserId() != null) && 
/* 20 */         (user.getUserId().longValue() > 0L) && (user.getAdminFlag() != null) && 
/* 21 */         (user.getAdminFlag().intValue() == 1))
/* 22 */         return true;
/*    */     }
/* 24 */     PrintWriter out = response.getWriter();
/* 25 */     out.println("<html>");
/* 26 */     out.println("<script>");
/* 27 */     out.println("window.open ('" + request.getContextPath() + "/superadmin/login','_top')");
/*    */     
/* 29 */     out.println("</script>");
/* 30 */     out.println("</html>");
/* 31 */     return false;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\interceptor\superadmin\SuperAdminLoginInterceptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */