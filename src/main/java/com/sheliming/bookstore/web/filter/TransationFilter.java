package com.sheliming.bookstore.web.filter;


import com.sheliming.bookstore.commons.TransationManager;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

//@WebFilter("/do/*")
public class TransationFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            TransationManager.begin();

            filterChain.doFilter(servletRequest, servletResponse);

            TransationManager.commit();
        } catch (Exception e) {
            TransationManager.rollback();
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
