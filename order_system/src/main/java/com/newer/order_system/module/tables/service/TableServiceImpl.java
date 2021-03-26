package com.newer.order_system.module.tables.service;


import com.newer.order_system.Exeception.TableIsNotOpen;
import com.newer.order_system.mapper.TablesMapper;
import com.newer.order_system.module.tables.service.TableService;
import com.newer.order_system.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    /**
     * 加菜操作
     * @param tableId 当前桌台ID
     * @param map 产品id和数量
     */
    @Override
    public void insertProduct(long tableId, HashMap<Long,Integer> map) {
        // 通过桌台找到账单id
        long billId = tablesMapper.findBillsByTableID(tableId).getId();
        List<Long> list = tablesMapper.findProductIds(billId);

        // 插入操作
        for (Map.Entry<Long, Integer> entry : map.entrySet()){
            long productID = entry.getKey();
            int count = entry.getValue();

            // 判断订单中是否已有插入的菜品，如果有则修改数量，如果没有则全部插入
            if (list.contains(productID)){
                // 修改商品数量
                tablesMapper.updateProductCount(productID, count);
            }else{
                tablesMapper.insertProduct(billId, productID, count);
            }
        }
    }

    /**
     * 退菜操作
     * @param tableId 桌台ID
     * @param productId 商品ID
     */
    @Override
    public void deleteProduct(long tableId, long productId) {
        long billId = tablesMapper.findBillsByTableID(tableId).getId();// 订单ID
        // 根据订单ID和商品ID删除当前桌台的该彩屏
        tablesMapper.deleteProduct(billId, productId);
    }
}
