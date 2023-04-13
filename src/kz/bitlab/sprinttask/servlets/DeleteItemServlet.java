package kz.bitlab.sprinttask.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.sprinttask.db.DBManager;

import java.io.IOException;

@WebServlet(value = "/deleteItem")
public class DeleteItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("item_id"));
        if(DBManager.deleteItem(id)) {
            resp.sendRedirect("/home");
        } else {
            req.getRequestDispatcher("404.jsp").forward(req,resp);
        }
    }
}
