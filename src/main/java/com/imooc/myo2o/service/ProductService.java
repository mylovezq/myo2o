package com.imooc.myo2o.service;

import com.imooc.myo2o.dto.ProductExecution;
import com.imooc.myo2o.entity.Product;
import com.imooc.myo2o.exceptions.ProductOperationException;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public abstract interface ProductService
{
  public abstract ProductExecution getProductList(Product paramProduct, int paramInt1, int paramInt2);
  
  public abstract Product getProductById(long paramLong);
  
  public abstract ProductExecution addProduct(Product paramProduct, MultipartFile paramMultipartFile, List<MultipartFile> paramList)
    throws ProductOperationException;
  
  public abstract ProductExecution modifyProduct(Product paramProduct, MultipartFile paramMultipartFile, List<MultipartFile> paramList)
    throws RuntimeException;
}


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\service\ProductService.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */