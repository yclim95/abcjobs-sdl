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
		// TODO Auto-generated method stub\
		System.out.println("Forget Password Action");
		String result = "";
		boolean emailExist = false;
		UserDAO userDao = new UserDAO();
		if (userAccount != null)
			emailExist = userDao.emailExist(userAccount.getEmail());
		
		if (emailExist)
		{
			result = "success";
			AccountCredential.setEmail(userAccount.getEmail());
		}
		else
			result = "error";
		
		return result;

	}
	
}
