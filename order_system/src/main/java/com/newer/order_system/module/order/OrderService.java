package com.newer.order_system.module.order;

import com.newer.order_system.pojo.Bill;
import com.newer.order_system.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    // 获取所有商品
//    List<Product> selectAll();

    // 修改桌台状态
    String updateTableStatus(long id);

    // 添加账单
    void insertBill(Bill bill);
}
