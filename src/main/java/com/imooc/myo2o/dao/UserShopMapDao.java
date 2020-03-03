package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.UserShopMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface UserShopMapDao
{
  public abstract List<UserShopMap> queryUserShopMapList(@Param("userShopCondition") UserShopMap paramUserShopMap, @Param("rowIndex") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract UserShopMap queryUserShopMap(@Param("userId") long paramLong1, @Param("shopId") long paramLong2);
  
  public abstract int queryUserShopMapCount(@Param("userShopCondition") UserShopMap paramUserShopMap);
  
  public abstract int insertUserShopMap(UserShopMap paramUserShopMap);
  
  public abstract int updateUserShopMapPoint(UserShopMap paramUserShopMap);
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dao\UserShopMapDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */