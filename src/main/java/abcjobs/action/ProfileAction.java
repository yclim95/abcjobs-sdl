package abcjobs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.dao.UserDAO;
import abcjobs.model.User;

public class ProfileAction extends ActionSupport{
	private List<User> userList;
	private String firstName;
	
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

	@Override
	public String execute() throws Exception {
		// Create userDAO object 
		UserDAO userDAO = new UserDAO();
		// Create result to store text for struts routing
		String result = "";
		// Get Request from Servlet Action
		HttpServletRequest request=ServletActionContext.getRequest();  
		// Request for Session
		HttpSession session=request.getSession();  
		// Retrieve detail of user profile (by current login user email) 
		userList = userDAO.getUserProfile((String)session.getAttribute("email"));
		
		// If list of user details != null
		if (userList != null)
		{
			// Get First Name to display at navigation menu
			firstName = (String)session.getAttribute("firstName");
			result = "profile"; //Result return to struts.xml
		}
		 
		return result; //Result return to struts.xml
	}

}
