package com.imooc.myo2o.dto;

import com.imooc.myo2o.entity.ShopCategory;
import com.imooc.myo2o.enums.ShopCategoryStateEnum;

import java.util.List;


public class ShopCategoryExecution {
    private int state;
    private String stateInfo;
    private ShopCategory shopCategory;
    private List<ShopCategory> shopCategoryList;

    public ShopCategoryExecution() {
    }

    public ShopCategoryExecution(ShopCategoryStateEnum stateEnum) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
    }

    public ShopCategoryExecution(ShopCategoryStateEnum stateEnum, ShopCategory shopCategory) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopCategory = shopCategory;
    }

    public ShopCategoryExecution(ShopCategoryStateEnum stateEnum, List<ShopCategory> shopCategoryList) {
        this.state = stateEnum.getState();
        this.stateInfo = stateEnum.getStateInfo();
        this.shopCategoryList = shopCategoryList;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return this.stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public ShopCategory getShopCategory() {
        return this.shopCategory;
    }

    public void setShopCategory(ShopCategory shopCategory) {
        this.shopCategory = shopCategory;
    }

    public List<ShopCategory> getShopCategoryList() {
        return this.shopCategoryList;
    }

    public void setShopCategoryList(List<ShopCategory> shopCategoryList) {
        this.shopCategoryList = shopCategoryList;
    }
}


