package com.sheliming.bookstore.web.controller;

import com.sheliming.bookstore.model.entity.Book;
import com.sheliming.bookstore.model.service.ServiceFactory;
import com.sheliming.bookstore.model.service.impl.Cart;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/do/cart")
public class CartServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String _id = (String) req.getParameter("id");
        int id = Integer.parseInt(_id);
        Book book = (Book) ServiceFactory.getService("book").findById(id);
        System.out.println("book:" + book);

        Cart cart = getCart(req);

        String op = (String) req.getParameter("op");

        if ("add".equals(op)) {
            cart.addBook(book);
            //req.getSession().setAttribute("cart", cart);
        } else if ("del".equals(op)) {
            cart.delete(id);
        }
        System.out.println("cart:" + cart);

        String url = req.getHeader("referer");
        System.out.println("url:" + url);
        resp.sendRedirect(url);
    }

    private Cart getCart(HttpServletRequest req) {
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        if (null == cart) {
            cart = new Cart();
            req.getSession().setAttribute("cart", cart);
        }

        return cart;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
