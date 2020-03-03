package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.ShopCategory;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface ShopCategoryDao
{
  public abstract List<ShopCategory> queryShopCategory(@Param("shopCategoryCondition") ShopCategory paramShopCategory);
  
  public abstract ShopCategory queryShopCategoryById(long paramLong);
  
  public abstract List<ShopCategory> queryShopCategoryByIds(List<Long> paramList);
  
  public abstract int insertShopCategory(ShopCategory paramShopCategory);
  
  public abstract int updateShopCategory(ShopCategory paramShopCategory);
  
  public abstract int deleteShopCategory(long paramLong);
  
  public abstract int batchDeleteShopCategory(List<Long> paramList);
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dao\ShopCategoryDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */