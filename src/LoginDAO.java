import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
				System.out.println("Dados corretos: " + nome);
				return true;
			} else {
				System.out.println("Dados incorretos!");
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}
}
