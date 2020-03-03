package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.ProductImg;
import java.util.List;

public abstract interface ProductImgDao
{
  public abstract List<ProductImg> queryProductImgList(long paramLong);
  
  public abstract int batchInsertProductImg(List<ProductImg> paramList);
  
  public abstract int deleteProductImgByProductId(long paramLong);
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dao\ProductImgDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */