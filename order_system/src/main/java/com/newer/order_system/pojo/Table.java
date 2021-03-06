package com.newer.order_system.pojo;

import java.util.Objects;

public class Table {
    private long id;
    private String title;
    private int num;
    private String status;

    @Override
    public String toString() {
        return "Table1{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", num=" + num +
                ", status='" + status + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return id == table.id &&
                num == table.num &&
                Objects.equals(title, table.title) &&
                Objects.equals(status, table.status);
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
