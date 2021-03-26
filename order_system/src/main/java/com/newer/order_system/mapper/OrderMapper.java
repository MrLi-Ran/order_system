package com.newer.order_system.mapper;

import com.newer.order_system.pojo.Bill;
import com.newer.order_system.pojo.Product;
import com.newer.order_system.pojo.Table;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    Table findByID(long id);// 根据ID查找桌台

    void updateTableStatus(long id);// 修改桌台状态

    void insertBill(Bill bill);// 添加订单


}
