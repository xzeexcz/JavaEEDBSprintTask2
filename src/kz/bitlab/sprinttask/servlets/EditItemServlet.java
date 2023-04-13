package kz.bitlab.sprinttask.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.sprinttask.db.DBManager;
import kz.bitlab.sprinttask.db.Items;

import java.io.IOException;

@WebServlet(value = "/editItem")
public class EditItemServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("item_rename");
        String description = req.getParameter("item_redescr");
        double price = Double.parseDouble(req.getParameter("item_reprice"));
        Long id = Long.parseLong(req.getParameter("item_id"));
        Items it = DBManager.getItemByID(id);
        it.setName(name);
        it.setDescription(description);
        it.setPrice(price);
        if(DBManager.editItem(it)){
            resp.sendRedirect("/details?id="+id);
        } else {
            req.getRequestDispatcher("/404.jsp").forward(req,resp);
        }
    }
}
