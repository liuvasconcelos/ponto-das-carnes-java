import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bills.ConexaoDAO;

public class LoginDAO {

	public Boolean auth(User user) {
		ConexaoDAO.createConnection();
		try {
			ConexaoDAO.conn.createStatement();
			String sql = "SELECT * FROM users WHERE login=? AND password=?";
			
			PreparedStatement ps = ConexaoDAO.conn.prepareStatement(sql);
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String nome = rs.getString("login");
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
		ConexaoDAO.createConnection();
		
		try {
			ConexaoDAO.conn.createStatement();
			String sql = "INSERT INTO users (full_name, login, password) VALUES (?, ?, ?)";
			
			PreparedStatement ps = ConexaoDAO.conn.prepareStatement(sql);
			
			ps.setString(1, user.getFullName());
			ps.setString(2, user.getLogin());
			ps.setString(3, user.getPassword());

			ResultSet rs = ps.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
