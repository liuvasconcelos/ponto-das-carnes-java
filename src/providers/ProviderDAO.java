package providers;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bills.Bill;
import bills.ConexaoDAO;

public class ProviderDAO {
	
	public void registerProvider(Provider provider) {
		ConexaoDAO.createConnection();
		
		try {
			ConexaoDAO.conn.createStatement();
			String sql = "INSERT INTO providers (company, company_person, cellphone) VALUES (?, ?, ?); ";
			
			PreparedStatement ps = ConexaoDAO.conn.prepareStatement(sql);
			
			ps.setString(1, provider.getCompany());
			ps.setString(2, provider.getCompanyPerson());
			ps.setString(3, provider.getCellphone());

			ResultSet rs = ps.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public List<String> getProviders() {
		
		ConexaoDAO.createConnection();
		List<String> list = new ArrayList<String>();
		
		try {
			ConexaoDAO.conn.createStatement();
			String sql = "SELECT company FROM providers ORDER BY company;";
			
			PreparedStatement ps = ConexaoDAO.conn.prepareStatement(sql);

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