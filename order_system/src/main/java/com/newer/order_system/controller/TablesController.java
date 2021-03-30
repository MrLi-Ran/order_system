package com.newer.order_system.controller;

import com.newer.order_system.Exeception.TableIsNotOpen;
import com.newer.order_system.module.tables.PayService;
import com.newer.order_system.module.tables.TableService;
import com.newer.order_system.pojo.AddProduct;
import com.newer.order_system.pojo.OrderProducts;
import com.newer.order_system.pojo.Product;
import com.newer.order_system.pojo.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/tables")
public class TablesController {

    @Autowired
    TableService tableService;

    @Autowired
    PayService payService;

    // 接受json数组参数
    @Autowired
    AddProduct addProduct;

    /**
     * 获取所有桌台
     * @return 桌台集合
     */
    @GetMapping
    public List<Table> selectAll(){
        return tableService.selectAll();
    }

    /**
     * 添加桌台
     */
    @PostMapping
    public String insertTable(@RequestBody Table table){
        tableService.insertTable(table);
        return "添加成功";
    }

    /**
     * 修改桌台名
     * @param table 桌台实体
     */
    @PutMapping("/{id}")
    public void updateTableName(@RequestBody Table table){
        tableService.updateTableName(table);
    }

    /**
     * 删除桌台
     * @param tableId 桌台id
     */
    @DeleteMapping("/{tableId}")
    public String deleteTable(@PathVariable Long tableId){
        return tableService.deleteTable(tableId);
    }

    /**
     * 更换桌台
     * @param from 当前桌台的实体
     * @param to 更换桌台的id
     */
    @PutMapping("/{from}/table/{to}")
    public String changeTable(@PathVariable long from, @PathVariable long to){
        try {
            return tableService.changeTable(from, to);
        } catch (TableIsNotOpen tableIsNotOpen) {
            return "当前桌台未开启";
        }
    }

    /**
     * 显示当前桌台商品和数量
     * @param tableId 桌台ID
     * @return 商品列表
     */
    @GetMapping("/{tableId}/products")
    public List<OrderProducts> findTableProducts(@PathVariable int tableId){
        return tableService.findTableProducts(tableId);
    }

    /**
     * 加菜
     * @param tableId 当前桌台ID
     * @param list 插入的商品集合
     */
    @PostMapping("/{tableId}/products")
    public String insertProduct(@PathVariable long tableId,@RequestBody List<OrderProducts> list){
        HashMap<Long, Integer> map = new HashMap<>();
        for (OrderProducts item : list){
            map.put(item.getProductId(), item.getCount());
        }
        tableService.insertProduct(tableId, map);
        return "加菜成功";
    }

    /**
     * 退菜
     * @param tableId 桌台ID
     * @param productId 产品ID
     */
    @DeleteMapping("/{tableId}/product/{productId}")
    public void deleteProduct(@PathVariable long tableId, @PathVariable long productId){
        tableService.deleteProduct(tableId, productId);
    }

    /**
     * 判断是否为会员
     * @param telPhone 电话
     * @return
     */
    @GetMapping("/{id}/member/{telPhone}")
    @Transactional
    public void isMember(
            @PathVariable long id,
            @PathVariable String telPhone){
        payService.isMember(id, telPhone);
    }

}

