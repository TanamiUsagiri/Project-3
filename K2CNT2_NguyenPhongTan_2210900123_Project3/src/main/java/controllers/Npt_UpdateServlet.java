package controllers;

import beans.Npt_Vehicle;
import beans.Npt_VehicleDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/update")
public class Npt_UpdateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String brand = request.getParameter("brand");
        String model = request.getParameter("model");
        double price = Double.parseDouble(request.getParameter("price"));
        int year = Integer.parseInt(request.getParameter("year"));
        String status = request.getParameter("status");

        Npt_Vehicle vehicle = new Npt_Vehicle(id, brand, model, price, year, status);
        Npt_VehicleDAO dao = new Npt_VehicleDAO();
        dao.updateVehicle(vehicle);
        response.sendRedirect("motorbikes");
    }
}
