package com.newer.order_system.module.order;

import com.newer.order_system.pojo.Bill;
import com.newer.order_system.pojo.OrderInfo;
import com.newer.order_system.pojo.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

    // 获取所有商品
//    List<Product> selectAll();

    // 修改桌台状态
    String tableOn(long id, int num);

    void insertBills(long tableId, OrderInfo orderInfo);
}
