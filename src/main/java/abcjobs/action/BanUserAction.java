package abcjobs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.dao.AdminDAO;
import abcjobs.model.User;
import abcjobs.model.UserManagement;

public class BanUserAction extends ActionSupport{
	private User user;
	private String firstName;
	private List<UserManagement> userList;
	private String message;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public List<UserManagement> getUserList() {
		return userList;
	}

	public void setUserList(List<UserManagement> userList) {
		this.userList = userList;
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getPage() throws Exception{
		// Get Request from Servlet Action
		HttpServletRequest request=ServletActionContext.getRequest(); 
		// Request for Session
		HttpSession session=request.getSession();
		// Get First Name to display at navigation menu
		firstName = (String)session.getAttribute("firstName");
		String result = ""; // Create result to store text for struts routing
		
		// Create adminDao object 
		AdminDAO adminDao = new AdminDAO();
		// Retrieve all users (Programmer) list
		userList = adminDao.getListOfUsers();
		
		// List of users retrieved is != null
		if (userList != null) {
			result = "success";
		}
		else {
			result = "error";
			message = "No user currently registered";
		}
		return result; // Result return to struts.xml
	}

	@Override
	public String execute() throws Exception {
		// Get Request from Servlet Action
		HttpServletRequest request=ServletActionContext.getRequest(); 
		// Request for Session
		HttpSession session=request.getSession();
		// Get First Name to display at navigation menu
		firstName = (String)session.getAttribute("firstName");
		String result = ""; // Create result to store text for struts routing
		int numOfRecord = 0; // Number of Record
		
		// Create adminDao object 
		AdminDAO adminDao = new AdminDAO();
		// Return how many user record is deleted
		numOfRecord = adminDao.banUserByUserID(user.getUserID());
		userList = adminDao.getListOfUsers();
		
		
		// If number of user record is removed ! = 0 And List of users retrieved is != null
		if (numOfRecord != 0 && userList != null) {
			result = "success";
			message = "Successfully Ban user";
		}
		else {
			result = "error";
			message = "Fail to Ban user and No user currently registered";
		}
		return result; // Result return to struts.xml
	}
	
}
