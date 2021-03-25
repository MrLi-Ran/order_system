package com.newer.order_system.module.tables.service.impl;


import com.newer.order_system.mapper.TablesMapper;
import com.newer.order_system.module.tables.service.TableService;
import com.newer.order_system.pojo.Bill;
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
     * 更换桌台
     * @param from 被更换的台
     * @param to 需要更换的台
     */
  /*  @Override
    public void changeTable(Table1 from, Long to) {
        // 1、传输数据

        // 2、重置桌台

    }*/

    @Override
    public void changeTable(long from, long to) {
        // 转移数据
        Table tableFrom = tablesMapper.findByID(from);
        Table tableTo = tablesMapper.findByID(to);
        tableTo.setNum(tableFrom.getNum());
        // 重置from桌台
        tablesMapper.tableOff(from);
        // 更改桌台-订单关系
        Bill bill = tablesMapper.findBillsByTableID(from);
        tablesMapper.updateTableAndBillRelationshipByBillId(bill.getId(), to);
        //打开to桌台
        tablesMapper.tableOn(to);

    }
}
