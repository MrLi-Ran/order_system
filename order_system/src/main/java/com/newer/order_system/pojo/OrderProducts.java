package com.newer.order_system.pojo;

import java.util.Objects;

/**
 * @author lxr
 * @date 2021/3/30
 */
public class OrderProducts {
    private long productId;
    private String productName;
    private int count;

    @Override
    public String toString() {
        return "OrderProducts{" +
                "product=" + productId +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderProducts that = (OrderProducts) o;
        return count == that.count &&
                Objects.equals(productId, that.productId);
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}