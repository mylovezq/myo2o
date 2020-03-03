/*    */ package com.imooc.myo2o.web.frontend;
/*    */ 
/*    */ import com.imooc.myo2o.entity.Product;
/*    */ import com.imooc.myo2o.service.ProductService;
/*    */ import com.imooc.myo2o.util.HttpServletRequestUtil;
/*    */ import java.util.HashMap;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping({"/frontend"})
/*    */ public class ProductDetailController
/*    */ {
/*    */   @Autowired
/*    */   private ProductService productService;
/* 30 */   private static String URLPREFIX = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxd7f6c5b8899fba83&redirect_uri=115.28.159.6/myo2o/shop/adduserproductmap&response_type=code&scope=snsapi_userinfo&state=";
/*    */   
/*    */ 
/*    */ 
/* 34 */   private static String URLSUFFIX = "#wechat_redirect";
/*    */   
/*    */   @RequestMapping(value={"/listproductdetailpageinfo"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   @ResponseBody
/*    */   private Map<String, Object> listProductDetailPageInfo(HttpServletRequest request)
/*    */   {
/* 40 */     Map<String, Object> modelMap = new HashMap();
/* 41 */     long productId = HttpServletRequestUtil.getLong(request, "productId");
/* 42 */     Product product = null;
/* 43 */     if (productId != -1L) {
/* 44 */       product = this.productService.getProductById(productId);
/* 45 */       modelMap.put("product", product);
/* 46 */       modelMap.put("success", Boolean.valueOf(true));
/*    */     } else {
/* 48 */       modelMap.put("success", Boolean.valueOf(false));
/* 49 */       modelMap.put("errMsg", "empty productId");
/*    */     }
/* 51 */     return modelMap;
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\web\frontend\ProductDetailController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */