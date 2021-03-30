package com.newer.order_system.mapper;

import com.newer.order_system.pojo.BillsDetail;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author lxr
 * @date 2021/3/30
 */
@Repository
public interface DetailMapper {
    void insertBillDetail(BillsDetail billsDetail);// 添加订单商品项

    void updateProductCount(@Param("productId") long productId, @Param("count") int count);// 修改菜品数据

    void insertProduct(// 添加账单-商品关系表数据，进行加菜操作
                       @Param("billId") long billId,
                       @Param("productId") long productId,
                       @Param("count") long count );

    void deleteProduct(@Param("billId") long billId,@Param("productId") long productId);// 删除商品
}
