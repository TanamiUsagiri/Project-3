package controllers;

import beans.RequestDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/deleteRequest")
public class DeleteRequestServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int requestId = Integer.parseInt(request.getParameter("id"));

        RequestDAO requestDAO = new RequestDAO();
        boolean success = requestDAO.deleteRequest(requestId);

        if (success) {
            request.setAttribute("success", "Yêu cầu đã được xóa!");
        } else {
            request.setAttribute("error", "Có lỗi xảy ra khi xóa yêu cầu.");
        }
        request.getRequestDispatcher("requests").forward(request, response);
    }
}
