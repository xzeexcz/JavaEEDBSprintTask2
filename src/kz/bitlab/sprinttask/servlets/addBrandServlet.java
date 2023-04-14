package kz.bitlab.sprinttask.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.sprinttask.db.Brands;
import kz.bitlab.sprinttask.db.DBManager;

import java.io.IOException;

@WebServlet(value = "/addBrand")
public class addBrandServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("brand_name");
        String country = req.getParameter("brand_country");
        if((name!=null) || (country !=null)) {
            Brands brand = new Brands(null, name, country);
            DBManager.addBrand(brand);
            resp.sendRedirect("/adminPageBrands");
        } else {
            req.getRequestDispatcher("/404.jsp").forward(req,resp);
        }

    }
}
