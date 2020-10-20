package abcjobs.action;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.AccountCredential;
import abcjobs.dao.UserDAO;
import abcjobs.model.UserAccount;

public class ResetPasswordAction extends ActionSupport{
	private UserAccount userAccount;	

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
	@Override
	public String execute() throws Exception {
		System.out.println("Reset Password Action");
		// Create result to store text for struts routing
		String result = "";
		// Retrieve email record (Get from forget password page submission)
		String email = AccountCredential.getEmail();
		// Create userDAO object 
		UserDAO userDao = new UserDAO();
		
		// Retrieve number of records that successfully reset the password
		// (Reset Password for targeted account by email)
		int numOfRecord = userDao.resetPassword(email, userAccount.getPassword());
		
		// Number of records that successfully reset the password != 0 (Successfully reseted password)
		if (numOfRecord != 0)
			result =  "success"; //Result return to struts.xml
		
		return result; //Result return to struts.xml
	}

}
