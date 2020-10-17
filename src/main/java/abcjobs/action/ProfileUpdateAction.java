package abcjobs.action;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.dao.UserDAO;
import abcjobs.model.User;
import abcjobs.model.UserAccount;

public class ProfileUpdateAction extends ActionSupport{
	
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
		// TODO Auto-generated method stub
		System.out.println("Profile Update Action");
		int result = 0;
		UserDAO userDao = new UserDAO();
		result = userDao.updateUserProfile(user.getFirstName(), user.getLastName(), userAccount.getEmail(),
				userAccount.getPassword(), user.getCurrentJob(), user.getContactNo(), user.getBiography());
		
		if (result != 0)
			return "success";
		else 
			return "error";
	}

}
