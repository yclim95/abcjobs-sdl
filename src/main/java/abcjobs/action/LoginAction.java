package abcjobs.action;

import java.sql.ResultSet;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.dao.LoginDAO;
import abcjobs.model.UserAccount;

public class LoginAction extends ActionSupport{
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
		System.out.println("Login Action");
		String result = "";
		ResultSet numOfRecord = null;
		String grantLevel = "";
		LoginDAO loginDao = new LoginDAO();
		numOfRecord = loginDao.validateLoginCreditial(userAccount.getEmail(), userAccount.getPassword());
		grantLevel = loginDao.getGrantLevel(userAccount.getEmail(), userAccount.getPassword());
		System.out.println("Output: " + grantLevel);
		if (numOfRecord.next())
		{
			System.out.println("Output: " + grantLevel);
			if (grantLevel.equals("programmer")) 
				result =  "success-user";
			else 
				result =  "success-admin";
		}

		else
			result = "error";
			
		
		System.out.println("Result: " + result);
		
		return result;
	}

}
