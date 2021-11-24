package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import users.BankAccountModel;
import users.UserModel;

public class BankAccountDAOImpl implements BankAccountDAOInterface {
	
	private DbConnection c;

	
	public BankAccountDAOImpl(DbConnection c) {
		this.c = c;
	}


	@Override
	public List<BankAccountModel> getAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BankAccountModel getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public BankAccountModel getById(int id) {
		
		BankAccountModel bankAccount = null;
		try(Connection con = c.getDBConnection()){
			
			String sql = "select * from Accounts where userid=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, id);
			ResultSet rs  = ps.executeQuery();
			
			while(rs.next()) {
				bankAccount= new BankAccountModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			}
			return bankAccount;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bankAccount;
		

	}


	@Override
	public BankAccountModel getByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void update(BankAccountModel entity) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void insert(BankAccountModel entity) {
		try(Connection con = c.getDBConnection()){
			
			String sql = "INSERT INTO Accounts(type, userId, state) VALUES(?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			//ps.setInt(1, entity.getAccountNumber());
			ps.setString(1, entity.getType());
			ps.setInt(2, entity.getUserId());
			ps.setString(3, entity.getState());

			ps.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}


	@Override
	public void delete(BankAccountModel entity) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public BankAccountModel getAccountByNumber(int accountNumber) {

		BankAccountModel bankAccount = null;
		try(Connection con = c.getDBConnection()){
			
			String sql = "select * from Accounts where accountnumber=?";
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setInt(1, accountNumber);
			ResultSet rs  = ps.executeQuery();
			
			while(rs.next()) {
				bankAccount= new BankAccountModel(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4));
			}
			return bankAccount;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return bankAccount;
	}


	@Override
	public void approveAccount(int accountNumber) {
	
		try(Connection con = c.getDBConnection()){
			
		  String sql = "UPDATE Accounts SET state = ?";
			PreparedStatement ps = con.prepareStatement(sql);

			//ps.setInt(1, entity.getAccountNumber());
			ps.setString(1, "Approved");

			ps.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}

}
