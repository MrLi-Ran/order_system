package com.newer.order_system.pojo;

import java.util.Objects;

public class BillsDetail {
    private long id;
    private long billId;
    private long productId;
    private int count;

    @Override
    public String toString() {
        return "BillsDetail{" +
                "id=" + id +
                ", billId=" + billId +
                ", productId=" + productId +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BillsDetail that = (BillsDetail) o;
        return id == that.id &&
                billId == that.billId &&
                productId == that.productId &&
                count == that.count;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, billId, productId, count);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBillId() {
        return billId;
    }

    public void setBillId(long billId) {
        this.billId = billId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
