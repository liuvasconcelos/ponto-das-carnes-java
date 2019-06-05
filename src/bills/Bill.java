package bills;

public class Bill {

	private Integer id;
	private Double value;
	private String provider;
	private String invoice;
	private String dueDate;
	
	public Bill(Integer id, Double value, String provider, String invoice, String dueDate) {
		super();
		this.id = id;
		this.value = value;
		this.provider = provider;
		this.invoice = invoice;
		this.dueDate = dueDate;
	}
	public Bill() {
		super();
		this.id = 0;
		this.value = 0.0;
		this.provider = "";
		this.invoice = "";
		this.dueDate = "";
	}
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
