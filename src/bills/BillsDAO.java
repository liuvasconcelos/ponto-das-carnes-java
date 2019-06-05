package bills;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import utils.ConnectionDAO;

public class BillsDAO {

	public List<Bill> getBillsWith(Boolean status) {
		
		ConnectionDAO.createConnection();
		List<Bill> list = new ArrayList<Bill>();
		
		try {
			ConnectionDAO.conn.createStatement();
			String sql = "SELECT * FROM bills WHERE status = false ORDER BY due_date;";
			if (status) {
				sql = "SELECT * FROM bills WHERE status = true ORDER BY due_date;";
			}
			
			PreparedStatement ps = ConnectionDAO.conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Double value = rs.getDouble("value");
				String provider = rs.getString("provider");
				String invoice = rs.getString("invoice");
				String dueDate = rs.getString("due_date");
				Integer id = rs.getInt("id");

				Bill newBill = new Bill(id, value, provider, invoice, dueDate);
				list.add(newBill);
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionDAO.close();
        return list;

	}
	
	public void registerBill(Bill bill) {
		ConnectionDAO.createConnection();
		
		try {
			ConnectionDAO.conn.createStatement();
			String sql = "INSERT INTO bills (value, provider, invoice, due_date, status) VALUES (?, ?, ?, ?, true)";
			
			PreparedStatement ps = ConnectionDAO.conn.prepareStatement(sql);
			
			ps.setDouble(1, bill.getValue());
			ps.setString(2, bill.getProvider());
			ps.setString(3, bill.getInvoice());
			ps.setString(4, bill.getDueDate());

			ps.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionDAO.close();
	}
	
	public void changeStatusOf(Bill bill, Boolean pay) {
		ConnectionDAO.createConnection();
		
		try {
			ConnectionDAO.conn.createStatement();
			String sql = "UPDATE bills SET status = true WHERE invoice = ? AND due_date = ?";
			
			if (pay) {
				sql = "UPDATE bills SET status = false WHERE invoice = ? AND due_date = ?";
			}
			
			PreparedStatement ps = ConnectionDAO.conn.prepareStatement(sql);
			
			ps.setString(1, bill.getInvoice());
			ps.setString(2, bill.getDueDate());

			ps.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ConnectionDAO.close();
	}
}