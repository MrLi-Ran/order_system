package com.newer.order_system.module.tables;

import org.springframework.stereotype.Repository;

/**
 * @author lxr
 * @date 2021/3/30
 */
@Repository
public interface PayService {
    // 进行支付操作
    String pay(String telPhone);

    // 判断是否为会员
    void isMember(long tableId,String telPhone);


    // 选择支付方式
    // 显示订单信息
    // 确认支付
    // 修改库存、修改订单状态
    // 修改订单状态
    void updateBillStatus(long billId);
}
