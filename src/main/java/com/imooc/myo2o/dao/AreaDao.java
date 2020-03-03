package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.Area;
import java.util.List;

public abstract interface AreaDao
{
  public abstract List<Area> queryArea();
  
  public abstract int insertArea(Area paramArea);
  
  public abstract int updateArea(Area paramArea);
  
  public abstract int deleteArea(long paramLong);
  
  public abstract int batchDeleteArea(List<Long> paramList);
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dao\AreaDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */