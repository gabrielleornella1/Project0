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

public class CustomerDAO {
	
	private DbConnection con;

	public CustomerDAO() {}

	public CustomerDAO(DbConnection con) {
		this.con = con;
	}

	public List<UserModel> getAll() {
		List<UserModel> customerList = new ArrayList<UserModel>();
		try (Connection c = con.getDBConnection()) {
			String sql = "select * from customers";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				//customerList.add(new UserModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	
	public void insert(UserModel entity) {
		try (Connection c = con.getDBConnection()) {
			String sql = "{? = call insert_customer(?, ?, ?, ?, ?, ?, ?)}";
			CallableStatement cs = c.prepareCall(sql);
			cs.registerOutParameter(1, Types.VARCHAR);
	
			cs.setString(3, entity.getUsername());
			cs.setString(4, entity.getPassword());
			cs.setString(5, entity.getFirst_name());
			cs.setString(6, entity.getLast_name());
	
			cs.execute();
			System.out.println(cs.getString(1));
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

}
