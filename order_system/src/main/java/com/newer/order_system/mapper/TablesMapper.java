package com.newer.order_system.mapper;

import com.newer.order_system.pojo.Bill;
import com.newer.order_system.pojo.Product;
import com.newer.order_system.pojo.Table;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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




















}
