package com.newer.order_system.pojo;

public class Table {
    private Long id;
    private String title;
    private int num;
    private String status;



    @Override
    public String toString() {
        return "Tables{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", num=" + num +
                ", status='" + status + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
