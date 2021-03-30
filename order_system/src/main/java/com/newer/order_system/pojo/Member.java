package com.newer.order_system.pojo;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author lxr
 * @date 2021/3/30
 */
public class Member {
    private long id;
    private String name;
    private String telPhone;
    private BigDecimal account;
    private BigDecimal totalMoney;
    private String level;

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", telPhone='" + telPhone + '\'' +
                ", account=" + account +
                ", totalMoney=" + totalMoney +
                ", level='" + level + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return id == member.id &&
                Objects.equals(name, member.name) &&
                Objects.equals(telPhone, member.telPhone) &&
                Objects.equals(account, member.account) &&
                Objects.equals(totalMoney, member.totalMoney) &&
                Objects.equals(level, member.level);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, telPhone, account, totalMoney, level);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelPhone() {
        return telPhone;
    }

    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone;
    }

    public BigDecimal getAccount() {
        return account;
    }

    public void setAccount(BigDecimal account) {
        this.account = account;
    }

    public BigDecimal getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(BigDecimal totalMoney) {
        this.totalMoney = totalMoney;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }
}
