 package com.imooc.myo2o.web.shopadmin;

 import com.imooc.myo2o.dto.ProductCategoryExecution;
 import com.imooc.myo2o.dto.Result;
 import com.imooc.myo2o.entity.ProductCategory;
 import com.imooc.myo2o.entity.Shop;
 import com.imooc.myo2o.enums.ProductCategoryStateEnum;
 import com.imooc.myo2o.service.ProductCategoryService;
 import java.util.Date;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpSession;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.RequestBody;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.ResponseBody;



 @Controller
 @RequestMapping({"/shopadmin"})
 public class ProductCategoryManagementController
 {
   @Autowired
   private ProductCategoryService productCategoryService;

   @RequestMapping(value={"/getproductcategorylist"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
   @ResponseBody
   private Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request)
   {
     Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");
     List<ProductCategory> list = null;
     if ((currentShop != null) && (currentShop.getShopId().longValue() > 0L)) {
       list = this.productCategoryService.getByShopId(currentShop.getShopId().longValue());
       return new Result(true, list);
     }
     ProductCategoryStateEnum ps = ProductCategoryStateEnum.INNER_ERROR;
     return new Result(false, ps.getState(), ps
       .getStateInfo());
   }

   @RequestMapping(value={"/addproductcategorys"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
   @ResponseBody
   private Map<String, Object> addProductCategorys(@RequestBody List<ProductCategory> productCategoryList, HttpServletRequest request)
   {
     Map<String, Object> modelMap = new HashMap();
     Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");
     for (ProductCategory pc : productCategoryList) {
       pc.setShopId(currentShop.getShopId());
       pc.setCreateTime(new Date());
       pc.setLastEditTime(new Date());
     }
     if ((productCategoryList != null) && (productCategoryList.size() > 0)) {
       try {
         ProductCategoryExecution pe = this.productCategoryService.batchAddProductCategory(productCategoryList);

         if (pe.getState() == ProductCategoryStateEnum.SUCCESS.getState()) {
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
     }
     else {
       modelMap.put("success", Boolean.valueOf(false));
       modelMap.put("errMsg", "请至少输入一个商品类别");
     }
     return modelMap;
   }

   @RequestMapping(value={"/removeproductcategory"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
   @ResponseBody
   private Map<String, Object> removeProductCategory(Long productCategoryId, HttpServletRequest request) {
     Map<String, Object> modelMap = new HashMap();
     if ((productCategoryId != null) && (productCategoryId.longValue() > 0L)) {
       try {
         Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");
         ProductCategoryExecution pe = this.productCategoryService.deleteProductCategory(productCategoryId.longValue(), currentShop.getShopId().longValue());
         if (pe.getState() == ProductCategoryStateEnum.SUCCESS.getState()) {
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
     }
     else {
       modelMap.put("success", Boolean.valueOf(false));
       modelMap.put("errMsg", "请至少选择一个商品类别");
     }
     return modelMap;
   }
 }
