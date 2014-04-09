package it.polito.ai.struts2v1.example;

import it.polito.ai.struts2v1.example.dal.UserDao;
import it.polito.ai.struts2v1.example.dal.UserDaoImpl;
import it.polito.ai.struts2v1.example.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionContext;

public class Register extends ExampleSupport {
	public String execute() throws Exception {
		System.out.println(getUsername() + getPassword() + getConfirm_password() + getEmail() + getName());
		System.out.println(isInvalid(getUsername()));
		System.out.println(isInvalid(getPassword()));
		System.out.println(isInvalid(getConfirm_password()));
		System.out.println(isInvalid(getEmail()));
		System.out.println(isInvalid(getName()));
		System.out.println(getPassword().equals(getConfirm_password()));
		System.out.println(validateEmail(getEmail()));
		
		if (isInvalid(getUsername()) || isInvalid(getPassword()) || isInvalid(getConfirm_password()) ||  isInvalid(getEmail()) ||  isInvalid(getName())) return INPUT;
		
		if (!getPassword().equals(getConfirm_password())) return INPUT;
		
		if (!validateEmail(getEmail())) return INPUT;
		
		UserDao udao = new UserDaoImpl();
		udao.createUser(getName(),getUsername(), getPassword(), getEmail());
		return SUCCESS;
	}

	String username;
	String password;
	String confirm_password;
	String email;
	String name;
	private static final String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern pattern;
	private Matcher matcher;
	
	public boolean validateEmail(final String email) {
		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);
		return matcher.matches();
 
	}
	
	private boolean isInvalid(String value) {
        return (value == null || value.length() == 0);
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
