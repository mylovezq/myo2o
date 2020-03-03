package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.ShopAuthMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface ShopAuthMapDao
{
  public abstract List<ShopAuthMap> queryShopAuthMapListByShopId(@Param("shopId") long paramLong, @Param("rowIndex") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int queryShopAuthCountByShopId(@Param("shopId") long paramLong);
  
  public abstract int insertShopAuthMap(ShopAuthMap paramShopAuthMap);
  
  public abstract int updateShopAuthMap(ShopAuthMap paramShopAuthMap);
  
  public abstract int deleteShopAuthMap(@Param("employeeId") long paramLong1, @Param("shopId") long paramLong2);
  
  public abstract ShopAuthMap queryShopAuthMapById(Long paramLong);
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dao\ShopAuthMapDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */