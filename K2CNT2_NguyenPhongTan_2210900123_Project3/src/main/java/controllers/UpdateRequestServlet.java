package controllers;

import beans.RequestDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/updateRequest")
public class UpdateRequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("requestId"));
        String message = request.getParameter("message");

        RequestDAO requestDAO = new RequestDAO();
        boolean success = requestDAO.updateRequest(requestId, message);

        if (success) {
            request.setAttribute("success", "Yêu cầu đã được cập nhật!");
        } else {
            request.setAttribute("error", "Có lỗi xảy ra khi cập nhật yêu cầu.");
        }
        response.sendRedirect("requests");
    }
}
