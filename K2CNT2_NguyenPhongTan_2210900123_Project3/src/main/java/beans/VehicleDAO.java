package beans;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDAO {
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> list = new ArrayList<>();
        Connection conn = DBConnection.getConnection();
        try {
            String sql = "SELECT * FROM npt_vehicles";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                Vehicle vehicle = new Vehicle(
                        rs.getInt("npt_vehicle_id"),
                        rs.getString("npt_brand"),
                        rs.getString("npt_model"),
                        rs.getDouble("npt_price"),
                        rs.getInt("npt_year"),
                        rs.getString("npt_status")
                );
                list.add(vehicle);
            }
            rs.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                    System.out.println("Kết nối đã đóng!");
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }
    
    public void deleteVehicle(int vehicleId) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "DELETE FROM npt_vehicles WHERE npt_vehicle_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, vehicleId);
            ps.executeUpdate();
            System.out.println("Deleted Vehicle ID: " + vehicleId);
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void updateVehicle(Vehicle vehicle) {
        try {
            Connection conn = DBConnection.getConnection();
            String sql = "UPDATE npt_vehicles SET npt_brand=?, npt_model=?, npt_price=?, npt_year=?, npt_status=? WHERE npt_vehicle_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, vehicle.getBrand());
            ps.setString(2, vehicle.getModel());
            ps.setDouble(3, vehicle.getPrice());
            ps.setInt(4, vehicle.getYear());
            ps.setString(5, vehicle.getStatus());
            ps.setInt(6, vehicle.getVehicleId());
            ps.executeUpdate();
            System.out.println("Updated Vehicle ID: " + vehicle.getVehicleId());
            ps.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public static void main(String[] args) {
        VehicleDAO dao = new VehicleDAO();
        List<Vehicle> list = dao.getAllVehicles();
        if (list.isEmpty()) {
            System.out.println("❌ Không có dữ liệu hoặc query sai!");
        } else {
            System.out.println("✅ Lấy dữ liệu thành công!");
            for (Vehicle v : list) {
                System.out.println(v.getBrand());
            }
        }
    }
}

