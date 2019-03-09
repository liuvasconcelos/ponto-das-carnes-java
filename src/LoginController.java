import javax.faces.bean.ManagedBean;

@ManagedBean
public class LoginController {
	
	private User user = new User();
	
	public User getUser() {
		return this.user;
	}
	
	public String authenticate(){
        LoginDAO dao = new LoginDAO();
        Boolean authenticationIsCorrect = dao.auth(this.user);
        
        if (authenticationIsCorrect) {
        	return "mainPage";
        }
        
        return "errorPage";
    }
}
