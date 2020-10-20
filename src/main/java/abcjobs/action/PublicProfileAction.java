package abcjobs.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import abcjobs.dao.UserDAO;
import abcjobs.model.User;

public class PublicProfileAction extends ActionSupport{
	private String firstName;
	private User user;
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String execute() throws Exception {
		// Create result to store text for struts routing
		String result="";
		// Create userDAO object
		UserDAO userDao = new UserDAO();
		// Get user record from user database by userID
		user = userDao.getUserProfileByUserID(user.getUserID());
		// Get Request from Servlet Action
		HttpServletRequest request=ServletActionContext.getRequest();  
		// Request for Session
		HttpSession session=request.getSession();  
		
		// if retrieve user record != null
		if (user != null)
		{
			// Get First Name to display at navigation menu
			firstName = (String)session.getAttribute("firstName");
			result = "public-profile"; //Result return to struts.xml
		}
		return result; //Result return to struts.xml
	}
	
}
