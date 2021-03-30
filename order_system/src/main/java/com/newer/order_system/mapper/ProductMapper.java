package com.newer.order_system.mapper;

import com.newer.order_system.pojo.Product;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author lxr
 * @date 2021/3/30
 */
@Repository
public interface ProductMapper {
    List<Product> findProductsByTableID(long billId);// 根据账单id找到当前账单的商品信息

    int findProductCount(@Param("id") long id,@Param("productId") long productID);// 根据桌台id和产品id查找当前订单产品数量

    List<Long> findProductIds(Long billId);// 根据账单id查找bills_detail表中的商品id集合

    Map<Long, Integer> findProductIdsAndCount(long billId);// 根据账单ID查询账单内商品Id和数量
}
