package providers;

public class Provider {

	private Integer id;
	private String company;
	private String companyPerson;
	private String cellphone;
	
	public Provider(Integer id, String company, String companyPerson, String cellphone) {
		super();
		this.id = id;
		this.company = company;
		this.companyPerson = companyPerson;
		this.cellphone = cellphone;
	}
	public Provider() {
		super();
		this.id = 0;
		this.company = "";
		this.companyPerson = "";
		this.cellphone = "";
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getCompany() {
		return company;
	}
	
	public void setCompany(String company) {
		this.company = company;
	}
	
	public String getCompanyPerson() {
		return companyPerson;
	}
	
	public void setCompanyPerson(String companyPerson) {
		this.companyPerson = companyPerson;
	}
	
	public String getCellphone() {
		return cellphone;
	}
	
	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}
	
	
}

