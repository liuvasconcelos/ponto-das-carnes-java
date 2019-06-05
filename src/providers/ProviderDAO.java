package providers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.ConnectionDAO;

public class ProviderDAO {
	
	public void registerProvider(Provider provider) {
		ConnectionDAO.createConnection();
		
		try {
			ConnectionDAO.conn.createStatement();
			String sql = "INSERT INTO providers (company, company_person, cellphone) VALUES (?, ?, ?); ";
			
			PreparedStatement ps = ConnectionDAO.conn.prepareStatement(sql);
			
			ps.setString(1, provider.getCompany());
			ps.setString(2, provider.getCompanyPerson());
			ps.setString(3, provider.getCellphone());

			ps.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<String> getProviders() {
		
		ConnectionDAO.createConnection();
		List<String> list = new ArrayList<String>();
		
		try {
			ConnectionDAO.conn.createStatement();
			String sql = "SELECT company FROM providers ORDER BY company;";
			
			PreparedStatement ps = ConnectionDAO.conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				String companyName = rs.getString("company");
				list.add(companyName);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
        return list;

	}
}