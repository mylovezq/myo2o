package com.imooc.myo2o.service;

import com.imooc.myo2o.dto.ShopExecution;
import com.imooc.myo2o.entity.Shop;
import org.springframework.web.multipart.MultipartFile;

public abstract interface ShopService
{
  public abstract ShopExecution getShopList(Shop paramShop, int paramInt1, int paramInt2);
  
  public abstract ShopExecution getByEmployeeId(long paramLong)
    throws RuntimeException;
  
  public abstract Shop getByShopId(long paramLong);
  
  public abstract ShopExecution addShop(Shop paramShop, MultipartFile paramMultipartFile)
    throws RuntimeException;
  
  public abstract ShopExecution modifyShop(Shop paramShop, MultipartFile paramMultipartFile)
    throws RuntimeException;
}
