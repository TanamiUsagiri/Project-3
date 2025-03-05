package controllers;

import beans.Vehicle;
import beans.VehicleDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        double price = Double.parseDouble(request.getParameter("price"));
        int year = Integer.parseInt(request.getParameter("year"));
        String status = request.getParameter("status");

        Vehicle vehicle = new Vehicle(id, brand, model, price, year, status);
        VehicleDAO dao = new VehicleDAO();
        dao.updateVehicle(vehicle);
        response.sendRedirect("motorbikes");
    }
}
