package com.newer.order_system.pojo;

import java.math.BigDecimal;

/**
 * 套餐表
 */
public class Combo {
    //套餐编号
    int id;

    //套餐名
    String name;

    //套餐价格
    BigDecimal price;

    //套餐详情
    String details;

    //套餐状态
    String status;


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDetails() {
        return details;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "Combo{" +
                "id=" + id +
                ", price=" + price +
                ", details='" + details + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
