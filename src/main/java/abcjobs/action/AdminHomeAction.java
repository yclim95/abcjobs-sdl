package abcjobs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.dao.AdminDAO;
import abcjobs.model.UserManagement;

public class AdminHomeAction extends ActionSupport{
	private String firstName;
	private List<UserManagement> userList;
	private String message;
	
	
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
		
		AdminDAO adminDao = new AdminDAO();
		userList = adminDao.getListOfUsers();
		
		if (userList != null) {
			result = "success";
		}
		else {
			result = "error";
			message = "No registered user currently";
		}
		return result;
	}
}
