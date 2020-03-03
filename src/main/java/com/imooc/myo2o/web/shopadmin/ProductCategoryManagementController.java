/*     */ package com.imooc.myo2o.web.shopadmin;
/*     */ 
/*     */ import com.imooc.myo2o.dto.ProductCategoryExecution;
/*     */ import com.imooc.myo2o.dto.Result;
/*     */ import com.imooc.myo2o.entity.ProductCategory;
/*     */ import com.imooc.myo2o.entity.Shop;
/*     */ import com.imooc.myo2o.enums.ProductCategoryStateEnum;
/*     */ import com.imooc.myo2o.service.ProductCategoryService;
/*     */ import java.util.Date;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestBody;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/shopadmin"})
/*     */ public class ProductCategoryManagementController
/*     */ {
/*     */   @Autowired
/*     */   private ProductCategoryService productCategoryService;
/*     */   
/*     */   @RequestMapping(value={"/getproductcategorylist"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @ResponseBody
/*     */   private Result<List<ProductCategory>> getProductCategoryList(HttpServletRequest request)
/*     */   {
/*  34 */     Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");
/*  35 */     List<ProductCategory> list = null;
/*  36 */     if ((currentShop != null) && (currentShop.getShopId().longValue() > 0L)) {
/*  37 */       list = this.productCategoryService.getByShopId(currentShop.getShopId().longValue());
/*  38 */       return new Result(true, list);
/*     */     }
/*  40 */     ProductCategoryStateEnum ps = ProductCategoryStateEnum.INNER_ERROR;
/*  41 */     return new Result(false, ps.getState(), ps
/*  42 */       .getStateInfo());
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/addproductcategorys"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   private Map<String, Object> addProductCategorys(@RequestBody List<ProductCategory> productCategoryList, HttpServletRequest request)
/*     */   {
/*  49 */     Map<String, Object> modelMap = new HashMap();
/*  50 */     Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");
/*  51 */     for (ProductCategory pc : productCategoryList) {
/*  52 */       pc.setShopId(currentShop.getShopId());
/*  53 */       pc.setCreateTime(new Date());
/*  54 */       pc.setLastEditTime(new Date());
/*     */     }
/*  56 */     if ((productCategoryList != null) && (productCategoryList.size() > 0)) {
/*     */       try {
/*  58 */         ProductCategoryExecution pe = this.productCategoryService.batchAddProductCategory(productCategoryList);
/*     */         
/*  60 */         if (pe.getState() == ProductCategoryStateEnum.SUCCESS.getState()) {
/*  61 */           modelMap.put("success", Boolean.valueOf(true));
/*     */         } else {
/*  63 */           modelMap.put("success", Boolean.valueOf(false));
/*  64 */           modelMap.put("errMsg", pe.getStateInfo());
/*     */         }
/*     */       } catch (RuntimeException e) {
/*  67 */         modelMap.put("success", Boolean.valueOf(false));
/*  68 */         modelMap.put("errMsg", e.toString());
/*  69 */         return modelMap;
/*     */       }
/*     */     }
/*     */     else {
/*  73 */       modelMap.put("success", Boolean.valueOf(false));
/*  74 */       modelMap.put("errMsg", "请至少输入一个商品类别");
/*     */     }
/*  76 */     return modelMap;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/removeproductcategory"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   private Map<String, Object> removeProductCategory(Long productCategoryId, HttpServletRequest request) {
/*  82 */     Map<String, Object> modelMap = new HashMap();
/*  83 */     if ((productCategoryId != null) && (productCategoryId.longValue() > 0L)) {
/*     */       try {
/*  85 */         Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");
/*  86 */         ProductCategoryExecution pe = this.productCategoryService.deleteProductCategory(productCategoryId.longValue(), currentShop.getShopId().longValue());
/*  87 */         if (pe.getState() == ProductCategoryStateEnum.SUCCESS.getState()) {
/*  88 */           modelMap.put("success", Boolean.valueOf(true));
/*     */         } else {
/*  90 */           modelMap.put("success", Boolean.valueOf(false));
/*  91 */           modelMap.put("errMsg", pe.getStateInfo());
/*     */         }
/*     */       } catch (RuntimeException e) {
/*  94 */         modelMap.put("success", Boolean.valueOf(false));
/*  95 */         modelMap.put("errMsg", e.toString());
/*  96 */         return modelMap;
/*     */       }
/*     */     }
/*     */     else {
/* 100 */       modelMap.put("success", Boolean.valueOf(false));
/* 101 */       modelMap.put("errMsg", "请至少选择一个商品类别");
/*     */     }
/* 103 */     return modelMap;
/*     */   }
/*     */ }
