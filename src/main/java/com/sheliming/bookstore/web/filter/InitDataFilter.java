package com.sheliming.bookstore.web.filter;

import com.sheliming.bookstore.model.entity.Book;
import com.sheliming.bookstore.model.service.ServiceFactory;
import com.sheliming.bookstore.model.service.impl.BookServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.util.List;

@WebFilter("/index.jsp")
public class InitDataFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        BookServiceImpl bookService = (BookServiceImpl) ServiceFactory.getService("book");
        List<Book> bookList = bookService.findAll();
        servletRequest.setAttribute("bookList", bookList);
        System.out.println("初始化数据成功");
        System.out.println(bookList);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
