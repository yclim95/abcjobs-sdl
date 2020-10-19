package abcjobs.action;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.AccountCredential;
import abcjobs.dao.AdminDAO;
import abcjobs.dao.LoginDAO;
import abcjobs.dao.UserDAO;
import abcjobs.model.User;
import abcjobs.model.UserAccount;
import abcjobs.model.UserManagement;

public class LoginAction extends ActionSupport implements SessionAware{
	private UserAccount userAccount;	
	private User user;
	SessionMap<String,Object> loginCredential;
	private List<UserManagement> userList;
	private String message;

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public List<UserManagement> getUserList() {
		return userList;
	}

	public void setUserList(List<UserManagement> userList) {
		this.userList = userList;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Login Action");
		String result = "";
		ResultSet numOfRecord = null;
		String grantLevel = "";
		String firstName = "";
		LoginDAO loginDao = new LoginDAO();
		numOfRecord = loginDao.validateLoginCreditial(userAccount.getEmail(), userAccount.getPassword());
		grantLevel = loginDao.getGrantLevel(userAccount.getEmail(), userAccount.getPassword());
		System.out.println("Output: " + grantLevel);
		if (numOfRecord.next())
		{
			System.out.println("Output: " + grantLevel);
			UserDAO userDAO = new UserDAO();
			firstName = userDAO.getFirstName(userAccount.getEmail());
			AccountCredential.setFirstName(firstName);
			AccountCredential.setEmail(userAccount.getEmail());
			loginCredential.put("email", userAccount.getEmail());
			loginCredential.put("firstName", firstName);
			
			if (grantLevel.equals("programmer")) 
			{
				result =  "success-user";
				HttpServletRequest request=ServletActionContext.getRequest();  
				HttpSession session=request.getSession();  
				firstName = (String)session.getAttribute("firstName");

			}
			else 
			{
				result =  "success-admin";
				HttpServletRequest request=ServletActionContext.getRequest();  
				HttpSession session=request.getSession();  
				firstName = (String)session.getAttribute("firstName");
				AdminDAO adminDao = new AdminDAO();
				userList = adminDao.getListOfUsers();
				
				if (userList != null) {
				}
				else {
					message = "No registered user currently";
				}
			}
				
		}

		else
			result = "error";
			
		
		System.out.println("Result: " + result);
		
		return result;
	}

	@Override
	public void setSession(Map<String, Object> map) {
		// TODO Auto-generated method stub
		loginCredential = (SessionMap)map;
	}
		
	public String logout() {
		if (loginCredential != null) {
			loginCredential.invalidate();
		}
		
		return "logout";
	}

}
