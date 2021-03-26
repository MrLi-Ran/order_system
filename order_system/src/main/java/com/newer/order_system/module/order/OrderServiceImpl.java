package com.newer.order_system.module.order;

import com.newer.order_system.mapper.OrderMapper;
import com.newer.order_system.mapper.TablesMapper;
import com.newer.order_system.pojo.Bill;
import com.newer.order_system.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderMapper orderMapper;

//    @Override
//    public List<Product> selectAll() {
//        return orderMapper.selectAll();
//    }

    @Override
    public String updateTableStatus(long id) {
        // 判断当前桌台是否为空
        if(orderMapper.findByID(id).getStatus().equals("ON")){
            System.out.println("当前桌台有客");
        }
        orderMapper.updateTableStatus(id);
        return "开台成功";
    }

    @Override
    public void insertBill(Bill bill) {
        orderMapper.insertBill(bill);
    }


}
