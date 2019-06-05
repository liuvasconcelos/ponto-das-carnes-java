
public class User {

	private Integer id;
	private String fullName;
	private String login;
	private String password;

	public User(Integer id, String fullName, String login, String password) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.login = login;
		this.password = password;
	}
	
	public User() {
		super();
		this.id = 0;
		this.fullName = "";
		this.login = "";
		this.password = "";
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getLogin() {
		return this.login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
}
