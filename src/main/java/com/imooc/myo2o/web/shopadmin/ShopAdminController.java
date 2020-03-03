/*    */ package com.imooc.myo2o.web.shopadmin;
/*    */ 
/*    */ import org.springframework.stereotype.Controller;
/*    */ import org.springframework.web.bind.annotation.RequestMapping;
/*    */ 
/*    */ 
/*    */ 
/*    */ @Controller
/*    */ @RequestMapping(value={"/shopadmin"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
/*    */ public class ShopAdminController
/*    */ {
/*    */   @RequestMapping({"/shopoperation"})
/*    */   public String shopOperation()
/*    */   {
/* 15 */     return "/shop/shopoperation";
/*    */   }
/*    */   
/*    */   @RequestMapping({"/shoplist"})
/*    */   public String shopList() {
/* 20 */     return "/shop/shoplist";
/*    */   }
/*    */   
/*    */   @RequestMapping({"/shopmanagement"})
/*    */   public String shopManagement() {
/* 25 */     return "/shop/shopmanagement";
/*    */   }
/*    */   
/*    */   @RequestMapping({"/productcategorymanagement"})
/* 29 */   public String productCategoryManage() { return "shop/productcategorymanagement"; }
/*    */   
/*    */   @RequestMapping({"/productoperation"})
/*    */   public String productOperation()
/*    */   {
/* 34 */     return "shop/productoperation";
/*    */   }
/*    */   
/*    */   @RequestMapping({"/productmanagement"})
/*    */   public String productmanagement() {
/* 39 */     return "shop/productmanagement";
/*    */   }
/*    */ }



