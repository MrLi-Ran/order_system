package com.newer.order_system.module.tables.service;

import com.newer.order_system.Exeception.TableIsNotOpen;
import com.newer.order_system.pojo.AddProduct;
import com.newer.order_system.pojo.Product;
import com.newer.order_system.pojo.Table;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface TableService {

    List<Table> selectAll();

    void insertTable(Table table);

    void updateTableName(Table table);

    void deleteTable(long id);

    String changeTable(long from, long to) throws TableIsNotOpen;

    List<Product> findTableProducts(long tableId);

    void insertProduct(long tableId, HashMap<Long,Integer> map);

    void deleteProduct(long tableId, long productId);
}
