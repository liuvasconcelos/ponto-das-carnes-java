package providers;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class ProvidersController {
		
	private Provider newProvider = new Provider();

	public Provider getProvider() {
		return this.newProvider;
	}
	
	public void setProvider(Provider provider) {
		this.newProvider = provider;
	}

	public String registerProvider() {		
		ProviderDAO dao = new ProviderDAO();
		dao.registerProvider(newProvider);	
		return "mainPage";
	}

}
