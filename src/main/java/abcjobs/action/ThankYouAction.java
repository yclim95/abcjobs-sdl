package abcjobs.action;

import com.opensymphony.xwork2.ActionSupport;

public class ThankYouAction extends ActionSupport{

	@Override
	public String execute() throws Exception {
		return "thankyou"; //Result return to struts.xml
	}

}
