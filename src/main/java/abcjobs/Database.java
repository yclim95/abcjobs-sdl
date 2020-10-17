package abcjobs;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
	private static String databaseClassName = "com.mysql.jdbc.Driver";
	private static String databaseConnection = "jdbc:mysql://localhost:3306/abcjobs?serverTimezone=UTC";
	private static String databaseUser = "root";
	private static String databasePassword = "123456";
	private static Connection con=null;  
	
	static{  
		try{  
		Class.forName(databaseClassName);  
		con=DriverManager.getConnection(databaseConnection,databaseUser,databasePassword);  
		}catch(Exception e){ e.printStackTrace();}  
		}  
	
	
	public static Connection getConnection() {
		return con;
	}
}
