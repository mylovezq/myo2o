/*    */ package com.imooc.myo2o.interceptor.shop;
/*    */ 
/*    */ import com.imooc.myo2o.entity.Shop;
/*    */ import java.util.List;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import javax.servlet.http.HttpServletResponse;
/*    */ import javax.servlet.http.HttpSession;
/*    */ import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
/*    */ 
/*    */ public class ShopPermissionInterceptor
/*    */   extends HandlerInterceptorAdapter
/*    */ {
/*    */   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
/*    */     throws Exception
/*    */   {
/* 16 */     Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");
/*    */     
/*    */ 
/* 19 */     List<Shop> shopList = (List)request.getSession().getAttribute("shopList");
/*    */     
/* 21 */     if ((currentShop != null) && (shopList != null)) {
/* 22 */       for (Shop shop : shopList) {
/* 23 */         if (shop.getShopId() == currentShop.getShopId()) {
/* 24 */           return true;
/*    */         }
/*    */       }
/*    */     }
/* 28 */     return false;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\interceptor\shop\ShopPermissionInterceptor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */