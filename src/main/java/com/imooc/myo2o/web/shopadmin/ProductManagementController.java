package com.imooc.myo2o.web.shopadmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.imooc.myo2o.dto.ProductExecution;
import com.imooc.myo2o.entity.Product;
import com.imooc.myo2o.entity.ProductCategory;
import com.imooc.myo2o.entity.Shop;
import com.imooc.myo2o.enums.ProductStateEnum;
import com.imooc.myo2o.exceptions.ProductOperationException;
import com.imooc.myo2o.service.ProductCategoryService;
import com.imooc.myo2o.service.ProductService;
import com.imooc.myo2o.util.CodeUtil;
import com.imooc.myo2o.util.HttpServletRequestUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@Controller
@RequestMapping({"/shopadmin"})
public class ProductManagementController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductCategoryService productCategoryService;
    private static final int IMAGEMAXCOUNT = 8;

    @RequestMapping(value = {"/getproductlistbyshop"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    @ResponseBody
    private Map<String, Object> getProductListByShop(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap();
        int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
        int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");

        if ((pageIndex > -1) && (pageSize > -1) && (currentShop != null) && (currentShop.getShopId() != null)) {
            long productCategoryId = HttpServletRequestUtil.getLong(request, "productCategoryId");
            String productName = HttpServletRequestUtil.getString(request, "productName");
            Product productCondition = compactProductCondition4Search(currentShop.getShopId().longValue(), productCategoryId, productName);
            ProductExecution pe = this.productService.getProductList(productCondition, pageIndex, pageSize);
            modelMap.put("productList", pe.getProductList());
            modelMap.put("count", Integer.valueOf(pe.getCount()));
            modelMap.put("success", Boolean.valueOf(true));
        } else {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
        }

        return modelMap;
    }

    @RequestMapping(value = {"/getproductbyid"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    @ResponseBody
    private Map<String, Object> getProductById(@RequestParam Long productId) {
        Map<String, Object> modelMap = new HashMap();
        if (productId.longValue() > -1L) {
            Product product = this.productService.getProductById(productId.longValue());
            List<ProductCategory> productCategoryList = this.productCategoryService.getByShopId(product.getShop().getShopId().longValue());
            modelMap.put("product", product);
            modelMap.put("productCategoryList", productCategoryList);
            modelMap.put("success", Boolean.valueOf(true));
        } else {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
        }
        return modelMap;
    }

    @RequestMapping(value = {"/getproductcategorylistbyshopId"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    @ResponseBody
    private Map<String, Object> getProductCategoryListByShopId(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap();
        Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");

        if ((currentShop != null) && (currentShop.getShopId() != null)) {
            List<ProductCategory> productCategoryList = this.productCategoryService.getByShopId(currentShop.getShopId().longValue());
            modelMap.put("productCategoryList", productCategoryList);
            modelMap.put("success", Boolean.valueOf(true));
        } else {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "空的 pageSize or pageIndex or 商铺id");
        }
        return modelMap;
    }

    @RequestMapping(value = {"/modifyproduct"}, method = {org.springframework.web.bind.annotation.RequestMethod.POST})
    @ResponseBody
    private Map<String, Object> modifyProduct(HttpServletRequest request) {
        boolean statusChange = HttpServletRequestUtil.getBoolean(request, "statusChange").booleanValue();
        Map<String, Object> modelMap = new HashMap();
        if ((!statusChange) && (!CodeUtil.checkVerifyCode(request))) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "输入了错误的验证码");
            return modelMap;
        }


        ObjectMapper mapper = new ObjectMapper();
        Product product = null;
        String productStr = HttpServletRequestUtil.getString(request, "productStr");
        MultipartHttpServletRequest multipartHttpServletRequest = null;
        MultipartFile thumbnailFile = null;
        List<MultipartFile> imgdeTailsMultipartFiles = new ArrayList();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        try {
            if (multipartResolver.isMultipart(request)) {
                multipartHttpServletRequest = (MultipartHttpServletRequest) request;

                thumbnailFile = multipartHttpServletRequest.getFile("thumbnail");

                for (int i = 0; i < 8; i++) {
                    MultipartFile singleProductImgs = multipartHttpServletRequest.getFile("productImg" + i);
                    if (singleProductImgs == null) break;
                    imgdeTailsMultipartFiles.add(singleProductImgs);
                }

            }
        } catch (Exception e) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }
        try {
            product = (Product) mapper.readValue(productStr, Product.class);
        } catch (Exception e) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }
        if (product != null) {
            try {
                Shop currentShop = (Shop) request.getSession().getAttribute("currentShop");
                Shop shop = new Shop();
                shop.setShopId(currentShop.getShopId());
                product.setShop(shop);
                ProductExecution pe = this.productService.modifyProduct(product, thumbnailFile, imgdeTailsMultipartFiles);
                if (pe.getState() == ProductStateEnum.SUCCESS.getState()) {
                    modelMap.put("success", Boolean.valueOf(true));
                } else {
                    modelMap.put("success", Boolean.valueOf(false));
                    modelMap.put("errMsg", pe.getStateInfo());
                }
            } catch (RuntimeException e) {
                modelMap.put("success", Boolean.valueOf(false));
                modelMap.put("errMsg", e.toString());
                return modelMap;
            }
        } else {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "请输入商品信息");
        }
        return modelMap;
    }

    @PostMapping({"/addproduct"})
    @ResponseBody
    private Map<String, Object> addProduct(HttpServletRequest request) {
        Map<String, Object> modelMap = new HashMap();
        if (!CodeUtil.checkVerifyCode(request)) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "输入了错误的验证码哦~");
            return modelMap;
        }

        ObjectMapper mapper = new ObjectMapper();
        Product product = null;
        String productStr = HttpServletRequestUtil.getString(request, "productStr");
        MultipartHttpServletRequest multipartHttpServletRequest = null;
        MultipartFile thumbnailFile = null;
        List<MultipartFile> imgdeTailsMultipartFiles = new ArrayList();
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
        try {
            if (multipartResolver.isMultipart(request)) {
                multipartHttpServletRequest = (MultipartHttpServletRequest) request;

                thumbnailFile = multipartHttpServletRequest.getFile("thumbnail");

                for (int i = 0; i < 8; i++) {
                    MultipartFile singleProductImgs = multipartHttpServletRequest.getFile("productImg" + i);
                    if (singleProductImgs == null) break;
                    imgdeTailsMultipartFiles.add(singleProductImgs);
                }

            } else {
                modelMap.put("success", Boolean.valueOf(false));
                modelMap.put("errMsg", "图片上传出错");
                return modelMap;
            }
        } catch (Exception e) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", e.toString());
            return modelMap;
        }

        try {
            product = (Product) mapper.readValue(productStr, Product.class);
        } catch (Exception e) {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }

        if ((product != null) && (thumbnailFile != null) && (imgdeTailsMultipartFiles != null)) {
            try {
                Shop currShop = (Shop) request.getSession().getAttribute("currentShop");
                product.setShop(currShop);

                ProductExecution productExecutionResult = this.productService.addProduct(product, thumbnailFile, imgdeTailsMultipartFiles);
                if (productExecutionResult.getState() == ProductStateEnum.SUCCESS.getState()) {
                    modelMap.put("success", Boolean.valueOf(true));
                } else {
                    modelMap.put("success", Boolean.valueOf(false));
                    modelMap.put("errMsg", productExecutionResult.getStateInfo());
                }
            } catch (ProductOperationException e) {
                modelMap.put("success", Boolean.valueOf(false));
                modelMap.put("errMsg", e.getMessage());
                return modelMap;
            }
        } else {
            modelMap.put("success", Boolean.valueOf(false));
            modelMap.put("errMsg", "请输入商品信息");
        }
        return modelMap;
    }

    private Product compactProductCondition4Search(long shopId, long productCategoryId, String productName) {
        Product productCondition = new Product();
        Shop shop = new Shop();
        shop.setShopId(Long.valueOf(shopId));
        productCondition.setShop(shop);
        if (productCategoryId != -1L) {
            ProductCategory productCategory = new ProductCategory();
            productCategory.setProductCategoryId(Long.valueOf(productCategoryId));
            productCondition.setProductCategory(productCategory);
        }
        if (productName != null) {
            productCondition.setProductName(productName);
        }
        return productCondition;
    }
}


