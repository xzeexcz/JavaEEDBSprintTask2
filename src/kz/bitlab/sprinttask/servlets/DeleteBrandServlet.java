package kz.bitlab.sprinttask.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.sprinttask.db.DBManager;

import java.io.IOException;

@WebServlet(value = "/deleteBrand")
public class DeleteBrandServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = -1L;
        try{
            id = Long.parseLong(req.getParameter("brand_id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(DBManager.deleteBrand(id)) {
            resp.sendRedirect("/home");
        } else {
            req.getRequestDispatcher("/404.jsp").forward(req,resp);
        }
    }
}
