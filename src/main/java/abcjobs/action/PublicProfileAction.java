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
		// TODO Auto-generated method stub
		String result="";
		UserDAO userDao = new UserDAO();
		user = userDao.getUserProfileByUserID(user.getUserID());
		HttpServletRequest request=ServletActionContext.getRequest();  
		HttpSession session=request.getSession();  
		
		if (user != null)
		{
			firstName = (String)session.getAttribute("firstName");
			result = "public-profile";
		}
		return result;
	}
	
}
