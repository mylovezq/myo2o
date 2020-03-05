package com.imooc.myo2o.web.frontend;

import org.springframework.web.bind.annotation.RequestMapping;

@org.springframework.stereotype.Controller
@RequestMapping({"/frontend"})
public class FrontendController {
    @RequestMapping(value = {"/mainpage"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String showMainPage() {
        return "frontend/mainpage";
    }

    @RequestMapping(value = {"/productdetail"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String showProductDetail() {
        return "frontend/productdetail";
    }

    @RequestMapping(value = {"/shopdetail"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String showShopDetail() {
        return "frontend/shopdetail";
    }

    @RequestMapping(value = {"/shoplist"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String showShopList() {
        return "frontend/shoplist";
    }

    @RequestMapping(value = {"/index"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String index() {
        return "frontend/index";
    }

    @RequestMapping(value = {"/mypoint"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String myPoint() {
        return "frontend/mypoint";
    }

    @RequestMapping(value = {"/myrecord"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String myRecord() {
        return "frontend/myrecord";
    }

    @RequestMapping(value = {"/pointrecord"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String pointRecord() {
        return "frontend/pointrecord";
    }

    @RequestMapping(value = {"/awarddetail"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String awardDetail() {
        return "frontend/awarddetail";
    }

    @RequestMapping(value = {"/customerbind"}, method = {org.springframework.web.bind.annotation.RequestMethod.GET})
    public String customerBind() {
        return "frontend/customerbind";
    }
}


