package abcjobs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.dao.UserDAO;
import abcjobs.model.User;

public class UsersSearchResultAction extends ActionSupport{
	private String firstName;
	private List<User> userList;
	private String message;
	private String searchUsers;
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getSearchUsers() {
		return searchUsers;
	}

	public void setSearchUsers(String searchUsers) {
		this.searchUsers = searchUsers;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session=request.getSession();  
		firstName = (String)session.getAttribute("firstName");
		UserDAO userDAO = new UserDAO();
		String result = "";
		
		System.out.println(searchUsers);
		
		userList = userDAO.getListOfUserByCriteria(searchUsers);
		if (userList != null)
		{
			firstName = (String)session.getAttribute("firstName");
			message = userList.size() + " record match: " + searchUsers;
			result = "success";
		}
		else {
			result = "error";
			message = "No user meet your search criteria.";
		}

		return result;
	}

}
