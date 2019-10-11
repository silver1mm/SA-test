package test;

import java.sql.ResultSet;

public class UserDAO {
	 private dbConnection conn;
	 public UserDAO()
     {
         conn = new dbConnection();
     }
	 public ResultSet searchByName(String _username)
     {
         String query = "select * from authors where au_id like ? or id like ?";
         String[] sqlParameters = new String[2];
         sqlParameters[0]= _username;        
         sqlParameters[1]= _username;
         return conn.executeSelectQuery(query, sqlParameters);
     }
	 public ResultSet searchById(String _id)
     {
         String query = "select * from authors where au_id = ?";
         String[] sqlParameters = new String[2];
         sqlParameters[0] = _id.substring(0, _id.length()-1);
         return conn.executeSelectQuery(query, sqlParameters);
     }
}
