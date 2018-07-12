package com.sheliming.bookstore.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class WebContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("WebContextListener.contextInitialized");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
