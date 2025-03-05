package controllers;

import beans.VehicleDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        VehicleDAO dao = new VehicleDAO();
        dao.deleteVehicle(id);
        response.sendRedirect("motorbikes");
    }
}
