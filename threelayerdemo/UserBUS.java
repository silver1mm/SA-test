package test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserBUS
{
	private UserDAO _userDAO;

	       
	public UserBUS()
	{
	    _userDAO  = new UserDAO();
    }
    public UserVO getUserEmailByName(String name)
	{
	    UserVO userVO = new UserVO();
	    ResultSet dataTable = null;

	    dataTable = _userDAO.searchByName(name);

	    try {
			while(dataTable.next()) 
			{
			    userVO.au_id = dataTable.getString("au_id");
			    userVO.au_fname =dataTable.getString("au_fname"); 
			    userVO.au_lname =dataTable.getString("au_lname"); 
			    userVO.phone = dataTable.getString("phone");
			    userVO.address = dataTable.getString("address");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return userVO;
     }
	 public UserVO getUserById(String _id)
	 {
         UserVO userVO = new UserVO();
         ResultSet dataTable = null;
	     dataTable = _userDAO.searchById(_id);

	     try {
				while(dataTable.next()) 
				{
					userVO.au_id = dataTable.getString("au_id");
				    userVO.au_fname =dataTable.getString("au_fname"); 
				    userVO.au_lname =dataTable.getString("au_lname"); 
				    userVO.phone = dataTable.getString("phone");
				    userVO.address = dataTable.getString("address");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	     return userVO;
	 }
}
