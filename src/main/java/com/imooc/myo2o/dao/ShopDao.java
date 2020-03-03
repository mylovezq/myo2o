package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.Shop;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface ShopDao
{
  public abstract List<Shop> queryShopList(@Param("shopCondition") Shop paramShop, @Param("rowIndex") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int queryShopCount(@Param("shopCondition") Shop paramShop);
  
  public abstract List<Shop> queryByEmployeeId(long paramLong);
  
  public abstract Shop queryByShopId(long paramLong);
  
  public abstract int insertShop(Shop paramShop);
  
  public abstract int updateShop(Shop paramShop);
  
  public abstract int deleteShopByName(String paramString);
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dao\ShopDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */