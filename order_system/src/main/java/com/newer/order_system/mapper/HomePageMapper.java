package com.newer.order_system.mapper;

import com.newer.order_system.pojo.Employee;
import com.newer.order_system.pojo.Product;
import com.newer.order_system.pojo.Table;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomePageMapper {

    List<Table> selectAllTable();

    List<Product> selectAllProduct();

    List<Employee> selectAllEmployee();

}
