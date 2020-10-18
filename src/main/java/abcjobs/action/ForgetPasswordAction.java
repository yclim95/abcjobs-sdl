package abcjobs.action;

import com.opensymphony.xwork2.ActionSupport;

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
		boolean emailExist;
		UserDAO userDao = new UserDAO();
		emailExist = userDao.emailExist(userAccount.getEmail());
		
		if (emailExist)
			result = "success";
		else
			result = "error";
		
		return result;

	}
	
}
