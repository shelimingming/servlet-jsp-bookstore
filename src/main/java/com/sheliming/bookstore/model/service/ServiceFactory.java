package com.sheliming.bookstore.model.service;

import com.sheliming.bookstore.model.dao.ICommonDao;
import com.sheliming.bookstore.model.dao.impl.BookDaoImpl;
import com.sheliming.bookstore.model.service.impl.AccountServiceImpl;
import com.sheliming.bookstore.model.service.impl.BookServiceImpl;
import com.sheliming.bookstore.model.service.impl.ConsigneeServiceImpl;

import java.util.WeakHashMap;

public class ServiceFactory {
    private final static WeakHashMap<String, ICommonService> map = new WeakHashMap<>();

    public static ICommonService getService(String name) {
        ICommonService service = map.get(name);
        if (service != null) {
            return service;
        } else {
            return createService(name);
        }
    }

    private static ICommonService createService(String name) {

        ICommonService service = null;
        if ("book".equals(name)) {
            service = new BookServiceImpl();
        } else if ("account".equals(name)) {
            service = new AccountServiceImpl();
        } else if ("consignee".equals(name)) {
            service = new ConsigneeServiceImpl();
        }
        return service;
    }
}
