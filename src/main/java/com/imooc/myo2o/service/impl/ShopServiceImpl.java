package com.imooc.myo2o.service.impl;

import com.imooc.myo2o.dao.ShopDao;
import com.imooc.myo2o.dto.Result;
import com.imooc.myo2o.dto.ShopExecution;
import com.imooc.myo2o.entity.Shop;
import com.imooc.myo2o.enums.ShopStateEnum;
import com.imooc.myo2o.service.ShopService;
import com.imooc.myo2o.util.PageCalculator;
import com.imooc.myo2o.util.UploadController;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ShopServiceImpl
        implements ShopService {
    @Autowired
    private ShopDao shopDao;

    public ShopExecution getShopList(Shop shopCondition, int pageIndex, int pageSize) {
        int rowIndex = PageCalculator.calculateRowIndex(pageIndex, pageSize);
        List<Shop> shopList = this.shopDao.queryShopList(shopCondition, rowIndex, pageSize);
        int count = this.shopDao.queryShopCount(shopCondition);
        ShopExecution shopExecution = new ShopExecution();
        if (shopList != null) {
            shopExecution.setShopList(shopList);
            shopExecution.setCount(count);
        } else {
            shopExecution.setState(ShopStateEnum.INNER_ERROR.getState());
        }
        return shopExecution;
    }

    public ShopExecution getByEmployeeId(long employeeId)
            throws RuntimeException {
        return null;
    }

    public Shop getByShopId(long shopId) {
        return this.shopDao.queryByShopId(shopId);
    }

    public ShopExecution modifyShop(Shop shop, MultipartFile shopImg) throws RuntimeException {
        if ((shop == null) || (shop.getShopId() == null)) {
            return new ShopExecution(ShopStateEnum.NULL_SHOPID);
        }
        try {
            if (shopImg != null) {
                upImage(shop, shopImg);
            }

            shop.setLastEditTime(new Date());
            int effectedNum = this.shopDao.updateShop(shop);
            if (effectedNum <= 0) {
                return new ShopExecution(ShopStateEnum.INNER_ERROR);
            }
            shop = this.shopDao.queryByShopId(shop.getShopId().longValue());
            return new ShopExecution(ShopStateEnum.SUCCESS, shop);
        } catch (Exception e) {
            throw new RuntimeException("修改错误" + e.getMessage());
        }
    }


    @Transactional
    public ShopExecution addShop(Shop shop, MultipartFile shopImg)
            throws RuntimeException {
        if (shop == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOPID);
        }
        if (shop.getOwnerId() == null) {
            return new ShopExecution(ShopStateEnum.NULL_SHOP_INFO);
        }
        try {
            shop.setEnableStatus(Integer.valueOf(0));
            shop.setCreateTime(new Date());
            shop.setLastEditTime(new Date());

            int effectedNum = this.shopDao.insertShop(shop);
            if (effectedNum <= 0) {
                throw new RuntimeException("店铺创建失败");
            }
            upImage(shop, shopImg);
            int effectedUpNum = this.shopDao.updateShop(shop);
            if (effectedUpNum <= 0) {
                throw new RuntimeException("图片更新失败");
            }
        } catch (Exception e) {
            throw new RuntimeException("addShop error:" + e.getMessage());
        }
        return new ShopExecution(ShopStateEnum.CHECK, shop);
    }

    private void upImage(Shop shop, MultipartFile shopImg) {
        if (shopImg != null) {
            Result<String> shopImgResult = new UploadController().upload(shopImg);
            if (shopImgResult.isSuccess()) {
                shop.setShopImg((String) shopImgResult.getData());
            } else {
                throw new RuntimeException("addShopImg error: " + shopImgResult.getErrorMsg());
            }
        }
    }
}


