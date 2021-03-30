package com.newer.order_system.module.order;

import com.newer.order_system.mapper.BillMapper;
import com.newer.order_system.mapper.DetailMapper;
import com.newer.order_system.mapper.OrderMapper;
import com.newer.order_system.mapper.TablesMapper;
import com.newer.order_system.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService{

    @Autowired
    OrderMapper orderMapper;
    @Autowired
    TablesMapper tablesMapper;
    @Autowired
    DetailMapper detailMapper;
    @Autowired
    BillMapper billMapper;

    @Override
    @Transactional
    public String tableOn(long id, int num) {
        // 判断当前桌台是否为空
        if(orderMapper.findByID(id).getStatus().equals("ON")){
            return "当前桌台使用中";
        }
        // 更新桌台状态
        orderMapper.updateTableStatus(id);
        orderMapper.updateTablesNum(id, num);
        return "开台成功";
    }

    /**
     *
     * @param tableId 桌台ID
     * @param orderInfo 桌台订单信息汇总
     */
    @Override
    @Transactional
    public void insertBills(long tableId, OrderInfo orderInfo) {

        // 订单信息
        List<OrderProducts> list = orderInfo.getProductsList();
        Bill bill = orderInfo.getBill();
        bill.setTableId(tableId);
        // 将订单基本信息插入Bills表格
        billMapper.insertBill(bill);
        long id = billMapper.findBillsByTableID(tableId).getId();


        // 将商品信息插入Bills_Detail表格（billId, productID, count）
        for (OrderProducts item : list){
            long productId = item.getProductId();
            int count = item.getCount();
            BillsDetail billsDetail = new BillsDetail();
            billsDetail.setBillId(id);
            billsDetail.setProductId(productId);
            billsDetail.setCount(count);
            detailMapper.insertBillDetail(billsDetail);
        }
    }


}
