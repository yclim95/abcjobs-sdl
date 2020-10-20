package abcjobs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.dao.UserDAO;
import abcjobs.model.User;

public class UsersAction extends ActionSupport{
	private String firstName;
	private List<User> userList;
	private String message;
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String execute() throws Exception {
		// Get Request from Servlet Action
		HttpServletRequest request=ServletActionContext.getRequest(); 
		// Request for Session
		HttpSession session=request.getSession();  
		// Get First Name to display at navigation menu
		firstName = (String)session.getAttribute("firstName"); 
		// Create userDAO object 
		UserDAO userDAO = new UserDAO();
		String result = ""; // Create result to store text for struts routing
		
		// Return back a list of user(s) that is not the currentLogIn user
		userList = userDAO.getListOfUser((String)session.getAttribute("email"));
		
		// If User List is not empty
		if (userList != null)
		{
			result = "users";
		}
		else {
			result = "users";
			message = "No other registered users currently"; // Message to display
		}

		return result; //Result return to struts.xml
	}

}
