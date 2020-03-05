 package com.imooc.myo2o.web.frontend;

 import com.imooc.myo2o.entity.Product;
 import com.imooc.myo2o.service.ProductService;
 import com.imooc.myo2o.util.HttpServletRequestUtil;
 import java.util.HashMap;
 import java.util.Map;
 import javax.servlet.http.HttpServletRequest;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.ResponseBody;











 @Controller
 @RequestMapping({"/frontend"})
 public class ProductDetailController
 {
   @Autowired
   private ProductService productService;
   private static String URLPREFIX = "https://open.weixin.qq.com/connect/oauth2/authorize?appid=wxd7f6c5b8899fba83&redirect_uri=115.28.159.6/myo2o/shop/adduserproductmap&response_type=code&scope=snsapi_userinfo&state=";



   private static String URLSUFFIX = "#wechat_redirect";

   @RequestMapping(value={"/listproductdetailpageinfo"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
   @ResponseBody
   private Map<String, Object> listProductDetailPageInfo(HttpServletRequest request)
   {
     Map<String, Object> modelMap = new HashMap();
     long productId = HttpServletRequestUtil.getLong(request, "productId");
     Product product = null;
     if (productId != -1L) {
       product = this.productService.getProductById(productId);
       modelMap.put("product", product);
       modelMap.put("success", Boolean.valueOf(true));
     } else {
       modelMap.put("success", Boolean.valueOf(false));
       modelMap.put("errMsg", "empty productId");
     }
     return modelMap;
   }
 }


