package kz.bitlab.sprinttask.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.sprinttask.db.DBManager;
import kz.bitlab.sprinttask.db.Items;

import java.io.IOException;
import java.util.ArrayList;


@WebServlet(value = "/adminPage")
public class AdminPanelServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Items> items = DBManager.getItems();
        if(items!=null) {
            req.setAttribute("tovariki",items);
            req.getRequestDispatcher("/adminPage.jsp").forward(req,resp);
        } else {
            req.getRequestDispatcher("/404.jsp").forward(req,resp);
        }
    }
}
