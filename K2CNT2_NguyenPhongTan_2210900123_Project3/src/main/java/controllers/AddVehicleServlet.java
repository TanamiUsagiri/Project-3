package controllers;

import beans.Vehicle;
import database.DBConnection;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addVehicle")
public class AddVehicleServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String brand = request.getParameter("vehicleBrand");
        String model = request.getParameter("vehicleModel");
        String price = request.getParameter("vehiclePrice");
        String year = request.getParameter("vehicleYear");
        String status = request.getParameter("vehicleStatus");

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO npt_vehicles (npt_brand, npt_model, npt_price, npt_year, npt_status) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, brand);
            stmt.setString(2, model);
            stmt.setDouble(3, Double.parseDouble(price));
            stmt.setInt(4, Integer.parseInt(year));
            stmt.setString(5, status);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Thêm xe thành công!");
            }
            conn.close();

            // Chuyển hướng về trang chủ sau khi thêm thành công
            response.sendRedirect("motorbikes");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
