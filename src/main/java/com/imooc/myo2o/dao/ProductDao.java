package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.Product;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public abstract interface ProductDao
{
  public abstract List<Product> queryProductList(@Param("productCondition") Product paramProduct, @Param("rowIndex") int paramInt1, @Param("pageSize") int paramInt2);
  
  public abstract int queryProductCount(@Param("productCondition") Product paramProduct);
  
  public abstract Product queryProductByProductId(long paramLong);
  
  public abstract int insertProduct(Product paramProduct);
  
  public abstract int updateProduct(Product paramProduct);
  
  public abstract int updateProductCategoryToNull(long paramLong);
  
  public abstract int deleteProduct(@Param("productId") long paramLong1, @Param("shopId") long paramLong2);
  
  public abstract int deleteProductImgByProductId(long paramLong);
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\dao\ProductDao.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */