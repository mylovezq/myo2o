/*     */ package com.imooc.myo2o.web.shopadmin;
/*     */ 
/*     */ import com.fasterxml.jackson.databind.ObjectMapper;
/*     */ import com.imooc.myo2o.dto.ProductExecution;
/*     */ import com.imooc.myo2o.entity.Product;
/*     */ import com.imooc.myo2o.entity.ProductCategory;
/*     */ import com.imooc.myo2o.entity.Shop;
/*     */ import com.imooc.myo2o.enums.ProductStateEnum;
/*     */ import com.imooc.myo2o.exceptions.ProductOperationException;
/*     */ import com.imooc.myo2o.service.ProductCategoryService;
/*     */ import com.imooc.myo2o.service.ProductService;
/*     */ import com.imooc.myo2o.util.CodeUtil;
/*     */ import com.imooc.myo2o.util.HttpServletRequestUtil;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import javax.servlet.http.HttpServletRequest;
/*     */ import javax.servlet.http.HttpSession;
/*     */ import org.springframework.beans.factory.annotation.Autowired;
/*     */ import org.springframework.stereotype.Controller;
/*     */ import org.springframework.web.bind.annotation.PostMapping;
/*     */ import org.springframework.web.bind.annotation.RequestMapping;
/*     */ import org.springframework.web.bind.annotation.RequestParam;
/*     */ import org.springframework.web.bind.annotation.ResponseBody;
/*     */ import org.springframework.web.multipart.MultipartFile;
/*     */ import org.springframework.web.multipart.MultipartHttpServletRequest;
/*     */ import org.springframework.web.multipart.commons.CommonsMultipartResolver;
/*     */ 
/*     */ 
/*     */ @Controller
/*     */ @RequestMapping({"/shopadmin"})
/*     */ public class ProductManagementController
/*     */ {
/*     */   @Autowired
/*     */   private ProductService productService;
/*     */   @Autowired
/*     */   private ProductCategoryService productCategoryService;
/*     */   private static final int IMAGEMAXCOUNT = 8;
/*     */   
/*     */   @RequestMapping(value={"/getproductlistbyshop"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @ResponseBody
/*     */   private Map<String, Object> getProductListByShop(HttpServletRequest request)
/*     */   {
/*  45 */     Map<String, Object> modelMap = new HashMap();
/*  46 */     int pageIndex = HttpServletRequestUtil.getInt(request, "pageIndex");
/*  47 */     int pageSize = HttpServletRequestUtil.getInt(request, "pageSize");
/*  48 */     Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");
/*     */     
/*  50 */     if ((pageIndex > -1) && (pageSize > -1) && (currentShop != null) && (currentShop.getShopId() != null)) {
/*  51 */       long productCategoryId = HttpServletRequestUtil.getLong(request, "productCategoryId");
/*  52 */       String productName = HttpServletRequestUtil.getString(request, "productName");
/*  53 */       Product productCondition = compactProductCondition4Search(currentShop.getShopId().longValue(), productCategoryId, productName);
/*  54 */       ProductExecution pe = this.productService.getProductList(productCondition, pageIndex, pageSize);
/*  55 */       modelMap.put("productList", pe.getProductList());
/*  56 */       modelMap.put("count", Integer.valueOf(pe.getCount()));
/*  57 */       modelMap.put("success", Boolean.valueOf(true));
/*     */     } else {
/*  59 */       modelMap.put("success", Boolean.valueOf(false));
/*  60 */       modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
/*     */     }
/*     */     
/*  63 */     return modelMap;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/getproductbyid"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @ResponseBody
/*     */   private Map<String, Object> getProductById(@RequestParam Long productId) {
/*  69 */     Map<String, Object> modelMap = new HashMap();
/*  70 */     if (productId.longValue() > -1L) {
/*  71 */       Product product = this.productService.getProductById(productId.longValue());
/*  72 */       List<ProductCategory> productCategoryList = this.productCategoryService.getByShopId(product.getShop().getShopId().longValue());
/*  73 */       modelMap.put("product", product);
/*  74 */       modelMap.put("productCategoryList", productCategoryList);
/*  75 */       modelMap.put("success", Boolean.valueOf(true));
/*     */     } else {
/*  77 */       modelMap.put("success", Boolean.valueOf(false));
/*  78 */       modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
/*     */     }
/*  80 */     return modelMap;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/getproductcategorylistbyshopId"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*     */   @ResponseBody
/*     */   private Map<String, Object> getProductCategoryListByShopId(HttpServletRequest request)
/*     */   {
/*  87 */     Map<String, Object> modelMap = new HashMap();
/*  88 */     Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");
/*     */     
/*  90 */     if ((currentShop != null) && (currentShop.getShopId() != null))
/*     */     {
/*  92 */       List<ProductCategory> productCategoryList = this.productCategoryService.getByShopId(currentShop.getShopId().longValue());
/*  93 */       modelMap.put("productCategoryList", productCategoryList);
/*  94 */       modelMap.put("success", Boolean.valueOf(true));
/*     */     } else {
/*  96 */       modelMap.put("success", Boolean.valueOf(false));
/*  97 */       modelMap.put("errMsg", "empty pageSize or pageIndex or shopId");
/*     */     }
/*  99 */     return modelMap;
/*     */   }
/*     */   
/*     */   @RequestMapping(value={"/modifyproduct"}, method={org.springframework.web.bind.annotation.RequestMethod.POST})
/*     */   @ResponseBody
/*     */   private Map<String, Object> modifyProduct(HttpServletRequest request)
/*     */   {
/* 106 */     boolean statusChange = HttpServletRequestUtil.getBoolean(request, "statusChange").booleanValue();
/* 107 */     Map<String, Object> modelMap = new HashMap();
/* 108 */     if ((!statusChange) && (!CodeUtil.checkVerifyCode(request))) {
/* 109 */       modelMap.put("success", Boolean.valueOf(false));
/* 110 */       modelMap.put("errMsg", "输入了错误的验证码");
/* 111 */       return modelMap;
/*     */     }
/*     */     
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/* 141 */     ObjectMapper mapper = new ObjectMapper();
/* 142 */     Product product = null;
/* 143 */     String productStr = HttpServletRequestUtil.getString(request, "productStr");
/* 144 */     MultipartHttpServletRequest multipartHttpServletRequest = null;
/* 145 */     MultipartFile thumbnailFile = null;
/* 146 */     List<MultipartFile> imgdeTailsMultipartFiles = new ArrayList();
/* 147 */     CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
/*     */     try
/*     */     {
/* 150 */       if (multipartResolver.isMultipart(request)) {
/* 151 */         multipartHttpServletRequest = (MultipartHttpServletRequest)request;
/*     */         
/* 153 */         thumbnailFile = multipartHttpServletRequest.getFile("thumbnail");
/*     */         
/* 155 */         for (int i = 0; i < 8; i++) {
/* 156 */           MultipartFile singleProductImgs = multipartHttpServletRequest.getFile("productImg" + i);
/* 157 */           if (singleProductImgs == null) break;
/* 158 */           imgdeTailsMultipartFiles.add(singleProductImgs);
/*     */         }
/*     */         
/*     */       }
/*     */     }
/*     */     catch (Exception e)
/*     */     {
/* 165 */       modelMap.put("success", Boolean.valueOf(false));
/* 166 */       modelMap.put("errMsg", e.toString());
/* 167 */       return modelMap;
/*     */     }
/*     */     try
/*     */     {
/* 171 */       product = (Product)mapper.readValue(productStr, Product.class);
/*     */     } catch (Exception e) {
/* 173 */       modelMap.put("success", Boolean.valueOf(false));
/* 174 */       modelMap.put("errMsg", e.getMessage());
/* 175 */       return modelMap;
/*     */     }
/* 177 */     if (product != null) {
/*     */       try {
/* 179 */         Shop currentShop = (Shop)request.getSession().getAttribute("currentShop");
/* 180 */         Shop shop = new Shop();
/* 181 */         shop.setShopId(currentShop.getShopId());
/* 182 */         product.setShop(shop);
/* 183 */         ProductExecution pe = this.productService.modifyProduct(product, thumbnailFile, imgdeTailsMultipartFiles);
/* 184 */         if (pe.getState() == ProductStateEnum.SUCCESS.getState()) {
/* 185 */           modelMap.put("success", Boolean.valueOf(true));
/*     */         } else {
/* 187 */           modelMap.put("success", Boolean.valueOf(false));
/* 188 */           modelMap.put("errMsg", pe.getStateInfo());
/*     */         }
/*     */       } catch (RuntimeException e) {
/* 191 */         modelMap.put("success", Boolean.valueOf(false));
/* 192 */         modelMap.put("errMsg", e.toString());
/* 193 */         return modelMap;
/*     */       }
/*     */     }
/*     */     else {
/* 197 */       modelMap.put("success", Boolean.valueOf(false));
/* 198 */       modelMap.put("errMsg", "请输入商品信息");
/*     */     }
/* 200 */     return modelMap;
/*     */   }
/*     */   
/*     */   @PostMapping({"/addproduct"})
/*     */   @ResponseBody
/*     */   private Map<String, Object> addProduct(HttpServletRequest request) {
/* 206 */     Map<String, Object> modelMap = new HashMap();
/* 207 */     if (!CodeUtil.checkVerifyCode(request)) {
/* 208 */       modelMap.put("success", Boolean.valueOf(false));
/* 209 */       modelMap.put("errMsg", "输入了错误的验证码哦~");
/* 210 */       return modelMap;
/*     */     }
/*     */     
/* 213 */     ObjectMapper mapper = new ObjectMapper();
/* 214 */     Product product = null;
/* 215 */     String productStr = HttpServletRequestUtil.getString(request, "productStr");
/* 216 */     MultipartHttpServletRequest multipartHttpServletRequest = null;
/* 217 */     MultipartFile thumbnailFile = null;
/* 218 */     List<MultipartFile> imgdeTailsMultipartFiles = new ArrayList();
/* 219 */     CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
/*     */     try
/*     */     {
/* 222 */       if (multipartResolver.isMultipart(request)) {
/* 223 */         multipartHttpServletRequest = (MultipartHttpServletRequest)request;
/*     */         
/* 225 */         thumbnailFile = multipartHttpServletRequest.getFile("thumbnail");
/*     */         
/* 227 */         for (int i = 0; i < 8; i++) {
/* 228 */           MultipartFile singleProductImgs = multipartHttpServletRequest.getFile("productImg" + i);
/* 229 */           if (singleProductImgs == null) break;
/* 230 */           imgdeTailsMultipartFiles.add(singleProductImgs);
/*     */         }
/*     */         
/*     */       }
/*     */       else
/*     */       {
/* 236 */         modelMap.put("success", Boolean.valueOf(false));
/* 237 */         modelMap.put("errMsg", "图片上传出错");
/* 238 */         return modelMap;
/*     */       }
/*     */     } catch (Exception e) {
/* 241 */       modelMap.put("success", Boolean.valueOf(false));
/* 242 */       modelMap.put("errMsg", e.toString());
/* 243 */       return modelMap;
/*     */     }
/*     */     
/*     */     try
/*     */     {
/* 248 */       product = (Product)mapper.readValue(productStr, Product.class);
/*     */     } catch (Exception e) {
/* 250 */       modelMap.put("success", Boolean.valueOf(false));
/* 251 */       modelMap.put("errMsg", e.getMessage());
/* 252 */       return modelMap;
/*     */     }
/*     */     
/* 255 */     if ((product != null) && (thumbnailFile != null) && (imgdeTailsMultipartFiles != null))
/*     */     {
/*     */       try {
/* 258 */         Shop currShop = (Shop)request.getSession().getAttribute("currentShop");
/* 259 */         product.setShop(currShop);
/*     */         
/* 261 */         ProductExecution productExecutionResult = this.productService.addProduct(product, thumbnailFile, imgdeTailsMultipartFiles);
/* 262 */         if (productExecutionResult.getState() == ProductStateEnum.SUCCESS.getState()) {
/* 263 */           modelMap.put("success", Boolean.valueOf(true));
/*     */         } else {
/* 265 */           modelMap.put("success", Boolean.valueOf(false));
/* 266 */           modelMap.put("errMsg", productExecutionResult.getStateInfo());
/*     */         }
/*     */       } catch (ProductOperationException e) {
/* 269 */         modelMap.put("success", Boolean.valueOf(false));
/* 270 */         modelMap.put("errMsg", e.getMessage());
/* 271 */         return modelMap;
/*     */       }
/*     */     }
/*     */     else {
/* 275 */       modelMap.put("success", Boolean.valueOf(false));
/* 276 */       modelMap.put("errMsg", "请输入商品信息");
/*     */     }
/* 278 */     return modelMap;
/*     */   }
/*     */   
/*     */   private Product compactProductCondition4Search(long shopId, long productCategoryId, String productName) {
/* 282 */     Product productCondition = new Product();
/* 283 */     Shop shop = new Shop();
/* 284 */     shop.setShopId(Long.valueOf(shopId));
/* 285 */     productCondition.setShop(shop);
/* 286 */     if (productCategoryId != -1L) {
/* 287 */       ProductCategory productCategory = new ProductCategory();
/* 288 */       productCategory.setProductCategoryId(Long.valueOf(productCategoryId));
/* 289 */       productCondition.setProductCategory(productCategory);
/*     */     }
/* 291 */     if (productName != null) {
/* 292 */       productCondition.setProductName(productName);
/*     */     }
/* 294 */     return productCondition;
/*     */   }
/*     */ }


