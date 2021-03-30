package com.newer.order_system.module.bills;

import com.newer.order_system.pojo.Bill;

import java.util.List;

public interface BillsService {
    // 将已完成的订单存入mongodb
    void save(Bill bill);

    List<Bill> findAll();
}
