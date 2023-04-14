package kz.bitlab.sprinttask.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.sprinttask.db.Brands;
import kz.bitlab.sprinttask.db.DBManager;

import java.io.IOException;

@WebServlet(value = "/editBrand")
public class EditBrandServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("brand_rename");
        String country = req.getParameter("brand_new_country");
        Long id = -1L;
        try{
            id = Long.parseLong(req.getParameter("brand_id"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        Brands brand = DBManager.getBrandsById(id);
        if(brand!=null) {
            brand.setName(name);
            brand.setCountry(country);
            if(DBManager.editBrand(brand)) {
                resp.sendRedirect("/detailsBrand?id=" + brand.getId());
            } else {
                req.getRequestDispatcher("/404.jsp").forward(req,resp);
            }
        } else {
            req.getRequestDispatcher("/404.jsp").forward(req,resp);
        }
    }
}
