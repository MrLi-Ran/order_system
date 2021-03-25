package com.newer.order_system.pojo;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {
    private long id;// 商品id
    private String title;// 商品名
    private BigDecimal price;// 价格
    private int sales;// 销量
    private String status;// 上下架
    private int repertory;// 库存

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id &&
                sales == product.sales &&
                repertory == product.repertory &&
                Objects.equals(title, product.title) &&
                Objects.equals(price, product.price) &&
                Objects.equals(status, product.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, price, sales, status, repertory);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", sales=" + sales +
                ", status='" + status + '\'' +
                ", count=" + repertory +
                '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCount() {
        return repertory;
    }

    public void setCount(int count) {
        this.repertory = count;
    }
}
