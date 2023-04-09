package kz.bitlab.sprinttask.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kz.bitlab.sprinttask.db.DBManager;

import java.io.IOException;

@WebServlet(value = "/signpage")
public class SignInPageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/signpage.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String email = (String) req.getParameter("user_email");
        String password = (String) req.getParameter("user_password");
        if ((email != null) || (password != null)) {
            String full_name = DBManager.isOk2(email,password);
            String error = null;
            if(full_name!=null) {
                req.setAttribute("full_name", full_name);
                req.getRequestDispatcher("/profile.jsp").forward(req,resp);
            } else {
                error = "Incorrect login or password";
                req.setAttribute("owibka", error);
                req.getRequestDispatcher("/signpage.jsp").forward(req,resp);
            }
        } else {
            req.getRequestDispatcher("/404.jsp").forward(req,resp);
        }
    }
}
