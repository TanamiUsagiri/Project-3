package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Npt_UserDAO {
    public boolean validateUser(String name, String email, String password) {
        try {
            Connection conn = Npt_DBConnection.getConnection();
            String sql = "INSERT INTO npt_users (npt_name, npt_email, npt_password, npt_role) VALUES (?, ?, ?, 'customer')";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, password);
            
            int rowsInserted = stmt.executeUpdate();
            conn.close();
            
            return rowsInserted > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
