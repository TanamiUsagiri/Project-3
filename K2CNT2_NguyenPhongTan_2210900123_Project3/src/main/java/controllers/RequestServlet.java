package controllers;

import beans.Request;
import beans.RequestDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/requests")
public class RequestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDAO requestDAO = new RequestDAO();
        List<Request> list = requestDAO.getAllRequests();

        request.setAttribute("listRequests", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("requests.jsp");
        dispatcher.forward(request, response);
        System.out.println("👉 Request Servlet đã được gọi!");
    }
}
