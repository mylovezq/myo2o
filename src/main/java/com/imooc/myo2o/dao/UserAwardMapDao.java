package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.UserAwardMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface UserAwardMapDao
{
  public abstract List<UserAwardMap> queryUserAwardMapList(@Param("userAwardCondition") UserAwardMap paramUserAwardMap, @Param("rowIndex") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int queryUserAwardMapCount(@Param("userAwardCondition") UserAwardMap paramUserAwardMap);
  
  public abstract UserAwardMap queryUserAwardMapById(long paramLong);
  
  public abstract int insertUserAwardMap(UserAwardMap paramUserAwardMap);
  
  public abstract int updateUserAwardMap(UserAwardMap paramUserAwardMap);
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dao\UserAwardMapDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */