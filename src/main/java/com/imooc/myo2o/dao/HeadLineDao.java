package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.HeadLine;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface HeadLineDao
{
  public abstract List<HeadLine> queryHeadLine(@Param("headLineCondition") HeadLine paramHeadLine);
  
  public abstract HeadLine queryHeadLineById(long paramLong);
  
  public abstract List<HeadLine> queryHeadLineByIds(List<Long> paramList);
  
  public abstract int insertHeadLine(HeadLine paramHeadLine);
  
  public abstract int updateHeadLine(HeadLine paramHeadLine);
  
  public abstract int deleteHeadLine(long paramLong);
  
  public abstract int batchDeleteHeadLine(List<Long> paramList);
}

