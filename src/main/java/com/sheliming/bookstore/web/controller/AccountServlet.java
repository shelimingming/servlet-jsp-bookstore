package com.sheliming.bookstore.web.controller;

import com.sheliming.bookstore.model.entity.Account;
import com.sheliming.bookstore.model.service.ServiceFactory;
import com.sheliming.bookstore.model.service.impl.AccountServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/do/account")
public class AccountServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String op = req.getParameter("op");

        if ("login".equals(op)) {
            login(req, resp);
        } else if ("register".equals(op)) {
            register(req, resp);
        } else if ("logout".equals(op)) {
            logout(req, resp);
        }


    }

    private void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.getSession().removeAttribute("account");
        resp.sendRedirect(getServletContext().getContextPath() + "/page/loginAndRegister.jsp");
    }

    private void register(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");

        Account account = new Account();
        account.setUsername(username);
        account.setPassword(password);
        account.setEmail(email);

        AccountServiceImpl accountService = (AccountServiceImpl) ServiceFactory.getService("account");
        int res = accountService.register(account);

        if (1 == res) {
            req.getSession().setAttribute("account", account);

            resp.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
        } else {
            req.setAttribute("register_error", "注册失败");
            resp.sendRedirect(getServletContext().getContextPath() + "/page/loginAndRegister.jsp");
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        AccountServiceImpl accountService = (AccountServiceImpl) ServiceFactory.getService("account");
        int res = accountService.login(username, password);
        System.out.println("res:" + res);

        if (0 == res) {
            Account account = accountService.findByCondition(username).get(0);
            req.getSession().setAttribute("account", account);

            resp.sendRedirect(getServletContext().getContextPath() + "/index.jsp");
        } else if (1 == res) {
            req.setAttribute("login_error", "用户名不存在");
            resp.sendRedirect(getServletContext().getContextPath() + "/page/loginAndRegister.jsp");
        } else {
            req.setAttribute("login_error", "用户名密码不匹配");
            resp.sendRedirect(getServletContext().getContextPath() + "/page/loginAndRegister.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
