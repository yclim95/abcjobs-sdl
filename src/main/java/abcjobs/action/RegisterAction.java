package abcjobs.action;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.dao.UserDAO;
import abcjobs.model.User;
import abcjobs.model.UserAccount;

public class RegisterAction extends ActionSupport {
	
	private User user;
	private UserAccount userAccount;	
	
	
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


	@Override
	public String execute() throws Exception {
		System.out.println("Register Action");
		// Create result to store text for struts routing
		String result = "";
		UserDAO userDao=new UserDAO(); // Create userDAO
		// user.getFirstName() -> data from posted form input
		// Return (True or False) - Check if able to successfully register user account
		boolean registrationValid = userDao.addUserAccount(user.getFirstName(), user.getLastName(),
				userAccount.getEmail(), userAccount.getPassword());
		
		if (registrationValid) // If successful
			result = "success";
		else
			result = "error";
		
		return result; //Result return to struts.xml
	}
	
}
