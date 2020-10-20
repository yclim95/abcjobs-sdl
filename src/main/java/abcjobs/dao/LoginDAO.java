package abcjobs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import abcjobs.Database;

public class LoginDAO {
	// Return Result Set of (records that match login credentials)	
	public ResultSet validateLoginCreditial(String email, String password) {
		Connection con = Database.getConnection();
		ResultSet numOfRecord = null;
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from userAccount where email =? AND password =?");
			statement.setString(1,email);
			statement.setString(2,password);
			numOfRecord = statement.executeQuery();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return numOfRecord; // Return Result Set of (records that match login credentials)	
	} 
	
	// Return a String of (grantLevel of current login user by email and password)
	public String getGrantLevel (String email, String password) throws SQLException {
		String grantLevel  = "";
		int userID = 0;
		
		Connection con = Database.getConnection();
		ResultSet resultSet = null;
		// Retrieve user ID that match record in user account table
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from userAccount where email =? AND password =?");
			statement.setString(1,email);
			statement.setString(2,password);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				userID = resultSet.getInt("userID"); // Retrieve user ID that match record in user account table
			} 
		}catch (Exception e) {
			e.printStackTrace();
		}
		

		ResultSet numOfRecord = null;
		// Get all user record that match userID (login user)
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from user where userID =?");
			statement.setInt(1,userID);
			numOfRecord = statement.executeQuery();
			
			while (numOfRecord.next()) {
				grantLevel = numOfRecord.getString("grantLevel"); // Set grantlevel
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
				
		return grantLevel; // Return a String of (grantLevel of current login user by email and password)
	}
}
