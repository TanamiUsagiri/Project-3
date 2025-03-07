package controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import database.DBConnection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class Npt_LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM npt_users WHERE npt_email = ? AND npt_password = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", rs.getString("npt_name"));
                session.setAttribute("userId", rs.getInt("npt_user_id")); // Lưu userId vào session
                System.out.println("User ID: " + rs.getInt("npt_user_id")); // Debug Log
                response.sendRedirect("motorbikes");
            } else {
                request.setAttribute("error", "Tài khoản hoặc mật khẩu không đúng hoặc chưa đăng ký.");
                request.getRequestDispatcher("Npt_login.jsp").forward(request, response);
            }
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
