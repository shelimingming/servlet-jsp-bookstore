package com.sheliming.bookstore.model.entity;

import java.io.Serializable;
import java.util.List;

public class Account implements Serializable {
    private Integer id;
    private String username;
    private String password;
    private String email;

    private List<Consignee> consigneeList;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Consignee> getConsigneeList() {
        return consigneeList;
    }

    public void setConsigneeList(List<Consignee> consigneeList) {
        this.consigneeList = consigneeList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
