package com.newer.order_system.pojo;

import java.util.List;
import java.util.Objects;

/**
 * @author lxr
 * @date 2021/3/30
 */
public class OrderInfo {
    private Bill bill;
    private List<OrderProducts> productsList;

    @Override
    public String toString() {
        return "OrderInfo{" +
                "bill=" + bill +
                ", productsList=" + productsList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderInfo orderInfo = (OrderInfo) o;
        return Objects.equals(bill, orderInfo.bill) &&
                Objects.equals(productsList, orderInfo.productsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bill, productsList);
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public List<OrderProducts> getProductsList() {
        return productsList;
    }

    public void setProductsList(List<OrderProducts> productsList) {
        this.productsList = productsList;
    }
}
