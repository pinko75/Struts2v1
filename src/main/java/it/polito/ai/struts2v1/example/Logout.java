package it.polito.ai.struts2v1.example;

import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;

import com.opensymphony.xwork2.ActionContext;

public class Logout  extends ExampleSupport {
	 public String execute() throws Exception {
		 SessionMap session = (SessionMap) ActionContext.getContext().get("session");
		 //invalidate
		 session.remove("loggedin");
		 
		 return SUCCESS;
	 }
}
