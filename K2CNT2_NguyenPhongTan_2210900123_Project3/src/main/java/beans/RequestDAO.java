package beans;

import database.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RequestDAO {
    public List<Request> getAllRequests() {
        List<Request> list = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM npt_requests";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Request request = new Request(
                        rs.getInt("npt_request_id"),
                        rs.getInt("npt_user_id"),
                        rs.getInt("npt_vehicle_id"),
                        rs.getString("npt_message"),
                        rs.getTimestamp("npt_created_at")
                );
                list.add(request);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean addRequest(int userId, String message) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "INSERT INTO npt_requests (npt_user_id, npt_message) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, userId);
            stmt.setString(2, message);

            int rowsInserted = stmt.executeUpdate();
            conn.close();

            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean updateRequest(int requestId, String message) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE npt_requests SET npt_message = ? WHERE npt_request_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, message);
            stmt.setInt(2, requestId);
            int rowsUpdated = stmt.executeUpdate();
            conn.close();
            return rowsUpdated > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public boolean deleteRequest(int requestId) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM npt_requests WHERE npt_request_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, requestId);
            int rowsDeleted = stmt.executeUpdate();
            conn.close();
            return rowsDeleted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Request getRequestById(int requestId) {
        Request request = null;
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM npt_requests WHERE npt_request_id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, requestId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                request = new Request(
                        rs.getInt("npt_request_id"),
                        rs.getInt("npt_user_id"),
                        rs.getInt("npt_vehicle_id"),
                        rs.getString("npt_message"),
                        rs.getTimestamp("npt_created_at")
                );
                
                System.out.println("Request ID: " + request.getRequestId()); // Kiểm tra ID trả về
            } else {
                System.out.println("Không tìm thấy yêu cầu với ID: " + requestId);
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return request;
    }
}

