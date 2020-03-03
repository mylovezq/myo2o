package com.imooc.myo2o.service;

import com.imooc.myo2o.dto.ProductCategoryExecution;
import com.imooc.myo2o.entity.ProductCategory;
import com.imooc.myo2o.exceptions.ProductCategoryOperationException;
import java.util.List;

public abstract interface ProductCategoryService
{
  public abstract List<ProductCategory> getByShopId(long paramLong);
  
  public abstract ProductCategoryExecution batchAddProductCategory(List<ProductCategory> paramList)
    throws RuntimeException;
  
  public abstract ProductCategoryExecution deleteProductCategory(long paramLong1, long paramLong2)
    throws ProductCategoryOperationException;
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\service\ProductCategoryService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */