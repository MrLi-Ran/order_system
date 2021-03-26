package com.newer.order_system.controller;
import com.newer.order_system.module.home.HomePageService;
import com.newer.order_system.pojo.HomePageRespond;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomePageController {
    @Autowired
    HomePageService homePageService;
    /**
     * 获取所有桌台
     * @return 产品列表
     */
    @GetMapping
    public HomePageRespond selectAllTable(){
        return homePageService.selectAll();
    }
}
