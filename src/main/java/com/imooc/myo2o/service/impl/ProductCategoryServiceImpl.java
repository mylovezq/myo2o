/*    */ package com.imooc.myo2o.service.impl;
/*    */ 
/*    */ import com.imooc.myo2o.dao.ProductCategoryDao;
/*    */ import com.imooc.myo2o.dao.ProductDao;
/*    */ import com.imooc.myo2o.dto.ProductCategoryExecution;
/*    */ import com.imooc.myo2o.entity.ProductCategory;
/*    */ import com.imooc.myo2o.enums.ProductCategoryStateEnum;
/*    */ import com.imooc.myo2o.exceptions.ProductCategoryOperationException;
/*    */ import com.imooc.myo2o.service.ProductCategoryService;
/*    */ import java.util.List;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Service;
/*    */ import org.springframework.transaction.annotation.Transactional;
/*    */ 
/*    */ 
/*    */ @Service
/*    */ public class ProductCategoryServiceImpl
/*    */   implements ProductCategoryService
/*    */ {
/*    */   @Autowired
/*    */   private ProductCategoryDao productCategoryDao;
/*    */   @Autowired
/*    */   private ProductDao productDao;
/*    */   
/*    */   public List<ProductCategory> getByShopId(long shopId)
/*    */   {
/* 27 */     return this.productCategoryDao.queryByShopId(shopId);
/*    */   }
/*    */   
/*    */   public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList) throws RuntimeException
/*    */   {
/* 32 */     if ((productCategoryList != null) && (productCategoryList.size() > 0)) {
/*    */       try
/*    */       {
/* 35 */         int effectedNum = this.productCategoryDao.batchInsertProductCategory(productCategoryList);
/*    */         
/* 37 */         if (effectedNum <= 0) {
/* 38 */           throw new ProductCategoryOperationException("店铺类别添加失败~");
/*    */         }
/* 40 */         return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
/*    */       }
/*    */       catch (Exception e) {
/* 43 */         throw new ProductCategoryOperationException("批量添加商品类别失败" + e.getMessage());
/*    */       }
/*    */     }
/*    */     
/*    */ 
/* 48 */     return new ProductCategoryExecution(ProductCategoryStateEnum.EMPTY_LIST);
/*    */   }
/*    */   
/*    */   @Transactional
/*    */   public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
/*    */     throws RuntimeException
/*    */   {
/*    */     try
/*    */     {
/* 57 */       int effectedNum = this.productDao.updateProductCategoryToNull(productCategoryId);
/* 58 */       if (effectedNum < 0) {
/* 59 */         throw new ProductCategoryOperationException("数据库：商品列表更新失败");
/*    */       }
/*    */     } catch (Exception e) {
/* 62 */       throw new ProductCategoryOperationException("删除商品类别失败，数据库，" + e.getMessage());
/*    */     }
/*    */     try {
/* 65 */       int effectedNum = this.productCategoryDao.deleteProductCategory(productCategoryId, shopId);
/* 66 */       if (effectedNum <= 0) {
/* 67 */         throw new ProductCategoryOperationException("类别删除失败！");
/*    */       }
/* 69 */       return new ProductCategoryExecution(ProductCategoryStateEnum.SUCCESS);
/*    */     }
/*    */     catch (Exception e) {
/* 72 */       throw new ProductCategoryOperationException("deleteProductCategory error:" + e.getMessage());
/*    */     }
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\service\impl\ProductCategoryServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */