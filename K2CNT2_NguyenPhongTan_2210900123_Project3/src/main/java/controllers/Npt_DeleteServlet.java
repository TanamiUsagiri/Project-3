package controllers;

import beans.Npt_VehicleDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/delete")
public class Npt_DeleteServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Npt_VehicleDAO dao = new Npt_VehicleDAO();
        dao.deleteVehicle(id);
        response.sendRedirect("motorbikes");
    }
}
