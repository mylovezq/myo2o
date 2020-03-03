/*    */ package com.imooc.myo2o.web.frontend;
/*    */ 
/*    */ import com.imooc.myo2o.dto.ProductExecution;
/*    */ import com.imooc.myo2o.entity.Product;
/*    */ import com.imooc.myo2o.entity.ProductCategory;
/*    */ import com.imooc.myo2o.entity.Shop;
/*    */ import com.imooc.myo2o.service.ProductCategoryService;
/*    */ import com.imooc.myo2o.service.ProductService;
/*    */ import com.imooc.myo2o.service.ShopService;
/*    */ import com.imooc.myo2o.util.HttpServletRequestUtil;
/*    */ import java.util.HashMap;
/*    */ import java.util.List;
/*    */ import java.util.Map;
/*    */ import javax.servlet.http.HttpServletRequest;
/*    */ import org.springframework.beans.factory.annotation.Autowired;
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ import org.springframework.web.bind.annotation.ResponseBody;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/frontend"})
/*    */ public class ShopDetailController
/*    */ {
/*    */   @Autowired
/*    */   private ShopService shopService;
/*    */   @Autowired
/*    */   private ProductService productService;
/*    */   @Autowired
/*    */   private ProductCategoryService productCategoryService;
/*    */   
/*    */   @RequestMapping(value={"/listshopdetailpageinfo"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   @ResponseBody
/*    */   private Map<String, Object> listShopDetailPageInfo(HttpServletRequest request)
/*    */   {
/* 38 */     Map<String, Object> modelMap = new HashMap();
/* 39 */     long shopId = HttpServletRequestUtil.getLong(request, "shopId");
/* 40 */     Shop shop = null;
/* 41 */     List<ProductCategory> productCategoryList = null;
/* 42 */     if (shopId != -1L) {
/* 43 */       shop = this.shopService.getByShopId(shopId);
/* 44 */       productCategoryList = this.productCategoryService.getByShopId(shopId);
/* 45 */       modelMap.put("shop", shop);
/* 46 */       modelMap.put("productCategoryList", productCategoryList);
/* 47 */       modelMap.put("success", Boolean.valueOf(true));
/*    */     } else {
/* 49 */       modelMap.put("success", Boolean.valueOf(false));
/* 50 */       modelMap.put("errMsg", "empty shopId");
/*    */     }
/* 52 */     return modelMap;
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/listproductsbyshop"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   @ResponseBody
/*    */   private Map<String, Object> listProductsByShop(HttpServletRequest request) {
/* 58 */     Map<String, Object> modelMap = new HashMap();
/* 59 */     int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
/* 60 */     int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
/* 61 */     long shopId = HttpServletRequestUtil.getLong(request, "shopId");
/* 62 */     if ((pageIndex > -1) && (pageSize > -1) && (shopId > -1L)) {
/* 63 */       long productCategoryId = HttpServletRequestUtil.getLong(request, "productCategoryId");
/* 64 */       String productName = HttpServletRequestUtil.getString(request, "productName");
/* 65 */       Product productCondition = compactProductCondition4Search(shopId, productCategoryId, productName);
/* 66 */       ProductExecution pe = this.productService.getProductList(productCondition, pageIndex, pageSize);
/* 67 */       modelMap.put("productList", pe.getProductList());
/* 68 */       modelMap.put("count", Integer.valueOf(pe.getCount()));
/* 69 */       modelMap.put("success", Boolean.valueOf(true));
/*    */     } else {
/* 71 */       modelMap.put("success", Boolean.valueOf(false));
/* 72 */       modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
/*    */     }
/* 74 */     return modelMap;
/*    */   }
/*    */   
/*    */   private Product compactProductCondition4Search(long shopId, long productCategoryId, String productName) {
/* 78 */     Product productCondition = new Product();
/* 79 */     Shop shop = new Shop();
/* 80 */     shop.setShopId(Long.valueOf(shopId));
/* 81 */     productCondition.setShop(shop);
/* 82 */     if (productCategoryId != -1L) {
/* 83 */       ProductCategory productCategory = new ProductCategory();
/* 84 */       productCategory.setProductCategoryId(Long.valueOf(productCategoryId));
/* 85 */       productCondition.setProductCategory(productCategory);
/*    */     }
/* 87 */     if (productName != null) {
/* 88 */       productCondition.setProductName(productName);
/*    */     }
/* 90 */     productCondition.setEnableStatus(Integer.valueOf(1));
/* 91 */     return productCondition;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\web\frontend\ShopDetailController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */