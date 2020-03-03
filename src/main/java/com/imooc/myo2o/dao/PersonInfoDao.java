package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.PersonInfo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface PersonInfoDao
{
  public abstract List<PersonInfo> queryPersonInfoList(@Param("personInfoCondition") PersonInfo paramPersonInfo, @Param("rowIndex") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int queryPersonInfoCount(@Param("personInfoCondition") PersonInfo paramPersonInfo);
  
  public abstract PersonInfo queryPersonInfoById(long paramLong);
  
  public abstract int insertPersonInfo(PersonInfo paramPersonInfo);
  
  public abstract int updatePersonInfo(PersonInfo paramPersonInfo);
  
  public abstract int deletePersonInfo(long paramLong);
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dao\PersonInfoDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */