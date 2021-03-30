package com.newer.order_system.module.tables;

import com.newer.order_system.mapper.BillMapper;
import com.newer.order_system.mapper.MemberMapper;
import com.newer.order_system.mapper.TablesMapper;
import com.newer.order_system.pojo.Bill;
import com.newer.order_system.pojo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author lxr
 * @date 2021/3/30
 */
@Repository
public class PayServiceImpl implements PayService{
    @Autowired
    TablesMapper tablesMapper;
    @Autowired
    MemberMapper memberMapper;
    @Autowired
    BillMapper billMapper;

    @Override
    public String pay(String telPhone) {
        return null;
    }

    @Override
    public void isMember(long tableId, String telPhone) {
        Member member = memberMapper.findByTelPhone(telPhone);
        System.out.println(member);
        if (member != null){
            // 将会员id插入Bills
            Bill bill = billMapper.findBillsByTableID(tableId);
        }
        System.out.println("会员不存在");
    }

    @Override
    public void updateBillStatus(long billId) {
        billMapper.updateBillStatus(billId);
    }
}
