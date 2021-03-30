package com.newer.order_system.module.tables;

import com.newer.order_system.Exeception.TableIsNotOpen;
import com.newer.order_system.pojo.AddProduct;
import com.newer.order_system.pojo.OrderProducts;
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

    String deleteTable(long id);

    String changeTable(long from, long to) throws TableIsNotOpen;

    List<OrderProducts> findTableProducts(long tableId);

    void insertProduct(long tableId, HashMap<Long,Integer> map);

    void deleteProduct(long tableId, long productId);
}
