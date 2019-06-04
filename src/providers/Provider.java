package providers;

public class Provider {

	private String company;
	private String companyPerson;
	private String cellphone;
	
	public Provider(String company, String companyPerson, String cellphone) {
		this.company = company;
		this.companyPerson = companyPerson;
		this.cellphone = cellphone;
	}
	public Provider() {
		this.company = "";
		this.companyPerson = "";
		this.cellphone = "";
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

