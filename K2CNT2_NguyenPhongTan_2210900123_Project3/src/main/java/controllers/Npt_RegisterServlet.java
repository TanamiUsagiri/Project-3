package controllers;

import beans.Npt_UserDAO;
import database.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/register")
public class Npt_RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        Npt_UserDAO userDAO = new Npt_UserDAO();
        boolean result = userDAO.validateUser(name, email, password);

        if (result) {
            response.sendRedirect("Npt_login.jsp");
        } else {
            response.sendRedirect("Npt_register.jsp?error=1");
        }
    }
}
