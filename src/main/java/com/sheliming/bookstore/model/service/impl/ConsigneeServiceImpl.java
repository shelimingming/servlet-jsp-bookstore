package com.sheliming.bookstore.model.service.impl;

import com.sheliming.bookstore.model.dao.DaoFactory;
import com.sheliming.bookstore.model.dao.ICommonDao;
import com.sheliming.bookstore.model.entity.Consignee;
import com.sheliming.bookstore.model.service.ICommonService;

import java.util.List;

public class ConsigneeServiceImpl extends CommonServiceImpl<Consignee> {
    @Override
    public List<Consignee> findByCondition(String... conditions) {
        ICommonDao consigneeDao = DaoFactory.getDao("consignee");
        return consigneeDao.findByCondition();
    }

    @Override
    public int save(Consignee consignee) {
        ICommonDao consigneeDao = DaoFactory.getDao("consignee");
        return consigneeDao.save(consignee);
    }
}
