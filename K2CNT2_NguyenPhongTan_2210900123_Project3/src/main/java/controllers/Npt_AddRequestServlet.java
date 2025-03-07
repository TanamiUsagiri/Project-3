package controllers;

import beans.Npt_RequestDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/addRequest")
public class Npt_AddRequestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Integer userId = (Integer) session.getAttribute("userId");

        if (userId == null) {
            request.setAttribute("error", "Bạn cần đăng nhập trước khi gửi yêu cầu.");
            request.getRequestDispatcher("Npt_login.jsp").forward(request, response);
            return;
        }

        String message = request.getParameter("message");
        if (message == null || message.trim().isEmpty()) {
            request.setAttribute("error", "Lời nhắn không được để trống.");
            request.getRequestDispatcher("Npt_addRequest.jsp").forward(request, response);
            return;
        }

        Npt_RequestDAO requestDAO = new Npt_RequestDAO();
        boolean success = requestDAO.addRequest(userId, message);

        if (success) {
            session.setAttribute("success", "Yêu cầu đã được thêm thành công!");
        } else {
            session.setAttribute("error", "Có lỗi xảy ra khi thêm yêu cầu.");
        }

        response.sendRedirect("requests");
    }
}
