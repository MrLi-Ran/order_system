package com.newer.order_system.module.tables;


import com.newer.order_system.Exeception.TableIsNotOpen;
import com.newer.order_system.mapper.DetailMapper;
import com.newer.order_system.mapper.BillMapper;
import com.newer.order_system.mapper.ProductMapper;
import com.newer.order_system.mapper.TablesMapper;
import com.newer.order_system.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TableServiceImpl implements TableService {
    @Autowired
    TablesMapper tablesMapper;
    @Autowired
    BillMapper billMapper;
    @Autowired
    DetailMapper detailMapper;
    @Autowired
    ProductMapper productMapper;

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
    @Transactional
    public String deleteTable(long id) {
        tablesMapper.deleteTable(id);
        return "删除成功";
    }

    /**
     * 更换桌台（需要添加事务）
     * @param from 当前桌台
     * @param to 需要更换的桌台
     */
    @Override
    @Transactional
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
            Bill bill = billMapper.findBillsByTableID(from);
            System.out.println("bill:"+bill);
            billMapper.updateTableAndBillRelationshipByBillId(bill.getId(), to);
            //打开to桌台
            tablesMapper.tableOn(to);
            return "转台成功";
        }
    }

    /**
     * 根据桌台ID查找当前桌台商品和数量
     * @param tableId 当前桌台ID
     * @return
     */
    @Override
    public List<OrderProducts> findTableProducts(long tableId) {
        // 获取当前桌台账单
        Bill bill = billMapper.findBillsByTableID(tableId);
        // 根据账单查找当前桌台的菜品
        List<Product> list = productMapper.findProductsByTableID(bill.getId());
        List<OrderProducts> list1 = new ArrayList<>();
        for (Product item:list){
            long productID = item.getId();
            String productName = item.getTitle();
            // 根据桌台Id查询当前桌台的订单
            long billId = billMapper.findBillsByTableID(tableId).getId();
            // 根据订单ID和产品ID 查询产品在当前桌台的数量
            int count = productMapper.findProductCount(billId, productID);
            OrderProducts products = new OrderProducts();
            products.setProductId(productID);
            products.setProductName(productName);
            products.setCount(count);
            list1.add(products);
        }
        return list1;
    }

    /**
     * 加菜操作
     * @param tableId 当前桌台ID
     * @param map 产品id和数量
     */
    @Override
    public void insertProduct(long tableId, HashMap<Long,Integer> map) {
        // 获取当前桌台账单
        long billId = billMapper.findBillsByTableID(tableId).getId();
        List<Long> list = productMapper.findProductIds(billId);

        // 插入操作
        for (Map.Entry<Long, Integer> entry : map.entrySet()){
            long productID = entry.getKey();
            int count = entry.getValue();

            // 判断订单中是否已有插入的菜品，如果有则修改数量，如果没有则全部插入
            if (list.contains(productID)){
                // 添加商品数量
                detailMapper.updateProductCount(productID, count);
            }else{
                detailMapper.insertProduct(billId, productID, count);
            }
        }
    }

    /**
     * 退菜操作
     * @param tableId 桌台ID
     * @param productId 需要退的菜品Id
     */
    @Override
    public void deleteProduct(long tableId, long productId) {
        // 获取当前桌台账单
        long billId = billMapper.findBillsByTableID(tableId).getId();
        detailMapper.deleteProduct(billId, productId);
    }
}
