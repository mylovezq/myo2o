package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.Award;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface AwardDao
{
  public abstract List<Award> queryAwardList(@Param("awardCondition") Award paramAward, @Param("rowIndex") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int queryAwardCount(@Param("awardCondition") Award paramAward);
  
  public abstract Award queryAwardByAwardId(long paramLong);
  
  public abstract int insertAward(Award paramAward);
  
  public abstract int updateAward(Award paramAward);
  
  public abstract int deleteAward(long paramLong);
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dao\AwardDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */