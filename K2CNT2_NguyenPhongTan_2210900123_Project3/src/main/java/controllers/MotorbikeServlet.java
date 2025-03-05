package controllers;

import beans.Vehicle;
import beans.VehicleDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


public class MotorbikeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        VehicleDAO vehicleDAO = new VehicleDAO();
        List<Vehicle> list = vehicleDAO.getAllVehicles();

        request.setAttribute("listMotorbike", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
        System.out.println("👉 Servlet đã được gọi!");
    }
    
}

