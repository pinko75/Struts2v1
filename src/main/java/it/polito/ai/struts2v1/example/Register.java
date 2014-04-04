package it.polito.ai.struts2v1.example;

import it.polito.ai.struts2v1.example.dal.UserDao;
import it.polito.ai.struts2v1.example.dal.UserDaoImpl;
import it.polito.ai.struts2v1.example.model.User;

import java.util.HashMap;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

public class Register extends ExampleSupport {
	public String execute() throws Exception {
		User u = new User(getUsername(), getPassword());
		UserDao udao = new UserDaoImpl();
		udao.createUser(getUsername(), getPassword());
		
		return SUCCESS;
	}

	String username;
	String password;
	String confirm_password;
	String email;

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

	public String getConfirm_password() {
		return confirm_password;
	}

	public void setConfirm_password(String confirm_password) {
		this.confirm_password = confirm_password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
