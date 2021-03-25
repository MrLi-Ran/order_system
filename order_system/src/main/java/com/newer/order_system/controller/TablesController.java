package com.newer.order_system.controller;

import com.newer.order_system.module.tables.service.TableService;
import com.newer.order_system.pojo.Table;
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
    public void updateTableName(@PathVariable Long id,@RequestBody Table table){
        table.setId(id);
        tableService.updateTableName(table);
    }

    /**
     * 删除桌台
     * @param id 桌台id
     */
    @DeleteMapping("/{id}")
    public void deleteTable(@PathVariable Long id){
        tableService.deleteTable(id);
    }

    @PutMapping("/")
    public void changeTable(){

    }
}
