package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class dbConnection {
	private String user = "sa";
	private String password = "123456";
	private String connectURL = "jdbc:sqlserver://localhost:1433;databasename=pubs";
	private Connection conn=null;
	public dbConnection()
    {
        try {
			conn = DriverManager.getConnection(connectURL, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 public Connection openConnection() {
		 try {
			if(conn==null || conn.isClosed()) {
				 conn = DriverManager.getConnection(connectURL, user, password);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 return conn;	 
	 }
	 public ResultSet executeSelectQuery(String _query, String[] sqlParameter) {
		 openConnection();
		 ResultSet rs = null;
		 try {
			PreparedStatement pstate = conn.prepareStatement(_query);
			for(int i=0;i<sqlParameter.length;i++) {
				pstate.setString(i+1, sqlParameter[i]);
			}
			rs=pstate.executeQuery();
		 } catch (SQLException e) {
			  System.out.println("Error - Connection.executeSelectQuery - Query: " + _query + " \nException: " + e.getStackTrace().toString());
             return null;
		 }
		 return rs;
	 }
	 public boolean executeInsertQuery(String _query, String[] sqlParameter) {
		 openConnection();
		 try {
			PreparedStatement pstate = conn.prepareCall(_query);
			for(int i=0;i<sqlParameter.length;i++) {
				pstate.setString(i+1, sqlParameter[i]);
			}
			pstate.executeUpdate();
		 } catch (SQLException e) {
			 System.out.println("Error - Connection.executeInsertQuery - Query: " + _query + " \nException: \n" + e.getStackTrace().toString());
             return false;
		 }
		 return true;
	 }
	 public boolean executeUpdateQuery(String _query, String[] sqlParameter) {
		 openConnection();
		 try {
			PreparedStatement pstate = conn.prepareCall(_query);
			for(int i=0;i<sqlParameter.length;i++) {
				pstate.setString(i+1, sqlParameter[i]);
			}
			pstate.executeUpdate();
		 } catch (SQLException e) {
			 System.out.println("Error - Connection.executeUpdateQuery - Query: " + _query + " \nException: " + e.getStackTrace().toString());
             return false;
		 }
		 return true;
	 }
}
