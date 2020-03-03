package com.imooc.myo2o.web.shopadmin;

import com.imooc.myo2o.entity.HeadLine;
import com.imooc.myo2o.entity.ShopCategory;
import com.imooc.myo2o.service.HeadLineService;
import com.imooc.myo2o.service.ShopCategoryService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping({"/frontend"})
public class MainPageController {
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private HeadLineService headLineService;

    @RequestMapping(value = {"/listmainpageinfo"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    @ResponseBody
    private Map<String, Object> list1stShopCategory() {
        Map<String, Object> modelMap = new HashMap();
        List<ShopCategory> shopCategoryList = new ArrayList();
        try {
            ShopCategory shopCategoryCondition = new ShopCategory();
            shopCategoryCondition.setParentId(null);
            shopCategoryList = this.shopCategoryService.getShopCategoryList(shopCategoryCondition);
            modelMap.put("shopCategoryList", shopCategoryList);
        } catch (Exception e) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        List<HeadLine> headLineList = new ArrayList();
        try {
            HeadLine headLineCondition = new HeadLine();
            headLineCondition.setEnableStatus(Integer.valueOf(1));
            headLineList = this.headLineService.getHeadLineList(headLineCondition);
            modelMap.put("headLineList", headLineList);
        } catch (Exception e) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        modelMap.put("success", Boolean.valueOf(true));
        return modelMap;
    }
}

