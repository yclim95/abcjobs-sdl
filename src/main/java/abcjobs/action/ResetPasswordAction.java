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
		// TODO Auto-generated method stub
		System.out.println("Reset Password Action");
		String result = "";
		String email = AccountCredential.getEmail();
		UserDAO userDao = new UserDAO();
		
		int numOfRecord = userDao.resetPassword(email, userAccount.getPassword());
		
		if (numOfRecord != 0)
			result =  "success";
		
		return result;
	}

}
