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


	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Profile Update Action");
		int result = 0;
		UserDAO userDao = new UserDAO();
		result = userDao.updateUserProfile(user.getFirstName(), user.getLastName(), userAccount.getEmail(),
				userAccount.getPassword(), user.getCurrentJob(), user.getContactNo(), user.getBiography(),
				user.getCurrentCompany(), user.getCity(), user.getCountry(), user.getSkills());
		
		if (result != 0)
			return "success";
		else 
			return "error";
	}
	
	public String getPage() throws Exception{
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session=request.getSession();  
		String email = (String)session.getAttribute("email");
		UserDAO userDAO = new UserDAO();
		String result = "";
		
		user = userDAO.getUserProfileByEmail(email);
		userAccount = userDAO.getUserAccount(email);
		
		if (user != null && userAccount != null)
		{
			firstName = (String)session.getAttribute("firstName");
			result = "success";
		}

		return result;
	}

}
