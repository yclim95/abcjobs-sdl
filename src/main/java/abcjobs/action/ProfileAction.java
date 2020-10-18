package abcjobs.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.dao.UserDAO;
import abcjobs.model.User;

public class ProfileAction extends ActionSupport{
	private List<User> userList;
	private String firstName;
	
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

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAO();
		String result = "";
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session=request.getSession();  
		
		userList = userDAO.getUserProfile((String)session.getAttribute("email"));
		
		if (userList != null)
		{
			firstName = (String)session.getAttribute("firstName");
			result = "profile";
		}
		
		return result;
	}

}
