package bills;

public class Bill {

	private Double value;
	private String provider;
	private String invoice;
	private String dueDate;
	
	public Bill(Double value, String provider, String invoice, String dueDate) {
		this.value = value;
		this.provider = provider;
		this.invoice = invoice;
		this.dueDate = dueDate;
	}
	public Bill() {
		this.value = 0.0;
		this.provider = "";
		this.invoice = "";
		this.dueDate = "";
		// TODO Auto-generated constructor stub
	}
	public Double getValue() {
		return value;
	}
	public void setValue(Double value) {
		this.value = value;
	}
	public String getProvider() {
		return provider;
	}
	public void setProvider(String provider) {
		this.provider = provider;
	}
	public String getInvoice() {
		return invoice;
	}
	public void setInvoice(String invoice) {
		this.invoice = invoice;
	}
	public String getDueDate() {
		return dueDate;
	}
	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}
	
	
}
