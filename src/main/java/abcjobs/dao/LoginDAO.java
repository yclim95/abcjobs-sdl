package abcjobs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import abcjobs.Database;

public class LoginDAO {
		
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
		return numOfRecord;
	} 
	
	public String getGrantLevel (String email, String password) throws SQLException {
		String grantLevel  = "";
		int userID = 0;
		
		Connection con = Database.getConnection();
		ResultSet resultSet = null;
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from userAccount where email =? AND password =?");
			statement.setString(1,email);
			statement.setString(2,password);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println ("userID:" + resultSet.getInt("userID"));
				userID = resultSet.getInt("userID");;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		

		
	
		
		ResultSet numOfRecord = null;
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from user where userID =?");
			statement.setInt(1,userID);
			numOfRecord = statement.executeQuery();
			
			while (numOfRecord.next()) {
				grantLevel = numOfRecord.getString("grantLevel");
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println ("grantLevel:" + grantLevel);
		
		return grantLevel;
	}
}
