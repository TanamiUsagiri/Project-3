package controllers;

import beans.Npt_Vehicle;
import beans.Npt_VehicleDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;


public class Npt_MotorbikeServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Npt_VehicleDAO vehicleDAO = new Npt_VehicleDAO();
        List<Npt_Vehicle> list = vehicleDAO.getAllVehicles();

        request.setAttribute("listMotorbike", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("Npt_index.jsp");
        dispatcher.forward(request, response);
        System.out.println("👉 Motorbike Servlet đã được gọi!");
    }
    
}

