package com.newer.order_system.module.home;

import com.newer.order_system.mapper.HomePageMapper;
import com.newer.order_system.pojo.Employee;
import com.newer.order_system.pojo.HomePageRespond;
import com.newer.order_system.pojo.Product;
import com.newer.order_system.pojo.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomePageServiceImpl implements HomePageService {
    @Autowired
    HomePageMapper homePageMapper;

    @Override
    public HomePageRespond selectAll() {
        List<Table> tableList = homePageMapper.selectAllTable();
        List<Product> productList = homePageMapper.selectAllProduct();
        List<Employee> employeeList = homePageMapper.selectAllEmployee();
        HomePageRespond respond = new HomePageRespond();
        respond.setTableList(tableList);
        respond.setProductList(productList);
        respond.setEmployeeList(employeeList);
        return respond;
    }
}
