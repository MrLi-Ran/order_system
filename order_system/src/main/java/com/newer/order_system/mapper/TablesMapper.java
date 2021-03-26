package com.newer.order_system.mapper;

import com.newer.order_system.pojo.Bill;
import com.newer.order_system.pojo.Product;
import com.newer.order_system.pojo.Table;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;


@Repository
public interface TablesMapper {
    List<Table> selectAll();// 查找所有桌台

    Table findByID(long id);// 根据ID查找桌套

    void insertTable(String title);// 添加桌台

    void updateTableName(// 修改桌台名
            @Param("title") String title,
            @Param("id") Long id);

    void updateTableNum(// 修改桌台人数
            @Param("id") long id,
            @Param("num") int num);

    void tableOff(long id);// 关闭桌台

    void tableOn(long id);// 开启桌台

    void deleteTable(Long id);// 删除桌台

    Bill findBillsByTableID(@Param("tableId") long tableId);// 根据桌台id查找当前桌台订单信息

    void updateTableAndBillRelationshipByBillId(// 根据订单id更改桌台订单关系
                @Param("billId")long billId,
                @Param("tableId") long tableId);

    List<Product> findProductsByTableID(long billId);// 根据账单id找到当前账单的商品信息

    List<Long> findProductIds(Long billId);// 根据账单id查找bills_detail表中的商品id集合

    void insertProduct(// 添加账单-商品关系表数据，进行加菜操作
            @Param("billId") long billId,
            @Param("productId") long productId,
            @Param("count") long count );

    void updateProductCount(@Param("productId") long productId,@Param("count") int count);
}
