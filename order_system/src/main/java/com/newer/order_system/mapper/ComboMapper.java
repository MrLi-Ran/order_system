package com.newer.order_system.mapper;

import com.newer.order_system.pojo.Combo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ComboMapper {

    List<Combo> findAll();

    Combo findOne (Integer id);

    void addCombo(@Param("name")String name,
                  @Param("price")BigDecimal price,
                  @Param("details") String status);

    void update(@Param("id") Integer id,
                @Param("name")String name,
                @Param("price")BigDecimal price,
                @Param("details")String details,
                @Param("status")String status);

    void delete(Integer id);
}
