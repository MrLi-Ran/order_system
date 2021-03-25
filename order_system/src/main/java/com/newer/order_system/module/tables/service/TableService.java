package com.newer.order_system.module.tables.service;

import com.newer.order_system.pojo.Table;
import com.newer.order_system.pojo.Table2;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TableService {

    List<Table> selectAll();

    void insertTable(Table table);

    void updateTableName(Table table);

    void deleteTable(long id);

    void changeTable(long from, long to);
}
