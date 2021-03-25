package com.newer.order_system.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

public class Bill {
    private long id;// id
    private Date create;// 订单创建时间
    private Date complete;// 订单完成时间
    private BigDecimal money;// 订单金额
    private BigDecimal actualMoney;// 订单实付金额
    private String status;// 订单状态
    private String kind;// 订单种类
    private long employeeId;// 操作订单员工
    private long memberId;// 会员ID
    private long tableId;// 桌台ID

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", create=" + create +
                ", complete=" + complete +
                ", money=" + money +
                ", actualMoney=" + actualMoney +
                ", status='" + status + '\'' +
                ", kind='" + kind + '\'' +
                ", employeeId=" + employeeId +
                ", memberId=" + memberId +
                ", tableId=" + tableId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bill bill = (Bill) o;
        return id == bill.id &&
                employeeId == bill.employeeId &&
                memberId == bill.memberId &&
                tableId == bill.tableId &&
                Objects.equals(create, bill.create) &&
                Objects.equals(complete, bill.complete) &&
                Objects.equals(money, bill.money) &&
                Objects.equals(actualMoney, bill.actualMoney) &&
                Objects.equals(status, bill.status) &&
                Objects.equals(kind, bill.kind);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, create, complete, money, actualMoney, status, kind, employeeId, memberId, tableId);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreate() {
        return create;
    }

    public void setCreate(Date create) {
        this.create = create;
    }

    public Date getComplete() {
        return complete;
    }

    public void setComplete(Date complete) {
        this.complete = complete;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public BigDecimal getActualMoney() {
        return actualMoney;
    }

    public void setActualMoney(BigDecimal actualMoney) {
        this.actualMoney = actualMoney;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getMemberId() {
        return memberId;
    }

    public void setMemberId(long memberId) {
        this.memberId = memberId;
    }

    public long getTableId() {
        return tableId;
    }

    public void setTableId(long tableId) {
        this.tableId = tableId;
    }
}
