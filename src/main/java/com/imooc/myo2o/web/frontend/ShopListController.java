/*     */ package com.imooc.myo2o.web.frontend;
/*     */ 
/*     */ import com.fasterxml.jackson.core.JsonParseException;
/*     */ import com.fasterxml.jackson.databind.JsonMappingException;
/*     */ import com.imooc.myo2o.dto.ShopExecution;
/*     */ import com.imooc.myo2o.entity.Area;
/*     */ import com.imooc.myo2o.entity.Shop;
/*     */ import com.imooc.myo2o.entity.ShopCategory;
/*     */ import com.imooc.myo2o.service.AreaService;
/*     */ import com.imooc.myo2o.service.ShopCategoryService;
/*     */ import com.imooc.myo2o.service.ShopService;
/*     */ import com.imooc.myo2o.util.HttpServletRequestUtil;
/*     */ import java.io.IOException;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ 
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/frontend"})
/*     */ public class ShopListController
/*     */ {
/*     */   @Autowired
/*     */   private AreaService areaService;
/*     */   @Autowired
/*     */   private ShopCategoryService shopCategoryService;
/*     */   @Autowired
/*     */   private ShopService shopService;
/*     */   
/*     */   @RequestMapping(value={"/listshopspageinfo"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @ResponseBody
/*     */   private Map<String, Object> listShopsPageInfo(HttpServletRequest request)
/*     */   {
/*  40 */     Map<String, Object> modelMap = new HashMap();
/*  41 */     long parentId = HttpServletRequestUtil.getLong(request, "parentId");
/*  42 */     List<ShopCategory> shopCategoryList = null;
/*  43 */     if (parentId != -1L) {
/*     */       try {
/*  45 */         ShopCategory shopCategoryCondition = new ShopCategory();
/*  46 */         shopCategoryCondition.setShopCategoryId(Long.valueOf(parentId));
/*  47 */         shopCategoryList = this.shopCategoryService.getShopCategoryList(shopCategoryCondition);
/*     */       } catch (IOException e) {
/*  49 */         modelMap.put("success", Boolean.valueOf(false));
/*  50 */         modelMap.put("errMsg", e.toString());
/*     */       }
/*     */     } else {
/*     */       try {
/*  54 */         shopCategoryList = this.shopCategoryService.getShopCategoryList(null);
/*     */       } catch (IOException e) {
/*  56 */         modelMap.put("success", Boolean.valueOf(false));
/*  57 */         modelMap.put("errMsg", e.toString());
/*     */       }
/*     */     }
/*  60 */     modelMap.put("shopCategoryList", shopCategoryList);
/*  61 */     List<Area> areaList = null;
/*     */     try {
/*  63 */       areaList = this.areaService.getAreaList();
/*  64 */       modelMap.put("areaList", areaList);
/*  65 */       modelMap.put("success", Boolean.valueOf(true));
/*  66 */       return modelMap;
/*     */     } catch (JsonParseException e) {
/*  68 */       modelMap.put("success", Boolean.valueOf(false));
/*  69 */       modelMap.put("errMsg", e.toString());
/*     */     } catch (JsonMappingException e) {
/*  71 */       modelMap.put("success", Boolean.valueOf(false));
/*  72 */       modelMap.put("errMsg", e.toString());
/*     */     } catch (IOException e) {
/*  74 */       modelMap.put("success", Boolean.valueOf(false));
/*  75 */       modelMap.put("errMsg", e.toString());
/*     */     }
/*  77 */     return modelMap;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/listshops"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @ResponseBody
/*     */   private Map<String, Object> listShops(HttpServletRequest request) {
/*  83 */     Map<String, Object> modelMap = new HashMap();
/*  84 */     int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
/*  85 */     int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
/*  86 */     if ((pageIndex > -1) && (pageSize > -1))
/*     */     {
/*  88 */       long parentId = HttpServletRequestUtil.getLong(request, "parentId");
/*     */       
/*  90 */       long shopCategoryId = HttpServletRequestUtil.getLong(request, "shopCategoryId");
/*  91 */       long areaId = HttpServletRequestUtil.getLong(request, "areaId");
/*  92 */       String shopName = HttpServletRequestUtil.getString(request, "shopName");
/*  93 */       Shop shopCondition = compactShopCondition4Search(parentId, shopCategoryId, areaId, shopName);
/*  94 */       ShopExecution se = this.shopService.getShopList(shopCondition, pageIndex, pageSize);
/*  95 */       modelMap.put("shopList", se.getShopList());
/*  96 */       modelMap.put("count", Integer.valueOf(se.getCount()));
/*  97 */       modelMap.put("success", Boolean.valueOf(true));
/*     */     } else {
/*  99 */       modelMap.put("success", Boolean.valueOf(false));
/* 100 */       modelMap.put("errMsg", "empty pageSize or pageIndex");
/*     */     }
/*     */     
/* 103 */     return modelMap;
/*     */   }
/*     */   
/*     */   private Shop compactShopCondition4Search(long parentId, long shopCategoryId, long areaId, String shopName) {
/* 107 */     Shop shopCondition = new Shop();
/* 108 */     if (parentId != -1L) {
/* 109 */       ShopCategory parentCategory = new ShopCategory();
/* 110 */       parentCategory.setShopCategoryId(Long.valueOf(parentId));
/* 111 */       shopCondition.setParentCategory(parentCategory);
/*     */     }
/* 113 */     if (shopCategoryId != -1L) {
/* 114 */       ShopCategory shopCategory = new ShopCategory();
/* 115 */       shopCategory.setShopCategoryId(Long.valueOf(shopCategoryId));
/* 116 */       shopCondition.setShopCategory(shopCategory);
/*     */     }
/* 118 */     if (areaId != -1L) {
/* 119 */       Area area = new Area();
/* 120 */       area.setAreaId(Long.valueOf(areaId));
/* 121 */       shopCondition.setArea(area);
/*     */     }
/*     */     
/* 124 */     if (shopName != null) {
/* 125 */       shopCondition.setShopName(shopName);
/*     */     }
/* 127 */     shopCondition.setEnableStatus(Integer.valueOf(1));
/* 128 */     return shopCondition;
/*     */   }
/*     */ }


