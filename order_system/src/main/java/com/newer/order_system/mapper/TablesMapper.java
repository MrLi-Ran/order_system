package com.newer.order_system.mapper;

import com.newer.order_system.pojo.Table;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TablesMapper {
    List<Table> selectAll();

    void insertTable(String title);

    void updateTableName(@Param("title") String title,@Param("id") Long id);
}
