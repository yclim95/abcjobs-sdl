package abcjobs.action;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.AccountCredential;
import abcjobs.dao.AdminDAO;
import abcjobs.dao.LoginDAO;
import abcjobs.dao.UserDAO;
import abcjobs.model.User;
import abcjobs.model.UserAccount;
import abcjobs.model.UserManagement;

public class LoginAction extends ActionSupport implements SessionAware{
	private UserAccount userAccount;	
	private User user;
	SessionMap<String,Object> loginCredential;
	private List<UserManagement> userList;
	private String message;

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	@Override
	public String execute() throws Exception {
		System.out.println("Login Action");
		// Create result to store text for struts routing
		String result = "";
		// Create ResultSet to store result for validateLoginCredential()
		ResultSet numOfRecord = null;
		// Create String to store Grant Level
		String grantLevel = "";
		// Create String to store first name of current login user
		String firstName = "";
		// Create loginDao object 
		LoginDAO loginDao = new LoginDAO();
		// Store number of record that match login credential given by user with record in database
		numOfRecord = loginDao.validateLoginCreditial(userAccount.getEmail(), userAccount.getPassword());
		// Store grant level 'programmer' or 'admin'
		grantLevel = loginDao.getGrantLevel(userAccount.getEmail(), userAccount.getPassword());
		
		// If there is record
		if (numOfRecord.next())
		{
			// Create userDAO object 
			UserDAO userDAO = new UserDAO();
			// Retrieve first name based on user account email
			firstName = userDAO.getFirstName(userAccount.getEmail());
			// Set email to loginCredential (Session Map)
			loginCredential.put("email", userAccount.getEmail());
			// Set first name to loginCredential (Session Map)
			loginCredential.put("firstName", firstName);
			
			// If this user is a programmer
			if (grantLevel.equals("programmer")) 
			{
				result =  "success-user"; //Result return to struts.xml
				// Get Request from Servlet Action
				HttpServletRequest request=ServletActionContext.getRequest();  
				// Request for Session
				HttpSession session=request.getSession();  
				// Get First Name to display at navigation menu
				firstName = (String)session.getAttribute("firstName");

			}
			// If this user is an admin
			else 
			{
				result =  "success-admin"; //Result return to struts.xml
				// Get Request from Servlet Action
				HttpServletRequest request=ServletActionContext.getRequest();  
				// Request for Session
				HttpSession session=request.getSession();  
				// Get First Name to display at navigation menu
				firstName = (String)session.getAttribute("firstName");
				// Create adminDao object 
				AdminDAO adminDao = new AdminDAO();
				// Retrieve list of registered users
				userList = adminDao.getListOfUsers();
				
				// if userList retrieved is != null
				if (userList != null) {
				}
				else {
					// Display error message if no user currently registered
					message = "No registered user currently"; 
				}
			}
				
		}

		else
			result = "error"; //Result return to struts.xml
			
				
		return result; //Result return to struts.xml
	}

	@Override
	public void setSession(Map<String, Object> map) {
		// Set login credential As Session Map
		loginCredential = (SessionMap)map;
	}
		
	public String logout() {
		if (loginCredential != null) { // Login Credential Session Map != null
			loginCredential.invalidate(); //Invalidate the http session.
		}
		
		return "logout"; // Result return to struts.xml
	}

}
