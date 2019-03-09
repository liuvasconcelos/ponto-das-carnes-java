
public class LoginDAO {

	public Boolean auth(User user) {
		if (user.getLogin().equals("logincorreto") && user.getPassword().equals("senhacorreta")) {
			return true;
		} 
		return false;
	}
}
