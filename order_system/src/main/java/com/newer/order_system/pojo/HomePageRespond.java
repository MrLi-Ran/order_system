package com.newer.order_system.pojo;

import java.util.List;
import java.util.Objects;

public class HomePageRespond {
    private List<Table> tableList;
    private List<Product> productList;
    private List<Employee> employeeList;

    @Override
    public String toString() {
        return "HomePageRespond{" +
                "tableList=" + tableList +
                ", productList=" + productList +
                ", employeeList=" + employeeList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HomePageRespond that = (HomePageRespond) o;
        return Objects.equals(tableList, that.tableList) &&
                Objects.equals(productList, that.productList) &&
                Objects.equals(employeeList, that.employeeList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tableList, productList, employeeList);
    }

    public List<Table> getTableList() {
        return tableList;
    }

    public void setTableList(List<Table> tableList) {
        this.tableList = tableList;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
