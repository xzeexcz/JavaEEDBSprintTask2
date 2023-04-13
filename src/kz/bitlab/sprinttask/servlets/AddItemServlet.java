package kz.bitlab.sprinttask.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.sprinttask.db.DBManager;
import kz.bitlab.sprinttask.db.Items;

import java.io.IOException;

@WebServlet(value = "/addItem")
public class AddItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("item_name");
        String description = req.getParameter("item_descr");
        double price = Double.parseDouble(req.getParameter("item_price"));
        Items item = new Items();
            item.setName(name);
            item.setDescription(description);
            item.setPrice(price);
        if(DBManager.addItem(item)) {
            resp.sendRedirect("/home");
        } else {
            req.getRequestDispatcher("/404.jsp").forward(req,resp);
        }
    }
}
