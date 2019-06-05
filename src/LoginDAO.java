import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import utils.ConnectionDAO;

public class LoginDAO {

	public Boolean auth(User user) {
		ConnectionDAO.createConnection();
		try {
			ConnectionDAO.conn.createStatement();
			String sql = "SELECT * FROM users WHERE login=? AND password=?";
			
			PreparedStatement ps = ConnectionDAO.conn.prepareStatement(sql);
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
	
	public void registerUser(User user) {
		ConnectionDAO.createConnection();
		
		try {
			ConnectionDAO.conn.createStatement();
			String sql = "INSERT INTO users (full_name, login, password) VALUES (?, ?, ?)";
			
			PreparedStatement ps = ConnectionDAO.conn.prepareStatement(sql);
			
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getLogin());
			ps.setString(3, user.getPassword());

			ps.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
