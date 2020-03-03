package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.UserProductMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface UserProductMapDao
{
  public abstract List<UserProductMap> queryUserProductMapList(@Param("userProductCondition") UserProductMap paramUserProductMap, @Param("rowIndex") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int queryUserProductMapCount(@Param("userProductCondition") UserProductMap paramUserProductMap);
  
  public abstract int insertUserProductMap(UserProductMap paramUserProductMap);
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dao\UserProductMapDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */