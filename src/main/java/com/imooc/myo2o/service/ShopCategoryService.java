package com.imooc.myo2o.service;

import com.imooc.myo2o.dto.ShopCategoryExecution;
import com.imooc.myo2o.entity.ShopCategory;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public abstract interface ShopCategoryService
{
  public abstract List<ShopCategory> getFirstLevelShopCategoryList()
    throws IOException;
  
  public abstract List<ShopCategory> getShopCategoryList(ShopCategory paramShopCategory)
    throws IOException;
  
  public abstract List<ShopCategory> getAllSecondLevelShopCategory()
    throws IOException;
  
  public abstract ShopCategory getShopCategoryById(Long paramLong);
  
  public abstract ShopCategoryExecution addShopCategory(ShopCategory paramShopCategory, MultipartFile paramCommonsMultipartFile);
  
  public abstract ShopCategoryExecution modifyShopCategory(ShopCategory paramShopCategory, MultipartFile paramCommonsMultipartFile);
  
  public abstract ShopCategoryExecution removeShopCategory(long paramLong);
  
  public abstract ShopCategoryExecution removeShopCategoryList(List<Long> paramList);
}


