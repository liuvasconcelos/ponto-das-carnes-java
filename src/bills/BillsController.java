package bills;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

import providers.ProviderDAO;

@ManagedBean
public class BillsController {
		
	private Bill newBill = new Bill();
	private Bill selectedBill = new Bill();
	
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
	
	public String addAProvider() {
		return "addProvider";
	}
	
	public List<String> getProviders() {
		ProviderDAO dao = new ProviderDAO();
		List<String> list = dao.getProviders();

		return list;
	}
	
	public String payBill() {	
		System.out.println("---------------"+ selectedBill.getInvoice());
		BillsDAO dao = new BillsDAO();
		dao.payBill(selectedBill);
		return "mainPage";
	}

}
