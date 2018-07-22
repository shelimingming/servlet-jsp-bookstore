package com.sheliming.bookstore.model.service.impl;

import com.sheliming.bookstore.model.dao.DaoFactory;
import com.sheliming.bookstore.model.entity.Account;
import com.sheliming.bookstore.model.entity.Consignee;
import com.sheliming.bookstore.model.service.ServiceFactory;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;

public class AccountServiceImpl extends CommonServiceImpl<Account> {
    /**
     * 登录
     * 0：成功
     * 1：用户名不存在
     * 2：用户名密码不匹配
     *
     * @param username
     * @param password
     * @return
     */
    public int login(String username, String password) {
        List<Account> accountList = DaoFactory.getDao("account").findByCondition(username);
        if (CollectionUtils.isNotEmpty(accountList)) {
            Account account = accountList.get(0);
            if (null == password && !password.equals(account.getPassword())) {
                return 2;
            } else {
                return 0;
            }
        } else {
            return 1;
        }
    }

    public int register(Account account) {
        return DaoFactory.getDao("account").save(account);
    }

    @Override
    public List<Account> findByCondition(String... conditions) {
        List<Account> accountList = DaoFactory.getDao("account").findByCondition(conditions);
        for (Account account : accountList) {
            List<Consignee> consigneeList = DaoFactory.getDao("consignee").findByCondition(account.getId() + "");
            account.setConsigneeList(consigneeList);
        }
        return accountList;
    }
}
