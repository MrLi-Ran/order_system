package com.newer.order_system.module.tables.service.impl;


import com.newer.order_system.Exeception.TableIsNotOpen;
import com.newer.order_system.mapper.TablesMapper;
import com.newer.order_system.module.tables.service.TableService;
import com.newer.order_system.pojo.Bill;
import com.newer.order_system.pojo.Product;
import com.newer.order_system.pojo.Table;
import com.newer.order_system.pojo.Table2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TableServiceImpl implements TableService {
    @Autowired
    TablesMapper tablesMapper;

    /**
     * 获取所有桌台
     * @return 桌台列表
     */
    @Override
    public List<Table> selectAll() {
        return tablesMapper.selectAll();
    }

    /**
     * 添加桌台
     * @param table 桌台对象
     */
    @Override
    public void insertTable(Table table) {
        tablesMapper.insertTable(table.getTitle());
    }

    /**
     * 更改桌台名
     * @param table 桌台实体
     */
    @Override
    public void updateTableName(Table table) {
        tablesMapper.updateTableName(table.getTitle(), table.getId());
    }

    /**
     * 删除桌台
     * @param id
     */
    @Override
    public void deleteTable(long id) {
        tablesMapper.deleteTable(id);
    }

    /**
     * 更换桌台（需要添加事务）
     * @param from 当前桌台
     * @param to 需要更换的桌台
     */
    @Override
    public String changeTable(long from, long to) throws TableIsNotOpen {
        Table tableFrom = tablesMapper.findByID(from);
        // 判断当前桌台是否开启
        if (tableFrom.getStatus().equals("OFF")){
            throw new TableIsNotOpen();
        }else{
            // 转移数据
            // 修改to桌台人数
            tablesMapper.updateTableNum(to, tableFrom.getNum());
            // 重置from桌台
            tablesMapper.tableOff(from);
            // 更改桌台-订单关系
            Bill bill = tablesMapper.findBillsByTableID(from);
            tablesMapper.updateTableAndBillRelationshipByBillId(bill.getId(), to);
            //打开to桌台
            tablesMapper.tableOn(to);
            return "转台成功";
        }
    }

    /**
     * 根据桌台ID查找当前桌台商品
     * @param tableId 当前桌台ID
     * @return
     */
    @Override
    public List<Product> findTableProducts(long tableId) {
        // 根据桌台id找到当前桌台的账单
        Bill bill = tablesMapper.findBillsByTableID(tableId);
        // 根据账单查找当前桌台的菜品
        return tablesMapper.findProductsByTableID(bill.getId());
    }
}
