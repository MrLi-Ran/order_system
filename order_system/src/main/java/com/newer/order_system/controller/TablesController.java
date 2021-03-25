package com.newer.order_system.controller;

import com.newer.order_system.Exeception.TableIsNotOpen;
import com.newer.order_system.module.tables.service.TableService;
import com.newer.order_system.pojo.Product;
import com.newer.order_system.pojo.Table;
import com.newer.order_system.pojo.Table2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tables")
public class TablesController {

    @Autowired
    TableService tableService;

    /**
     * 获取所有桌台
     * @return
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
    public void deleteTable(@PathVariable Long tableId){
        tableService.deleteTable(tableId);
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

    @GetMapping("/{tableId}/products")
    public List<Product> findTableProducts(@PathVariable int tableId){
        return tableService.findTableProducts(tableId);
    }
}
