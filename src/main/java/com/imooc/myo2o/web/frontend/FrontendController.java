/*    */ package com.imooc.myo2o.web.frontend;
/*    */ 
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ @org.springframework.stereotype.Controller
/*    */ @RequestMapping({"/frontend"})
/*    */ public class FrontendController
/*    */ {
/*    */   @RequestMapping(value={"/mainpage"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String showMainPage()
/*    */   {
/* 12 */     return "frontend/mainpage";
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/productdetail"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String showProductDetail() {
/* 17 */     return "frontend/productdetail";
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/shopdetail"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String showShopDetail() {
/* 22 */     return "frontend/shopdetail";
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/shoplist"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String showShopList() {
/* 27 */     return "frontend/shoplist";
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/index"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String index() {
/* 32 */     return "frontend/index";
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/mypoint"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String myPoint() {
/* 37 */     return "frontend/mypoint";
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/myrecord"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String myRecord() {
/* 42 */     return "frontend/myrecord";
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/pointrecord"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String pointRecord() {
/* 47 */     return "frontend/pointrecord";
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/awarddetail"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String awardDetail() {
/* 52 */     return "frontend/awarddetail";
/*    */   }
/*    */   
/*    */   @RequestMapping(value={"/customerbind"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */   public String customerBind() {
/* 57 */     return "frontend/customerbind";
/*    */   }
/*    */ }


/* Location:              E:\o2o\myo2o.war!\WEB-INF\classes\com\imooc\myo2o\web\frontend\FrontendController.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */