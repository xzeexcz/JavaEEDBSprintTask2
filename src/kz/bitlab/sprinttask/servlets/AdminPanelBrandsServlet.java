package kz.bitlab.sprinttask.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.sprinttask.db.Brands;
import kz.bitlab.sprinttask.db.DBManager;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(value = "/adminPageBrands")
public class AdminPanelBrandsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Brands> brands = DBManager.getAllBrands();
        if(brands!=null) {
            req.setAttribute("brendiki",brands);
            req.getRequestDispatcher("/adminPageBrands.jsp").forward(req,resp);
        } else {
            resp.sendRedirect("/home");
        }
    }
}
