package com.newer.order_system.pojo;

import com.newer.order_system.Enum.TableStatus;

import java.util.Objects;

public class Table2 {
    private long id;
    private String title;
    private int num;
    private Enum<TableStatus> status;

    public Table2() {
    }

    @Override
    public String toString() {
        return "Table1{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", num=" + num +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table2 table2 = (Table2) o;
        return id == table2.id &&
                num == table2.num &&
                Objects.equals(title, table2.title) &&
                Objects.equals(status, table2.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, num, status);
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Enum<TableStatus> getStatus() {
        return status;
    }

    public void setStatus(Enum<TableStatus> status) {
        this.status = status;
    }
}
