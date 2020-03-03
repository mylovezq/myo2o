package com.imooc.myo2o.service;

import com.imooc.myo2o.dto.HeadLineExecution;
import com.imooc.myo2o.entity.HeadLine;
import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public abstract interface HeadLineService
{
  public abstract List<HeadLine> getHeadLineList(HeadLine paramHeadLine)
    throws IOException;
  
  public abstract HeadLineExecution addHeadLine(HeadLine paramHeadLine, MultipartFile paramCommonsMultipartFile);
  
  public abstract HeadLineExecution modifyHeadLine(HeadLine paramHeadLine, MultipartFile paramCommonsMultipartFile);
  
  public abstract HeadLineExecution removeHeadLine(long paramLong);
  
  public abstract HeadLineExecution removeHeadLineList(List<Long> paramList);
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\service\HeadLineService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */