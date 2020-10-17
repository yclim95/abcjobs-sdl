package abcjobs;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import abcjobs.dao.UserDAO;

public class ABCJobsTesting {
	@Test
	public void registerAccountTestCase() throws Exception
	{
		UserDAO userDao = new UserDAO();
		boolean expectedResult = true; // Should pass the testCase
		// Return true or false if registration record is successfully stored in database
		boolean actualResult = userDao.addUserAccount("John", "Chan", "johnchan@gmail.com", "123456Abc1234567");
		// Compare expected result (True) & Actual Result
		assertEquals(expectedResult, actualResult);
	}
}
