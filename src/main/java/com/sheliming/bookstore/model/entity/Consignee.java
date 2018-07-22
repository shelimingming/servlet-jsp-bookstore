package com.sheliming.bookstore.model.entity;

import java.io.Serializable;

/**
 * 收货人实体类
 */
public class Consignee implements Serializable {
    private Integer id;
    private Integer accountId;
    private String tel;
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Consignee{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", tel='" + tel + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
