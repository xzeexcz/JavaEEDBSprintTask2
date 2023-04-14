package kz.bitlab.sprinttask.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.sprinttask.db.Brands;
import kz.bitlab.sprinttask.db.DBManager;

import java.io.IOException;

@WebServlet(value = "/detailsBrand")
public class DetailsBrandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = -1L;
        try{
            id = Long.parseLong(req.getParameter("id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Brands brand = DBManager.getBrandsById(id);
        if(brand!=null) {
            req.setAttribute("wmotik", brand);
            req.getRequestDispatcher("/detailsBrand.jsp").forward(req,resp);
        } else {
            req.getRequestDispatcher("/404.jsp").forward(req,resp);
        }
    }
}
