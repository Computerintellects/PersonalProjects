package com.cnsi.examination.results.persistence;
import java.sql.*;
public class DBconnection {
	public static Connection getConnection()
	{
		Connection connection=null;
		try
		{

			Class.forName("oracle.jdbc.driver.OracleDriver");

			connection=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","venkat","venkat");
		
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(Exception e)
		{
			e.printStackTrace();
		}


		return connection;
	}
}






