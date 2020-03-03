package com.imooc.myo2o.web.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.myo2o.dto.ShopExecution;
import com.imooc.myo2o.entity.Area;
import com.imooc.myo2o.entity.PersonInfo;
import com.imooc.myo2o.entity.Shop;
import com.imooc.myo2o.entity.ShopCategory;
import com.imooc.myo2o.enums.ShopStateEnum;
import com.imooc.myo2o.service.AreaService;
import com.imooc.myo2o.service.ShopCategoryService;
import com.imooc.myo2o.service.ShopService;
import com.imooc.myo2o.util.CodeUtil;
import com.imooc.myo2o.util.HttpServletRequestUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Controller
@org.springframework.web.bind.annotation.RequestMapping({"/shopadmin"})
@ResponseBody
public class ShopManagementController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private ShopCategoryService shopCategoryService;
    @Autowired
    private AreaService areaService;

    @GetMapping({"/getshopmanagementinfo"})
    private Map<String, Object> getManagementInfo(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap();
        long shopId = HttpServletRequestUtil.getLong(request, "shopId");
        if (shopId <= 0L) {
            Object currentShopObj = request.getSession().getAttribute("currentShop");
            if (currentShopObj == null) {
                modelMap.put("redirect", Boolean.valueOf(true));
                modelMap.put("url", "/myo2o/shopadmin/shoplist");
            } else {
                Shop currentShop = (Shop) currentShopObj;
                modelMap.put("redirect", Boolean.valueOf(false));
                modelMap.put("shopId", currentShop.getShopId());
            }
        } else {
            Shop currentShop = new Shop();
            currentShop.setShopId(Long.valueOf(shopId));
            request.getSession().setAttribute("currentShop", currentShop);
            modelMap.put("redirect", Boolean.valueOf(false));
        }
        return modelMap;
    }

    @GetMapping({"/getshoplist"})
    @ResponseBody
    private Map<String, Object> getShopList(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap();
        PersonInfo user = new PersonInfo();
        user.setUserId(Long.valueOf(8L));
        user.setName("测试名字");
        request.getSession().setAttribute("user", user);
        user = (PersonInfo) request.getSession().getAttribute("user");
        try {
            Shop shopCondition = new Shop();
            shopCondition.setOwnerId(user.getUserId());
            ShopExecution se = this.shopService.getShopList(shopCondition, 0, 100);
            modelMap.put("shopList", se.getShopList());
            modelMap.put("user", user);
            modelMap.put("success", Boolean.valueOf(true));
        } catch (Exception e) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    @PostMapping({"/modifyshop"})
    private Map<String, Object> modifyshop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap();
        if (!CodeUtil.checkVerifyCode(request)) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "输入了错误的验证码哦~");
            return modelMap;
        }


        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try {
            shop = (Shop) mapper.readValue(shopStr, Shop.class);
        } catch (Exception e) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        MultipartFile shopImg = null;
        MultipartHttpServletRequest multipartRequest = null;
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            multipartRequest = (MultipartHttpServletRequest) request;
            shopImg = multipartRequest.getFile("shopImg");
        }

        if ((shop != null) && (shop.getShopId() != null)) {
            try {
                ShopExecution se = this.shopService.modifyShop(shop, shopImg);
                if (se.getState() == ShopStateEnum.SUCCESS.getState()) {
                    modelMap.put("success", Boolean.valueOf(true));
                } else {
                    modelMap.put("success", Boolean.valueOf(false));
                    modelMap.put("errMsg", se.getStateInfo());
                }
            } catch (RuntimeException e) {
                modelMap.put("success", Boolean.valueOf(false));
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }
        } else {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "请输入店铺id");
        }
        return modelMap;
    }

    @GetMapping({"/getshopbyid"})
    @ResponseBody
    private Map<String, Object> getShopById(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap();
        Long shopId = Long.valueOf(HttpServletRequestUtil.getLong(request, "shopId"));
        if ((shopId.longValue() > -1L) && (shopId != null)) {
            try {
                Shop shop = this.shopService.getByShopId(shopId.longValue());
                List<Area> areaList = this.areaService.getAreaList();
                modelMap.put("shop", shop);
                modelMap.put("areaList", areaList);
                modelMap.put("success", Boolean.valueOf(true));
            } catch (Exception e) {
                modelMap.put("success", Boolean.valueOf(false));
                modelMap.put("errMsg", e.toString());
            }
        } else {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "错误商铺id");
        }
        return modelMap;
    }

    @GetMapping({"/getshopinitinfo"})
    @ResponseBody
    private Map<String, Object> getShopInitInfo() {
        Map<String, Object> modelMap = new HashMap();
        List<ShopCategory> shopCategoryList = new ArrayList();
        List<Area> areaList = new ArrayList();
        try {
            shopCategoryList = this.shopCategoryService.getShopCategoryList(new ShopCategory());
            areaList = this.areaService.getAreaList();
            modelMap.put("shopCategoryList", shopCategoryList);
            modelMap.put("areaList", areaList);
            modelMap.put("success", Boolean.valueOf(true));
        } catch (IOException e) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", e.getMessage());
        }

        return modelMap;
    }

    @PostMapping({"/registershop"})
    private Map<String, Object> registerShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap();
        if (!CodeUtil.checkVerifyCode(request)) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "输入了错误的验证码哦~");
            return modelMap;
        }


        String shopStr = HttpServletRequestUtil.getString(request, "shopStr");
        ObjectMapper mapper = new ObjectMapper();
        Shop shop = null;
        try {
            shop = (Shop) mapper.readValue(shopStr, Shop.class);
        } catch (Exception e) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        MultipartFile shopImg = null;
        MultipartHttpServletRequest multipartRequest = null;
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        if (multipartResolver.isMultipart(request)) {
            multipartRequest = (MultipartHttpServletRequest) request;
            shopImg = multipartRequest.getFile("shopImg");
        } else {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "未能收到图片上传流！");
            return modelMap;
        }

        if ((shop != null) && (shopImg != null)) {
            try {
//                PersonInfo user = (PersonInfo) request.getSession().getAttribute("user");
                shop.setOwnerId(9l);
                ShopExecution se = this.shopService.addShop(shop, shopImg);
                if (se.getState() == ShopStateEnum.CHECK.getState()) {
                    modelMap.put("success", Boolean.valueOf(true));

                    List<Shop> shopList = (List) request.getSession().getAttribute("shopList");
                    if ((shopList == null) || (shopList.size() == 0)) {
                        shopList = new ArrayList();
                    }
                    shopList.add(se.getShop());
                    request.getSession().setAttribute("shopList", shopList);
                } else {
                    modelMap.put("success", Boolean.valueOf(false));
                    modelMap.put("errMsg", se.getStateInfo());
                }
            } catch (RuntimeException e) {
                modelMap.put("success", Boolean.valueOf(false));
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }
        } else {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "请输入店铺信息");
        }
        return modelMap;
    }
}

