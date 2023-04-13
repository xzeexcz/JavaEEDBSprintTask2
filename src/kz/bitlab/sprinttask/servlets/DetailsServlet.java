package kz.bitlab.sprinttask.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.sprinttask.db.DBManager;
import kz.bitlab.sprinttask.db.Items;

import java.io.IOException;

@WebServlet(value = "/details")
public class DetailsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.parseLong(req.getParameter("id"));
        Items item = DBManager.getItemByID(id);
        if(item!=null) {
            req.setAttribute("pluwka", item);
            req.getRequestDispatcher("/details.jsp").forward(req,resp);
        } else {
            req.getRequestDispatcher("/404.jsp").forward(req,resp);
        }
    }
}
