package bills;

import java.util.List;
import javax.faces.bean.ManagedBean;

import providers.ProviderDAO;

@ManagedBean
public class BillsController {
		
	private Bill newBill = new Bill();
	private Bill selectedBill = new Bill();
	private Bill selectedPayedBill = new Bill();
	
	public Bill getSelectedPayedBill() {
		return this.selectedBill;
	}
	
	public void setSelectedPayedBill(Bill bill) {
		this.selectedPayedBill = bill;
	}
	
	public Bill getSelectedBill() {
		return this.selectedBill;
	}
	
	public void setSelectedBill(Bill bill) {
		this.selectedBill = bill;
	}

	public Bill getBill() {
		return this.newBill;
	}
	
	public void setBill(Bill bill) {
		this.newBill = bill;
	}
	
	public List<Bill> getBills() {
		BillsDAO dao = new BillsDAO();
		List<Bill> bills = dao.getBillsWith(true);
				
		return bills;
	}
	
	public List<Bill> getPayedBills() {
		BillsDAO dao = new BillsDAO();
		List<Bill> bills = dao.getBillsWith(false);
				
		return bills;
	}
	
	public String addAccount() {
		return "addBill";
	}
	
	public String registerBill() {	
		if (!this.newBill.getValue().equals(0) && !this.newBill.getDueDate().equals("")) {
			BillsDAO dao = new BillsDAO();
			dao.registerBill(newBill);		
			return "mainPage";
		} else {
			return "addBill";
		}
	}
	
	public String addAProvider() {
		return "addProvider";
	}
	
	public List<String> getProviders() {
		ProviderDAO dao = new ProviderDAO();
		List<String> list = dao.getProviders();

		return list;
	}
	
	public String payBill() {	
		BillsDAO dao = new BillsDAO();
		dao.changeStatusOf(selectedBill, true);
		return "mainPage";
	}
	
	public String logout() {
		return "index";
	}
	
	
	public String revertBill() {	
		BillsDAO dao = new BillsDAO();
		dao.changeStatusOf(selectedPayedBill, false);
		return "mainPage";
	}
	

}
