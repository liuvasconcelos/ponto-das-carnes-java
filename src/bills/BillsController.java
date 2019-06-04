package bills;

import java.util.List;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class BillsController {
		
	private Bill newBill = new Bill();

	public Bill getBill() {
		return this.newBill;
	}
	
	public void setBill(Bill bill) {
		this.newBill = bill;
	}
	
	public List<Bill> getBills() {
		BillsDAO dao = new BillsDAO();
		List<Bill> bills = dao.getBills();
				
		return bills;
	}
	
	public String addAccount() {
		return "addBill";
	}
	
	public String registerBill() {		
		BillsDAO dao = new BillsDAO();
		dao.registerBill(newBill);
		
		return "mainPage";
	}
}
