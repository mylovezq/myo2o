package com.imooc.myo2o.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.myo2o.dao.ShopCategoryDao;
import com.imooc.myo2o.dto.Result;
import com.imooc.myo2o.dto.ShopCategoryExecution;
import com.imooc.myo2o.entity.ShopCategory;
import com.imooc.myo2o.enums.ShopCategoryStateEnum;
import com.imooc.myo2o.exceptions.ShopCategoryOperationException;
import com.imooc.myo2o.service.ShopCategoryService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.imooc.myo2o.util.UploadController;
import com.imooc.myo2o.util.ZipImg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;


@Service
public class ShopCategoryServiceImpl
        implements ShopCategoryService {
    @Autowired
    private ShopCategoryDao shopCategoryDao;

    public List<ShopCategory> getFirstLevelShopCategoryList()
            throws IOException {
        List<ShopCategory> shopCategoryList = null;
        ObjectMapper mapper = new ObjectMapper();

        ShopCategory shopCategoryCondition = new ShopCategory();
        shopCategoryCondition.setParentId(null);
        shopCategoryList = this.shopCategoryDao.queryShopCategory(shopCategoryCondition);

        return shopCategoryList;
    }
    public List<ShopCategory> getAllSecondLevelShopCategory() throws IOException {

        List<ShopCategory> shopCategoryList = null;
        ObjectMapper mapper = new ObjectMapper();

            ShopCategory shopCategoryCondition = new ShopCategory();
            // 当shopCategoryDesc不为空的时候，查询的条件会变为 where parent_id is not null
            shopCategoryCondition.setShopCategoryDesc("ALLSECOND");
            shopCategoryList = shopCategoryDao
                    .queryShopCategory(shopCategoryCondition);
            String jsonString = mapper.writeValueAsString(shopCategoryList);
        return shopCategoryList;
    }

    public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) throws IOException {

        return this.shopCategoryDao.queryShopCategory(shopCategoryCondition);
    }



    public ShopCategory getShopCategoryById(Long shopCategoryId) {
        List<ShopCategory> shopCategoryList = new ArrayList<ShopCategory>();
        try {
            shopCategoryList = getFirstLevelShopCategoryList();
            shopCategoryList.addAll(getAllSecondLevelShopCategory());
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (ShopCategory sc : shopCategoryList) {
            if (shopCategoryId == sc.getShopCategoryId()) {
                return sc;
            }
        }
        ShopCategory sc = shopCategoryDao.queryShopCategoryById(shopCategoryId);
        if (sc != null) {
            return sc;
        } else {
            return null;
        }
    }

    public ShopCategoryExecution addShopCategory(ShopCategory shopCategory, MultipartFile shopCategoryThumbnail) {
        if (shopCategory != null) {
            shopCategory.setCreateTime(new Date());
            shopCategory.setLastEditTime(new Date());
            if (shopCategoryThumbnail != null) {
                upImage(shopCategory, shopCategoryThumbnail);
            }
            try {
                int effectedNum = shopCategoryDao.insertShopCategory(shopCategory);
                if (effectedNum > 0) {
                    return new ShopCategoryExecution(ShopCategoryStateEnum.SUCCESS, shopCategory);
                } else {
                    return new ShopCategoryExecution(ShopCategoryStateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("添加商铺类别失败:" + e.toString());
            }
        } else {
            return new ShopCategoryExecution(ShopCategoryStateEnum.EMPTY);
        }
    }

    public ShopCategoryExecution modifyShopCategory(ShopCategory shopCategory, MultipartFile thumbnail) {
        if (shopCategory.getShopCategoryId() != null && shopCategory.getShopCategoryId() > 0) {
            shopCategory.setLastEditTime(new Date());
            if (thumbnail != null) {
                upImage(shopCategory, thumbnail);
            }
            try {
                int effectedNum = shopCategoryDao.updateShopCategory(shopCategory);
                if (effectedNum > 0) {
                    return new ShopCategoryExecution(ShopCategoryStateEnum.SUCCESS, shopCategory);
                } else {
                    return new ShopCategoryExecution(ShopCategoryStateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("更新商铺类别信息失败:" + e.toString());
            }
        } else {
            return new ShopCategoryExecution(ShopCategoryStateEnum.EMPTY);
        }
    }

    public ShopCategoryExecution removeShopCategory(long shopCategoryId) {
        if (shopCategoryId > 0) {
            try {
                ShopCategory tempShopCategory = shopCategoryDao
                        .queryShopCategoryById(shopCategoryId);
                int effectedNum = shopCategoryDao .deleteShopCategory(shopCategoryId);
                if (effectedNum > 0) {
                    return new ShopCategoryExecution(  ShopCategoryStateEnum.SUCCESS);
                } else {
                    return new ShopCategoryExecution(ShopCategoryStateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("删除店铺类别信息失败:" + e.toString());
            }
        } else {
            return new ShopCategoryExecution(ShopCategoryStateEnum.EMPTY);
        }
    }

    public ShopCategoryExecution removeShopCategoryList(List<Long> shopCategoryIdList) {
        if (shopCategoryIdList != null && shopCategoryIdList.size() > 0) {
            try {
                int effectedNum = shopCategoryDao.batchDeleteShopCategory(shopCategoryIdList);
                if (effectedNum > 0) {
                    return new ShopCategoryExecution(ShopCategoryStateEnum.SUCCESS);
                } else {
                    return new ShopCategoryExecution(
                            ShopCategoryStateEnum.INNER_ERROR);
                }
            } catch (Exception e) {
                throw new RuntimeException("删除店铺类别信息失败:" + e.toString());
            }
        } else {
            return new ShopCategoryExecution(ShopCategoryStateEnum.EMPTY);
        }
    }

    private ShopCategoryOperationException upImage(ShopCategory shopCategory, MultipartFile shopCategoryThumbnail) {
        if (shopCategoryThumbnail != null) {
            Result<String> upImgResult = new UploadController().upload(ZipImg.zipImgs(shopCategoryThumbnail));
            if (upImgResult.isSuccess()) {
                shopCategory.setShopCategoryImg(upImgResult.getData());
            } else {
                throw new RuntimeException("addImgAdd(缩略图) error: " + upImgResult.getErrorMsg());
            }
        } else {
            throw new RuntimeException("addImgAdd(缩略图) error: " + "缩略图为空");
        }
        return new ShopCategoryOperationException(ShopCategoryStateEnum.INNER_ERROR.getStateInfo());
    }
}

