 package com.imooc.myo2o.interceptor.superadmin;

 import com.imooc.myo2o.entity.PersonInfo;
 import java.io.PrintWriter;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 import javax.servlet.http.HttpSession;
 import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

 public class SuperAdminLoginInterceptor
   extends HandlerInterceptorAdapter
 {
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
     throws Exception
   {
     Object userObj = request.getSession().getAttribute("user");
     if (userObj != null) {
       PersonInfo user = (PersonInfo)userObj;
       if ((user != null) && (user.getUserId() != null) &&
         (user.getUserId().longValue() > 0L) && (user.getAdminFlag() != null) &&
         (user.getAdminFlag().intValue() == 1))
         return true;
     }
     PrintWriter out = response.getWriter();
     out.println("<html>");
     out.println("<script>");
     out.println("window.open ('" + request.getContextPath() + "/superadmin/login','_top')");

     out.println("</script>");
     out.println("</html>");
     return false;
   }
 }

