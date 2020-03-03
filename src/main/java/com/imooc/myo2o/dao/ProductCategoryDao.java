package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.ProductCategory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface ProductCategoryDao
{
  public abstract List<ProductCategory> queryByShopId(long paramLong);
  
  public abstract int batchInsertProductCategory(List<ProductCategory> paramList);
  
  public abstract int deleteProductCategory(@Param("productCategoryId") long paramLong1, @Param("shopId") long paramLong2);
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dao\ProductCategoryDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */