package com.imooc.myo2o.service;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.imooc.myo2o.dto.AreaExecution;
import com.imooc.myo2o.entity.Area;
import java.io.IOException;
import java.util.List;

public abstract interface AreaService
{
  public abstract List<Area> getAreaList()
    throws JsonParseException, JsonMappingException, IOException;
  
  public abstract AreaExecution addArea(Area paramArea);
  
  public abstract AreaExecution modifyArea(Area paramArea);
  
  public abstract AreaExecution removeArea(long paramLong);
  
  public abstract AreaExecution removeAreaList(List<Long> paramList);
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\service\AreaService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */