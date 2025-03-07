package controllers;

import beans.Npt_Request;
import beans.Npt_RequestDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/requests")
public class Npt_RequestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Npt_RequestDAO requestDAO = new Npt_RequestDAO();
        List<Npt_Request> list = requestDAO.getAllRequests();

        request.setAttribute("listRequests", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Npt_requests.jsp");
        dispatcher.forward(request, response);
        System.out.println("👉 Request Servlet đã được gọi!");
    }
}
