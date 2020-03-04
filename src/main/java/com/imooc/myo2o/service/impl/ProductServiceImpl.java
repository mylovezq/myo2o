package com.imooc.myo2o.service.impl;

import com.imooc.myo2o.dao.ProductDao;
import com.imooc.myo2o.dao.ProductImgDao;
import com.imooc.myo2o.dto.ProductExecution;
import com.imooc.myo2o.dto.Result;
import com.imooc.myo2o.entity.Product;
import com.imooc.myo2o.entity.ProductImg;
import com.imooc.myo2o.entity.Shop;
import com.imooc.myo2o.enums.ProductStateEnum;
import com.imooc.myo2o.exceptions.ProductOperationException;
import com.imooc.myo2o.service.ProductService;
import com.imooc.myo2o.util.PageCalculator;
import com.imooc.myo2o.util.UploadController;
import com.imooc.myo2o.util.ZipImg;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
@Transactional
public class ProductServiceImpl
        implements ProductService {
    @Autowired
    private ProductDao productDao;
    @Autowired
    private ProductImgDao productImgDao;

    public ProductExecution getProductList(Product productCondition, int pageIndex, int pageSize) {
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
        List<Product> productsList = this.productDao.queryProductList(productCondition, rowIndex, pageSize);

        int count = this.productDao.queryProductCount(productCondition);
        ProductExecution pe = new ProductExecution();
        pe.setProductList(productsList);
        pe.setCount(count);
        return pe;
    }

    public Product getProductById(long productId) {
        return this.productDao.queryProductByProductId(productId);
    }

    public ProductExecution addProduct(Product product, MultipartFile thumbnail, List<MultipartFile> productImgs) throws ProductOperationException {
        if ((product != null) && (product.getShop() != null) && (product.getShop().getShopId() != null)) {
            product.setCreateTime(new Date());
            product.setLastEditTime(new Date());
            product.setEnableStatus(Integer.valueOf(1));

            if (thumbnail != null) {
                upImage(product, thumbnail);
            }
            try {
                if (this.productDao.insertProduct(product) <= 0) {
                    throw new ProductOperationException("插入数据库失败创建商品失败");
                }
            } catch (Exception e) {
                throw new ProductOperationException("创建商品失败" + e.toString());
            }
            if ((productImgs != null) && (productImgs.size() > 0)) {
                upImage(product, productImgs);
            }
            return new ProductExecution(ProductStateEnum.SUCCESS, product);
        }

        return new ProductExecution(ProductStateEnum.EMPTY);
    }


    public ProductExecution modifyProduct(Product product, MultipartFile thumbnail, List<MultipartFile> productImgs)
            throws RuntimeException {
        if ((product != null) && (product.getProductId() != null) && (product.getProductId().longValue() > -1L)) {
            try {
                this.productImgDao.deleteProductImgByProductId(product.getProductId().longValue());
            } catch (ProductOperationException e) {
                throw new ProductOperationException(e.getMessage());
            }
        } else {
            return new ProductExecution(ProductStateEnum.EMPTY);
        }

        if ((product != null) && (product.getShop() != null) && (product.getShop().getShopId() != null)) {
            product.setLastEditTime(new Date());

            if (thumbnail != null) {
                upImage(product, thumbnail);
            }
            try {
                if (this.productDao.updateProduct(product) <= 0) {
                    throw new ProductOperationException("插入数据库失败更新商品失败");
                }
            } catch (Exception e) {
                throw new ProductOperationException("更新商品失败" + e.toString());
            }
            if ((productImgs != null) && (productImgs.size() > 0)) {
                upImage(product, productImgs);
            }
            return new ProductExecution(ProductStateEnum.SUCCESS, product);
        }

        return new ProductExecution(ProductStateEnum.EMPTY);
    }

    private ProductOperationException upImage(Product product, MultipartFile thumbnail) {
        if (thumbnail != null) {
            Result<String> upImgResult = new UploadController().upload(ZipImg.zipImg(thumbnail));
            if (upImgResult.isSuccess()) {
                product.setImgAddr((String) upImgResult.getData());
            } else {
                throw new RuntimeException("addImgAdd(缩略图) error: " + upImgResult.getErrorMsg());
            }
        } else {
            throw new ProductOperationException("创建商品失败,图片信息为空");
        }
        return new ProductOperationException(ProductStateEnum.SUCCESS.getStateInfo());
    }

    private ProductOperationException upImage(Product product, List<MultipartFile> productImgs) {
        if ((productImgs != null) && (productImgs.size() > 0)) {
            List<ProductImg> productImgList = new ArrayList();
            for (MultipartFile file : productImgs) {
                Result<String> upImgResult = new UploadController().upload(ZipImg.zipImgs(file));
                if (upImgResult.isSuccess()) {
                    ProductImg productImg = new ProductImg();
                    productImg.setCreateTime(new Date());
                    productImg.setProductId(product.getProductId());
                    productImg.setImgAddr((String) upImgResult.getData());
                    productImgList.add(productImg);
                } else {
                    throw new RuntimeException("addImgAdd(缩略图) error: " + upImgResult.getErrorMsg());
                }
            }
            product.setProductImgList(productImgList);
            if ((productImgList.size() > 0) &&
                    (this.productImgDao.batchInsertProductImg(productImgList) <= 0)) {
                throw new ProductOperationException("数据库插入商品详情图片失败");
            }
        } else {
            throw new ProductOperationException("创建商品失败,图片信息为空");
        }
        return new ProductOperationException(ProductStateEnum.SUCCESS.getStateInfo());
    }
}

