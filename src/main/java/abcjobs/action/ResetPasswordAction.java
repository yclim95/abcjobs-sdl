package abcjobs.action;

import com.opensymphony.xwork2.ActionSupport;

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
		UserDAO userDao = new UserDAO();
		return "success";
	}

}
