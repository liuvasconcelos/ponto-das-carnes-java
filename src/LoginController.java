import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean
public class LoginController {
	
	private User user = new User();

	private String message;
	 
    public String getMessage() {
        return message;
    }
 
    public void setMessage(String message) {
        this.message = message;
    }
    
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public String authenticate(){
		if (!user.getLogin().equals("") && !user.getPassword().equals("")) {
			LoginDAO dao = new LoginDAO();
	        Boolean authenticationIsCorrect = dao.auth(this.user);
	        
	        if (authenticationIsCorrect) {
	        	return "mainPage";
	        } else {
	        	return "errorPage";
	        }
		} else {
			
		}
        
        return "errorPage";
    }
	
	public String goToRegisterUser() {
		return "registerUser";
	}
	
	public String returnToLogin() {
		return "index";
	}
	
	public String registerUser() {
		if (!this.user.getLogin().equals("") && !this.user.getPassword().equals("")) {
			LoginDAO dao = new LoginDAO();
	        dao.registerUser(this.user);
			return "mainPage";
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!", "Contact admin."));
			return "registerUser";
		}
	}

}
