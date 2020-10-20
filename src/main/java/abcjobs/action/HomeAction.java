package abcjobs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

public class HomeAction extends ActionSupport{
	private String firstName;
	
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	@Override
	public String execute() throws Exception {
		// Get Request from Servlet Action
		HttpServletRequest request=ServletActionContext.getRequest();
		// Request for Session
		HttpSession session=request.getSession();  
		// Get First Name to display at navigation menu
		firstName = (String)session.getAttribute("firstName");
		return "home"; // Result return to struts.xml
	}

}
