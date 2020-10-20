package abcjobs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.dao.UserDAO;
import abcjobs.model.User;
import abcjobs.model.UserAccount;

public class ProfileUpdateAction extends ActionSupport{
	private User user;
	private UserAccount userAccount;
	private String firstName;
	
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}



	public UserAccount getUserAccount() {
		return userAccount;
	}


	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	// Update user data for profile page based on submitted form input
	@Override
	public String execute() throws Exception {
		// Get Request from Servlet Action
		HttpServletRequest request=ServletActionContext.getRequest();  
		// Request for Session
		HttpSession session=request.getSession();  
		System.out.println("Profile Update Action");
		// Create result to store number of records successfully updated
		int result = 0;
		// Create userDAO object
		UserDAO userDao = new UserDAO();
		// Return number of records updated (update user database)
		result = userDao.updateUserProfile(user.getFirstName(), user.getLastName(), userAccount.getEmail(),
				userAccount.getPassword(), user.getCurrentJob(), user.getContactNo(), user.getBiography(),
				user.getCurrentCompany(), user.getCity(), user.getCountry(), user.getSkills());
		
		// Number of records updated != 0 (Successfully updated)
		if (result != 0)
		{
			// Get First Name to display at navigation menu
			firstName = (String)session.getAttribute("firstName");
			return "success"; //Result return to struts.xml
		}
			
		else 
			return "error"; //Result return to struts.xml
	}
	
	// Retrieve user data and populate at update profile form
	public String getPage() throws Exception{
		// Get Request from Servlet Action
		HttpServletRequest request=ServletActionContext.getRequest();  
		// Request for Session
		HttpSession session=request.getSession();  
		// Retrieve email for this log-in user
		String email = (String)session.getAttribute("email");
		// Create userDAO object
		UserDAO userDAO = new UserDAO();
		// Create result to store text for struts routing
		String result = "";
		
		// Get user record from user database by current log-in user email
		user = userDAO.getUserProfileByEmail(email);
		// Get user account record from useraccount database by current log-in user email
		userAccount = userDAO.getUserAccount(email);
		
		// if user record != null AND useraccount record != null
		if (user != null && userAccount != null)
		{
			// Get First Name to display at navigation menu
			firstName = (String)session.getAttribute("firstName");
			result = "success"; //Result return to struts.xml
		}

		return result; //Result return to struts.xml
	}

}
