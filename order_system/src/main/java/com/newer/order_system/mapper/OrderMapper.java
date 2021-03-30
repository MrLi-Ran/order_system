package com.newer.order_system.mapper;

import com.newer.order_system.pojo.Bill;
import com.newer.order_system.pojo.Product;
import com.newer.order_system.pojo.Table;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    Table findByID(long id);// 根据ID查找桌台

    void updateTableStatus(long id);// 修改桌台状态

    void updateTablesNum(@Param("id") long id,@Param("num") int num);//  添加桌台人数
}
