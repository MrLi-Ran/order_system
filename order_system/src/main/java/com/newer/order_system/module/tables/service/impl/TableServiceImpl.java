package com.newer.order_system.module.tables.service.impl;

import com.newer.order_system.mapper.TablesMapper;
import com.newer.order_system.module.tables.service.TableService;
import com.newer.order_system.pojo.Table;
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
     * 修改桌台名
     */
    @Override
    public void updateTableName(Table table) {
        tablesMapper.updateTableName(table.getTitle(), table.getId());
    }
}
