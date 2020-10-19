package abcjobs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.dao.AdminDAO;
import abcjobs.model.User;
import abcjobs.model.UserManagement;

public class BanUserAction extends ActionSupport{
	private User user;
	private String firstName;
	private List<UserManagement> userList;
	private String message;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
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
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session=request.getSession();  
		firstName = (String)session.getAttribute("firstName");
		String result = "";
		int numOfRecord = 0;
		
		AdminDAO adminDao = new AdminDAO();
		numOfRecord = adminDao.banUserByUserID(user.getUserID());
		userList = adminDao.getListOfUsers();
		
		if (numOfRecord != 0 && userList != null) {
			result = "success";
			message = "Successfully Ban user";
		}
		else if (userList != null){
			result = "success";
			message = "No registered user records";
		}else {
			result = "error";
			message = "Fail to Ban user";
		}
		return result;
	}
	
}
