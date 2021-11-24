package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import users.UserModel;

public class UserDAOImpl implements UserDAOInterface {
	
	private DbConnection c;

	
	public UserDAOImpl(DbConnection c) {
		this.c = c;
	}
		
	
	

	@Override
	public List<UserModel> getAll() {
		List<UserModel> customerList = new ArrayList<>();
		try(Connection con = c.getDBConnection()){
			
			String sql = "select * from customers";
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				//customerList.add(new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6), rs.getString(7)));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}

	@Override
	public UserModel getByName(String name) {
		//try(Connection con = c.getDBConnection() ){
			
		//}
			

		return null;
	}

	@Override
	public void update(UserModel entity) {
		// TODO Auto-generated method stub
		
	}
	

	


	@Override
	public void insert(UserModel entity) {
		try(Connection con = c.getDBConnection()){
			
			String sql = "INSERT INTO Users(Userid, FirstName, LastName, Username, password, Usertype ) VALUES(?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			ps.setInt(1, entity.getUser_id());
			ps.setString(2, entity.getFirst_name());
			ps.setString(3, entity.getLast_name());
			ps.setString(4, entity.getUsername());
			ps.setString(5, entity.getPassword());
			ps.setString(6, entity.getUserType());
		
			ps.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	//public void insertJunction(String username );

	@Override
	public void delete(UserModel entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<UserModel> findById(int customer_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserModel getByUserNameAndType(String username, String userType) {
		// TODO Auto-generated method stub
		UserModel user = null;
		try(Connection con = c.getDBConnection()){
			
			String sql = "select * from Users where username=? and usertype=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, username);
			ps.setString(2, userType);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				user=new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
			}
			return user;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	

	@Override
	public UserModel getByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}



}
