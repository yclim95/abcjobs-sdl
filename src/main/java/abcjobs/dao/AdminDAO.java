package abcjobs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import abcjobs.Database;
import abcjobs.model.UserManagement;

public class AdminDAO {
	
	// Get list of user records (user & user account) where grant level = "programmer"
	public List<UserManagement> getListOfUsers(){
		List<UserManagement> userList = null;
		Connection con = Database.getConnection();
			
		ResultSet numOfRecord = null;
		try {
			PreparedStatement statement = con.prepareStatement("SELECT *"
					+ " FROM user INNER JOIN useraccount ON "
					+ "user.userID = useraccount.userID WHERE grantLevel=?");
			statement.setString(1,"programmer");
			numOfRecord = statement.executeQuery();
			userList = new ArrayList<UserManagement>();
			UserManagement user;
			
			while (numOfRecord.next()) {
				user = new UserManagement();
				user.setUserID(numOfRecord.getInt("user.userID"));
				user.setFirstName(numOfRecord.getString("user.firstName"));
				user.setLastName(numOfRecord.getString("user.lastName"));
				user.setEmail(numOfRecord.getString("useraccount.email"));;
				
				userList.add(user); // Add data to list for populating 
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return userList; // Get list of user records (user & user account) where grant level = "programmer"
	}
	
	// Ban or Remove user record based on userID
	public int banUserByUserID (int userID) {
		int result = 0;
		Connection con = Database.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement("DELETE FROM user WHERE userID=?");
			statement.setInt(1, userID);
			result = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result; // Ban or Remove user record based on userID
	}
}
