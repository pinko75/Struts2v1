package it.polito.ai.struts2v1.example.model;

public class User {
	private int buserId;
    private String name;
    private String email;
    private String username;
    private String password;
	
	public User(int bUserId, String name, String email, String username, String password) {
		super();
		this.buserId = bUserId;
		this.name = name;
		this.email = email;
		this.username = username;
		this.password = password;
	}
	
	public int getBuserId() {
		return buserId;
	}

	public void setBuserId(int buserId) {
		this.buserId = buserId;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
