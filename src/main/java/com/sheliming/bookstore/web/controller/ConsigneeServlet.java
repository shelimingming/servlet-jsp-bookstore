package com.sheliming.bookstore.web.controller;

import com.sheliming.bookstore.model.entity.Account;
import com.sheliming.bookstore.model.entity.Consignee;
import com.sheliming.bookstore.model.service.ServiceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/do/consignee")
public class ConsigneeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Account account = (Account) req.getSession().getAttribute("account");

        String tel = req.getParameter("tel");
        String address = req.getParameter("address");

        Consignee consignee = new Consignee();
        consignee.setAccountId(account.getId());
        consignee.setTel(tel);
        consignee.setAddress(address);

        int res = ServiceFactory.getService("consignee").save(consignee);

        if (res > 0) {
            account.getConsigneeList().add(consignee);
        }
        resp.sendRedirect(getServletContext().getContextPath() + "/page/manage.jsp?contentPage=order.jsp");

    }
}
