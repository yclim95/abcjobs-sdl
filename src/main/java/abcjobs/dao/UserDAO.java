package abcjobs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import abcjobs.model.User;
import abcjobs.model.UserAccount;
import abcjobs.Database;


public class UserDAO {
	public boolean addUserAccount(String firstName, String lastName, String email, String password) throws SQLException {
		Connection con = Database.getConnection();
		boolean status = false;
		try {
			PreparedStatement statement = con.prepareStatement("insert into user(firstName,lastName) value(?,?)");
			statement.setString(1,firstName);
			statement.setString(2,lastName);
			statement.executeUpdate();
			
			
			int lastID = 0;
			Statement dbStatement = con.createStatement();
			ResultSet lastIDQuery = dbStatement.executeQuery("SELECT * FROM user"); 
			
			while (lastIDQuery.next()) {
				lastID = lastIDQuery.getInt("userID");
			}
			
			String sqlInsert = "insert into useraccount(email,password,userID) value(?,?,?)";
			statement = con.prepareStatement(sqlInsert);
			statement.setString(1,email);
			statement.setString(2,password);
			statement.setInt(3,lastID);
			
			statement.executeUpdate();
			status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status;

	}
	
	public boolean emailExist (String email) throws SQLException {
			Connection con = Database.getConnection();
			ResultSet lastIDQuery = null;
			boolean exist = false;
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from userAccount where email =?");
			statement.setString(1,email);
			lastIDQuery = statement.executeQuery();
			
			if (lastIDQuery.next()) {
				exist = true;
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exist;
	}
	
	public String getFirstName(String email) {
		String firstName = "";
		int userID = 0;
		
		Connection con = Database.getConnection();
		ResultSet resultSet = null;
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from userAccount where email =?");
			statement.setString(1,email);
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
				firstName = numOfRecord.getString("firstName");
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return firstName;
	}
	
	public int resetPassword(String email, String password) throws SQLException {
			Connection con = Database.getConnection();
			int result = 0;
		try {
			PreparedStatement statement = con.prepareStatement("UPDATE userAccount set password=? where email =?");
			statement.setString(1,password);
			statement.setString(2,email);
			
			result = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<User> getUserProfile(String email){
		ResultSet resultSet = null;
		List<User> userList = null;
		Connection con = Database.getConnection();
		ResultSet lastIDQuery = null;
		int userID = 0;
		
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from userAccount where email=?");
			statement.setString(1,email);
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
			userList = new ArrayList<User>();
			User user;
			
			while (numOfRecord.next()) {
				user = new User();
				user.setFirstName(numOfRecord.getString("firstName"));
				user.setLastName(numOfRecord.getString("lastName"));
				user.setCurrentJob(numOfRecord.getString("currentJob"));
				user.setCurrentCompany(numOfRecord.getString("currentCompany"));
				user.setContactNo(numOfRecord.getString("contactNo"));
				user.setCity(numOfRecord.getString("city"));
				user.setCountry(numOfRecord.getString("country"));
				user.setSkills(numOfRecord.getString("skills"));
				user.setBiography(numOfRecord.getString("biography"));
				
				userList.add(user); // Add data to populate 
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return userList;
	}
	
	
	public User getUserProfileByEmail(String email){
		ResultSet resultSet = null;
		Connection con = Database.getConnection();
		int userID = 0;
		
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from userAccount where email=?");
			statement.setString(1,email);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				System.out.println ("userID:" + resultSet.getInt("userID"));
				userID = resultSet.getInt("userID");;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
		User user = null;
		ResultSet numOfRecord = null;
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from user where userID =?");
			statement.setInt(1,userID);
			numOfRecord = statement.executeQuery();
			
			while (numOfRecord.next()) {
				user = new User();
				user.setFirstName(numOfRecord.getString("firstName"));
				user.setLastName(numOfRecord.getString("lastName"));
				user.setCurrentJob(numOfRecord.getString("currentJob"));
				user.setCurrentCompany(numOfRecord.getString("currentCompany"));
				user.setContactNo(numOfRecord.getString("contactNo"));
				user.setCity(numOfRecord.getString("city"));
				user.setCountry(numOfRecord.getString("country"));
				user.setSkills(numOfRecord.getString("skills"));
				user.setBiography(numOfRecord.getString("biography"));
				
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return user;
	}
	
	
	public UserAccount getUserAccount(String email){
		ResultSet resultSet = null;
		Connection con = Database.getConnection();
		int userID = 0;
		UserAccount userAccount = null;
		
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from userAccount where email=?");
			statement.setString(1,email);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				userAccount = new UserAccount();
				userAccount.setEmail(resultSet.getString("email"));
				userAccount.setPassword(resultSet.getString("password"));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return userAccount;
	}
	
	
	public int updateUserProfile(String firstName, String lastName, String email, String password,
			String currentJob, String contactNo, String biography, String currentCompany,
			String city, String country, String skills) throws SQLException {
			Connection con = Database.getConnection();
			ResultSet lastIDQuery = null;
			int result = 0;
		try {
			PreparedStatement statement = con.prepareStatement("SELECT userID from userAccount where email =?");
			statement.setString(1,email);
			lastIDQuery = statement.executeQuery();
			
			int userID = 0;
			if (lastIDQuery.next()) {
				userID = lastIDQuery.getInt("userID");
			}
			
			String sqlInsert = "UPDATE user set firstName=?, lastName=?, currentJob=?, contactNo=?, biography=?,"
					+ "currentCompany=?, city=?, country=?, skills=? WHERE userID=?";
			statement = con.prepareStatement(sqlInsert);
			statement.setString(1,firstName);
			statement.setString(2,lastName);
			statement.setString(3,currentJob);
			statement.setString(4,contactNo);
			statement.setString(5,biography);
			statement.setString(6,currentCompany);
			statement.setString(7,city);
			statement.setString(8,country);
			statement.setString(9,skills);
			statement.setInt(10,userID);
			
			result = statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
