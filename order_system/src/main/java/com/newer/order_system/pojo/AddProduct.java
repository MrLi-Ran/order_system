package com.newer.order_system.pojo;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

/**
 * 该类用来接收前端传递的json数据
 */
@Component
public class AddProduct {
    private Integer count;
    private long productId;

    @Override
    public String toString() {
        return "AddProduct{" +
                "count=" + count +
                ", productId=" + productId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AddProduct that = (AddProduct) o;
        return count == that.count &&
                productId == that.productId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, productId);
    }

    public int getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
