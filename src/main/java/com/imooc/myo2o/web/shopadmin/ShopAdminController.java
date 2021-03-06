 package com.imooc.myo2o.web.shopadmin;

 import org.springframework.stereotype.Controller;
 import org.springframework.web.bind.annotation.RequestMapping;
 import org.springframework.web.bind.annotation.RequestMethod;


 @Controller
 @RequestMapping(value={"/shopadmin"}, method={org.springframework.web.bind.annotation.RequestMethod.GET})
 public class ShopAdminController
 {
   @RequestMapping({"/shopoperation"})
   public String shopOperation()
   {
     return "/shop/shopoperation";
   }

   @RequestMapping({"/shoplist"})
   public String shopList() {
     return "/shop/shoplist";
   }

   @RequestMapping({"/shopmanagement"})
   public String shopManagement() {
     return "/shop/shopmanagement";
   }

   @RequestMapping({"/productcategorymanage"})
   public String productCategoryManage() { return "shop/productcategorymanage"; }

   @RequestMapping({"/productoperation"})
   public String productOperation()
   {
     return "shop/productoperation";
   }

   @RequestMapping({"/productmanage"})
   public String productmanagement() {
     return "shop/productmanage";
   }

   @RequestMapping({"/awardmanage"})
     private String awardManage() {
         return "shop/awardmanage";
     }
     @RequestMapping(value = "/awardedit", method = RequestMethod.GET)
     private String awardEdit() {
         return "shop/awardedit";
     }



 }



