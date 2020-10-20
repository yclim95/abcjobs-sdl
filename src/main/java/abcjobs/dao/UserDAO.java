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
	// For user registration (insert new record - return TRUE or FALSE - if able to register successful?
	public boolean addUserAccount(String firstName, String lastName, String email, String password) throws SQLException {
		Connection con = Database.getConnection(); // Get Database Connection
		boolean status = false; // Registered not successfully
		try {
			// Start SQL insert statement - Insert record to User Table
			PreparedStatement statement = con.prepareStatement("insert into user(firstName,lastName) value(?,?)");
			statement.setString(1,firstName); // Insert First Name
			statement.setString(2,lastName); // Insert Last Name
			statement.executeUpdate(); // Execute SQL query
			
			
			int lastID = 0; // Last record User ID
			Statement dbStatement = con.createStatement();
			ResultSet lastIDQuery = dbStatement.executeQuery("SELECT * FROM user"); // Execute query.
			
			// Loop till the last record
			while (lastIDQuery.next()) {
				lastID = lastIDQuery.getInt("userID"); // Get UserID of last record
			}
			
			// Start SQL statement to insert data into User Account Table
			String sqlInsert = "insert into useraccount(email,password,userID) value(?,?,?)";
			statement = con.prepareStatement(sqlInsert);
			statement.setString(1,email); // Set email
			statement.setString(2,password); // Set Password
			statement.setInt(3,lastID); // Set last ID get from performing the above query
			
			statement.executeUpdate(); // Execute insert into user account query
			status = true; // Registered successfully
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return status; // Return if user registration is registered successfully
	}
	
	// Validate if email Exist: Return TRUE or FALSE
	public boolean emailExist (String email) throws SQLException {
		// Start 
			Connection con = Database.getConnection(); // Get Database Connection
			// Create ResultSet to store records that match email
			ResultSet record = null;
			// If email exist? (set to false)
			boolean exist = false;
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from userAccount where email =?");
			statement.setString(1,email); // Set email
			record = statement.executeQuery(); // Execute Query
			
			// Check if there is email record exist
			if (record.next()) {
				exist = true; // Return true (email exist)
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return exist; // True / False (email exist ?)
	}
	
	// Return a String of first name based on current login user's email
	public String getFirstName(String email) {
		String firstName = "";
		int userID = 0;
		
		Connection con = Database.getConnection();
		ResultSet resultSet = null;
		// Retrieve current login user userID
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from userAccount where email =?");
			statement.setString(1,email);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				userID = resultSet.getInt("userID");;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
		ResultSet numOfRecord = null;
		// Retrieve all records of user with a certain userID
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from user where userID =?");
			statement.setInt(1,userID);
			numOfRecord = statement.executeQuery();
			
			while (numOfRecord.next()) {
				firstName = numOfRecord.getString("firstName"); // Set firstName
			}

		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return firstName; // Return a String of first name based on current login user's email
	}
	
	// Return number of records (Manage to reset user account password)
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
		
		return result; // Return number of records (Manage to reset user account password)
	}
	
	// Return a list of User model (current login user based on email )
	public List<User> getUserProfile(String email){
		ResultSet resultSet = null;
		List<User> userList = null;
		Connection con = Database.getConnection();
		ResultSet lastIDQuery = null;
		int userID = 0;
		
		// Retrieve current login user's userID
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from userAccount where email=?");
			statement.setString(1,email);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				userID = resultSet.getInt("userID");;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		ResultSet numOfRecord = null;
		// Retrieve all records of a certain UserID
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
		
		return userList; // Return a list of User model (current login user based on email )
	}
	
	// Get User Model records (based on current login user's email)
	public User getUserProfileByEmail(String email){
		ResultSet resultSet = null;
		Connection con = Database.getConnection();
		int userID = 0;
		
		// Get current login userID
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from userAccount where email=?");
			statement.setString(1,email);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				userID = resultSet.getInt("userID");;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
		User user = null;
		ResultSet numOfRecord = null;
		// Get all user record if userID = current login user
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
		
		return user; // Get User Model records (based on current login user's email)
	}
	
	
	// Retrieve user model to display Public Profile (based on userID)
	public User getUserProfileByUserID(int userID){
		ResultSet resultSet = null;
		Connection con = Database.getConnection();
	
		User user = null;
		ResultSet numOfRecord = null;
		// Get current login user's userID
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
		
		return user; // Retrieve user model to display Public Profile (based on userID)
	}
	
	// Retrieve a list of user to display at Users page (based on current login user's email)
	public List<User> getListOfUser(String email){
		ResultSet resultSet = null;
		List<User> userList = null;
		Connection con = Database.getConnection();
		ResultSet lastIDQuery = null;
		int userID = 0;
		// Get current login user's userID
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from userAccount where email=?");
			statement.setString(1,email);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				userID = resultSet.getInt("userID");;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	
		ResultSet numOfRecord = null;
		// Get all user record where userID != current login user && is programmer
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from user where userID <> ? AND"
					+ " grantLevel = ?");
			statement.setInt(1,userID);
			statement.setString(2,"programmer");
			numOfRecord = statement.executeQuery();
			userList = new ArrayList<User>();
			User user;
			
			while (numOfRecord.next()) {
				user = new User();
				user.setUserID(numOfRecord.getInt("userID"));
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
		
		return userList; // Retrieve list of user records where userID != current login user && is programmer
	}
	
	
	// Retrieve a list of user to display at Users page (based on current login user's email & search criteria)
	public List<User> getListOfUserByCriteria(String searchCriteria, String email){
		List<User> userList = null;
		Connection con = Database.getConnection();
		ResultSet resultSet = null;
		int userID = 0;
		// Get current login user's userID
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from userAccount where email=?");
			statement.setString(1,email);
			resultSet = statement.executeQuery();
			
			while (resultSet.next()) {
				userID = resultSet.getInt("userID");;
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		ResultSet numOfRecord = null;
		// Get all user record where search criteria is met && userID != current login user && is programmer
		try {
			PreparedStatement statement = con.prepareStatement("SELECT * from USER WHERE (firstName=? OR"
					+ " lastName=? OR currentCompany=? OR currentJob=? OR city=? OR country=?) AND userID<>?"
					+ " AND grantLevel=?");
			statement.setString(1,searchCriteria);
			statement.setString(2,searchCriteria);
			statement.setString(3,searchCriteria);
			statement.setString(4,searchCriteria);
			statement.setString(5,searchCriteria);
			statement.setString(6,searchCriteria);
			statement.setInt(7,userID);
			statement.setString(8,"programmer");
			numOfRecord = statement.executeQuery();
			userList = new ArrayList<User>();
			User user;
			
			while (numOfRecord.next()) {
				user = new User();
				user.setUserID(numOfRecord.getInt("userID"));
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
		// Retrieve a list of user to display at Users page (based on current login user's email & search criteria)
		return userList;
	}
	
	// Retrieve UserAccount record (By email)
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
		
		
		return userAccount; // Retrieve UserAccount record (By email)
	}
	
	
	// Return number of records updated (Update user profile)
	public int updateUserProfile(String firstName, String lastName, String email, String password,
			String currentJob, String contactNo, String biography, String currentCompany,
			String city, String country, String skills) throws SQLException {
			Connection con = Database.getConnection();
			ResultSet lastIDQuery = null;
			int result = 0;
			// Get current login user's user ID
		try {
			PreparedStatement statement = con.prepareStatement("SELECT userID from userAccount where email =?");
			statement.setString(1,email);
			lastIDQuery = statement.executeQuery();
			
			int userID = 0;
			if (lastIDQuery.next()) {
				userID = lastIDQuery.getInt("userID");
			}
			
			// Update user record
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
		
		return result; // Return number of records updated (Update user profile)
	}
}
