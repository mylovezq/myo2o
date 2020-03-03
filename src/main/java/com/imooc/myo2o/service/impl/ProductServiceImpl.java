/*     */ package com.imooc.myo2o.service.impl;
/*     */ 
/*     */ import com.imooc.myo2o.dao.ProductDao;
/*     */ import com.imooc.myo2o.dao.ProductImgDao;
/*     */ import com.imooc.myo2o.dto.ProductExecution;
/*     */ import com.imooc.myo2o.dto.Result;
/*     */ import com.imooc.myo2o.entity.Product;
/*     */ import com.imooc.myo2o.entity.ProductImg;
/*     */ import com.imooc.myo2o.entity.Shop;
/*     */ import com.imooc.myo2o.enums.ProductStateEnum;
/*     */ import com.imooc.myo2o.exceptions.ProductOperationException;
/*     */ import com.imooc.myo2o.service.ProductService;
/*     */ import com.imooc.myo2o.util.PageCalculator;
/*     */ import com.imooc.myo2o.util.UploadController;
/*     */ import com.imooc.myo2o.util.ZipImg;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Date;
/*     */ import java.util.List;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Service;
/*     */ import org.springframework.transaction.annotation.Transactional;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Service
/*     */ @Transactional
/*     */ public class ProductServiceImpl
/*     */   implements ProductService
/*     */ {
/*     */   @Autowired
/*     */   private ProductDao productDao;
/*     */   @Autowired
/*     */   private ProductImgDao productImgDao;
/*     */   
/*     */   public ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize)
/*     */   {
/*  40 */     int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
/*  41 */     List<Product> productsList = this.productDao.queryProductList(productCondition, rowIndex, pageSize);
/*     */     
/*  43 */     int count = this.productDao.queryProductCount(productCondition);
/*  44 */     ProductExecution pe = new ProductExecution();
/*  45 */     pe.setProductList(productsList);
/*  46 */     pe.setCount(count);
/*  47 */     return pe;
/*     */   }
/*     */   
/*     */   public Product getProductById(long productId)
/*     */   {
/*  52 */     return this.productDao.queryProductByProductId(productId);
/*     */   }
/*     */   
/*     */   public ProductExecution addProduct(Product product, MultipartFile thumbnail, List<MultipartFile> productImgs) throws ProductOperationException
/*     */   {
/*  57 */     if ((product != null) && (product.getShop() != null) && (product.getShop().getShopId() != null))
/*     */     {
/*  59 */       product.setCreateTime(new Date());
/*  60 */       product.setLastEditTime(new Date());
/*  61 */       product.setEnableStatus(Integer.valueOf(1));
/*     */       
/*  63 */       if (thumbnail != null)
/*     */       {
/*  65 */         upImage(product, thumbnail);
/*     */       }
/*     */       try {
/*  68 */         if (this.productDao.insertProduct(product) <= 0) {
/*  69 */           throw new ProductOperationException("插入数据库失败创建商品失败");
/*     */         }
/*     */       } catch (Exception e) {
/*  72 */         throw new ProductOperationException("创建商品失败" + e.toString());
/*     */       }
/*  74 */       if ((productImgs != null) && (productImgs.size() > 0)) {
/*  75 */         upImage(product, productImgs);
/*     */       }
/*  77 */       return new ProductExecution(ProductStateEnum.SUCCESS, product);
/*     */     }
/*     */     
/*  80 */     return new ProductExecution(ProductStateEnum.EMPTY);
/*     */   }
/*     */   
/*     */ 
/*     */   public ProductExecution modifyProduct(Product product, MultipartFile thumbnail, List<MultipartFile> productImgs)
/*     */     throws RuntimeException
/*     */   {
/*  87 */     if ((product != null) && (product.getProductId() != null) && (product.getProductId().longValue() > -1L)) {
/*     */       try {
/*  89 */         this.productImgDao.deleteProductImgByProductId(product.getProductId().longValue());
/*     */       } catch (ProductOperationException e) {
/*  91 */         throw new ProductOperationException(e.getMessage());
/*     */       }
/*     */     } else {
/*  94 */       return new ProductExecution(ProductStateEnum.EMPTY);
/*     */     }
/*     */     
/*  97 */     if ((product != null) && (product.getShop() != null) && (product.getShop().getShopId() != null))
/*     */     {
/*  99 */       product.setLastEditTime(new Date());
/*     */       
/* 101 */       if (thumbnail != null)
/*     */       {
/* 103 */         upImage(product, thumbnail);
/*     */       }
/*     */       try {
/* 106 */         if (this.productDao.updateProduct(product) <= 0) {
/* 107 */           throw new ProductOperationException("插入数据库失败更新商品失败");
/*     */         }
/*     */       } catch (Exception e) {
/* 110 */         throw new ProductOperationException("更新商品失败" + e.toString());
/*     */       }
/* 112 */       if ((productImgs != null) && (productImgs.size() > 0)) {
/* 113 */         upImage(product, productImgs);
/*     */       }
/* 115 */       return new ProductExecution(ProductStateEnum.SUCCESS, product);
/*     */     }
/*     */     
/* 118 */     return new ProductExecution(ProductStateEnum.EMPTY);
/*     */   }
/*     */   
/*     */   private ProductOperationException upImage(Product product, MultipartFile thumbnail)
/*     */   {
/* 123 */     if (thumbnail != null) {
/* 124 */       Result<String> upImgResult = new UploadController().upload(ZipImg.zipImg(thumbnail));
/* 125 */       if (upImgResult.isSuccess()) {
/* 126 */         product.setImgAddr((String)upImgResult.getData());
/*     */       } else {
/* 128 */         throw new RuntimeException("addImgAdd(缩略图) error: " + upImgResult.getErrorMsg());
/*     */       }
/*     */     } else {
/* 131 */       throw new ProductOperationException("创建商品失败,图片信息为空");
/*     */     }
/* 133 */     return new ProductOperationException(ProductStateEnum.SUCCESS.getStateInfo());
/*     */   }
/*     */   
/*     */   private ProductOperationException upImage(Product product, List<MultipartFile> productImgs) {
/* 137 */     if ((productImgs != null) && (productImgs.size() > 0)) {
/* 138 */       List<ProductImg> productImgList = new ArrayList();
/* 139 */       for (MultipartFile file : productImgs) {
/* 140 */         Result<String> upImgResult = new UploadController().upload(ZipImg.zipImgs(file));
/* 141 */         if (upImgResult.isSuccess()) {
/* 142 */           ProductImg productImg = new ProductImg();
/* 143 */           productImg.setCreateTime(new Date());
/* 144 */           productImg.setProductId(product.getProductId());
/* 145 */           productImg.setImgAddr((String)upImgResult.getData());
/* 146 */           productImgList.add(productImg);
/*     */         } else {
/* 148 */           throw new RuntimeException("addImgAdd(缩略图) error: " + upImgResult.getErrorMsg());
/*     */         }
/*     */       }
/* 151 */       product.setProductImgList(productImgList);
/* 152 */       if ((productImgList.size() > 0) && 
/* 153 */         (this.productImgDao.batchInsertProductImg(productImgList) <= 0)) {
/* 154 */         throw new ProductOperationException("数据库插入商品详情图片失败");
/*     */       }
/*     */     }
/*     */     else
/*     */     {
/* 159 */       throw new ProductOperationException("创建商品失败,图片信息为空");
/*     */     }
/* 161 */     return new ProductOperationException(ProductStateEnum.SUCCESS.getStateInfo());
/*     */   }
/*     */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\service\impl\ProductServiceImpl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */