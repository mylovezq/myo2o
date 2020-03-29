 package com.imooc.myo2o.interceptor.shopadmin;

 import com.imooc.myo2o.entity.PersonInfo;
 import java.io.PrintWriter;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;

 import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

 public class ShopLoginInterceptor
   extends HandlerInterceptorAdapter
 {
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
     throws Exception
   {
     Object userObj = request.getSession().getAttribute("user");
     if (userObj != null) {
       PersonInfo user = (PersonInfo)userObj;
       if ((user != null) && (user.getUserId() != null) &&
         (user.getUserId().longValue() > 0L) && (user.getEnableStatus().intValue() == 1) &&
         (user.getShopOwnerFlag().intValue() == 1))
         return true;
     }
     PrintWriter out = response.getWriter();
     out.println("<html>");
     out.println("<script>");
     out.println("window.open ('" + request.getContextPath() + "/local/login?usertype=2','_self')");
     out.println("</script>");
     out.println("</html>");
     return false;
   }
 }
