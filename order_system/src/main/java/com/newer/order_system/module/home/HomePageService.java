package com.newer.order_system.module.home;

import com.newer.order_system.pojo.HomePageRespond;

import org.springframework.stereotype.Service;

@Service
public interface HomePageService {

    HomePageRespond selectAll();

}
