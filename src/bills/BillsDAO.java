package bills;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BillsDAO {

	public List<Bill> getBills() {
		
		ConexaoDAO.createConnection();
		List<Bill> list = new ArrayList<Bill>();
		
		try {
			ConexaoDAO.conn.createStatement();
			String sql = "SELECT * FROM bills WHERE status = true ORDER BY due_date;";
			
			PreparedStatement ps = ConexaoDAO.conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Double value = rs.getDouble("value");
				String provider = rs.getString("provider");
				String invoice = rs.getString("invoice");
				String dueDate = rs.getString("due_date");

				Bill newBill = new Bill(value, provider, invoice, dueDate);
				list.add(newBill);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
        return list;

	}
	
	public void registerBill(Bill bill) {
		ConexaoDAO.createConnection();
		
		try {
			ConexaoDAO.conn.createStatement();
			String sql = "INSERT INTO bills (value, provider, invoice, due_date, status) VALUES (?, ?, ?, ?, true)";
			
			PreparedStatement ps = ConexaoDAO.conn.prepareStatement(sql);
			
			ps.setDouble(1, bill.getValue());
			ps.setString(2, bill.getProvider());
			ps.setString(3, bill.getInvoice());
			ps.setString(4, bill.getDueDate());

			ResultSet rs = ps.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void payBill(Bill bill) {
		ConexaoDAO.createConnection();
		
		try {
			ConexaoDAO.conn.createStatement();
			String sql = "UPDATE bills SET status = false WHERE invoice = ? AND due_date = ?";
			
			PreparedStatement ps = ConexaoDAO.conn.prepareStatement(sql);
			
			ps.setString(1, bill.getInvoice());
			ps.setString(2, bill.getDueDate());

			ResultSet rs = ps.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}