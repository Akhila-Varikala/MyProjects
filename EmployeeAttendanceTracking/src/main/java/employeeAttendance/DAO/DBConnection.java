package employeeAttendance.DAO;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection 
{
	private static final String url = "jdbc:mysql://localhost:3306/attendance_db";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "Abcd123#@!";
	
	public static Connection getConnection()
	{
		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(url, DB_USER, DB_PASSWORD);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
		
	}
	

}
