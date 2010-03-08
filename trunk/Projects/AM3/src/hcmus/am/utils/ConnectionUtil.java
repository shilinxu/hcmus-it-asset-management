package hcmus.am.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	public static Connection getConnection()
	{
		Connection connection = null;
		try {
//			ServletContext ctx = getServletContext();
//			String drivername = ctx.getInitParameter("JDBCDriver");
//			String connectionURL = ctx.getInitParameter("ConnectionURL");
			
//	        String driverName="com.microsoft.jdbc.sqlserver.SQLServerDriver";
//	        String connectionURL="jdbc:microsoft:sqlserver://localhost:1433;User=user;Password=user;DatabaseName=TracNghiemOnline";
			String driverName= ConfigurationManager.getDriverName();
			String connectionURL=ConfigurationManager.getConnectionURL();
			
	        Class.forName(driverName);
	        connection=DriverManager.getConnection(connectionURL);			
		} catch (ClassNotFoundException e) {		
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return connection;
	}
}
