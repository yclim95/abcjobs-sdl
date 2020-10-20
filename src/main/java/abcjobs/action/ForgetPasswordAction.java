package abcjobs.action;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.AccountCredential;
import abcjobs.dao.UserDAO;
import abcjobs.model.UserAccount;

public class ForgetPasswordAction extends ActionSupport{
	private UserAccount userAccount;	

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("Forget Password Action");
		// Create result to store text for struts routing
		String result = "";
		boolean emailExist = false; // Set email to does not exist
		// Create userDAO object
		UserDAO userDao = new UserDAO();
		
		// userAccount object is not EMPTY (Get from Forget Password Page Form input)
		if (userAccount != null)
			// Return (True / False) : Check if email exist from database
			emailExist = userDao.emailExist(userAccount.getEmail());
		// If email Exist
		if (emailExist)
		{
			result = "success";
			// Set email for reset password purpose
			AccountCredential.setEmail(userAccount.getEmail());
		}
		else
			result = "error";
		
		return result; // Result return to struts.xml

	}
	
}
