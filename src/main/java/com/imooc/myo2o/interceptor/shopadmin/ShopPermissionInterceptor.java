package com.imooc.myo2o.interceptor.shopadmin;

import com.imooc.myo2o.entity.Shop;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class ShopPermissionInterceptor
  extends HandlerInterceptorAdapter
{
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
    throws Exception
  {
    Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");

@SuppressWarnings("unchecked")
    List<Shop> shopList = (List)request.getSession().getAttribute("shopList");

    if ((currentShop != null) && (shopList != null)) {
      for (Shop shop : shopList) {
        if (shop.getShopId() == currentShop.getShopId()) {
          return true;
        }
      }
    }
    return false;
  }
}
