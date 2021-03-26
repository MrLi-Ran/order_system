package com.newer.order_system.controller;

import com.newer.order_system.module.order.OrderService;
import com.newer.order_system.pojo.Bill;
import com.newer.order_system.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;



    /**
     * 修改桌台状态
     * @param id 桌台ID
     */
    @PutMapping("/{id}")
    public String updateTableStatus(@PathVariable long id){
        return orderService.updateTableStatus(id);
    }

    /**
     * 提交订单
     * @param bill 订单实体
     */
    @PostMapping("/{id}") // 参数换成BillDetail
    public void insertBill(@RequestBody Bill bill){
        orderService.insertBill(bill);
    }
}
