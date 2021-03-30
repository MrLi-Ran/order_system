package com.newer.order_system.controller;

import com.newer.order_system.module.order.OrderService;

import com.newer.order_system.pojo.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    OrderService orderService;

    /**
     * 开台
     * @param id 桌台id
     * @param num 人数
     * @return 是否成功
     */
    @PutMapping("/{id}/num/{num}")
    public String updateTableStatus(@PathVariable long id,@PathVariable int num){
        return orderService.tableOn(id, num);
    }

    /**
     * 提交订单
     * @param orderInfo 订单+产品列表实体
     */
    @PostMapping("/{tableId}") // 参数换成BillDetail
    public void insertBill(@PathVariable long tableId ,@RequestBody OrderInfo orderInfo){
        orderService.insertBills(tableId, orderInfo);
    }
}
