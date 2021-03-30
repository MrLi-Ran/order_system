package com.newer.order_system.mapper;

import com.newer.order_system.pojo.Bill;
import com.newer.order_system.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lxr
 * @date 2021/3/30
 */
@Repository
public interface BillMapper {
    void insertBill(Bill bill);// 添加订单

    void updateBillStatus(long id);// 修改订单状态

    void updateTableAndBillRelationshipByBillId(// 根据订单id更改桌台订单关系
                                                @Param("billId")long billId,
                                                @Param("tableId") long tableId);

    Bill findBillsByTableID(@Param("tableId") long tableId);// 根据桌台id查找当前桌台订单信息


}
