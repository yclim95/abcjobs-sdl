package abcjobs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.dao.UserDAO;
import abcjobs.model.User;

public class UsersSearchResultAction extends ActionSupport{
	private String firstName;
	private List<User> userList;
	private String message;
	private String searchUsers;
	
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
	
	public String getSearchUsers() {
		return searchUsers;
	}

	public void setSearchUsers(String searchUsers) {
		this.searchUsers = searchUsers;
	}

	@Override
	public String execute() throws Exception {
		// Get Request from Servlet Action
		HttpServletRequest request=ServletActionContext.getRequest();
		// Request for Session
		HttpSession session=request.getSession();  
		// Get First Name to display at navigation menu
		firstName = (String)session.getAttribute("firstName");
		// Get log-in user email
		String email = (String)session.getAttribute("email");
		// Create userDAO object 
		UserDAO userDAO = new UserDAO();
		String result = ""; // Create result to store text for struts routing
		
		// searchUsers is data get from search user form
		System.out.println(searchUsers); // Used to check if searchUsers is correct
		
		// Return back a list of user(s) that meet certain criteria
		userList = userDAO.getListOfUserByCriteria(searchUsers,email);
		// If User List is not empty
		if (userList != null)
		{
			// Display message to let user know how many records that match criteria
			message = userList.size() + " record match: " + searchUsers;
			result = "success";
		}
		else {
			result = "error";
			// Display message to let user know that none meet search criteria
			message = "No user meet your search criteria.";
		}

		return result; //Result return to struts.xml
	}

}
