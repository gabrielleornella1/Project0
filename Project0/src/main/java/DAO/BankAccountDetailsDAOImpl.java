package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import users.BankAccountDetailsModel;
import users.BankAccountModel;

public class BankAccountDetailsDAOImpl implements BankAccountDetailsDAOInterface {

	
	private DbConnection c;

	
	public BankAccountDetailsDAOImpl(DbConnection c) {
		this.c = c;
	}
	
	
	@Override
	public List<BankAccountDetailsDAOImpl> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountDetailsDAOImpl getByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountDetailsDAOImpl getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BankAccountDetailsDAOImpl getByUserName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(BankAccountDetailsDAOImpl entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(BankAccountDetailsDAOImpl entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(BankAccountDetailsDAOImpl entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double checkBalance(int accountNumber) {
		
		double balance =0.0;
		try(Connection con = c.getDBConnection()){
			
			String sql = "select balance, transactiontype from AccountDetails where accountNumber=?";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, accountNumber);
			ResultSet rs  = ps.executeQuery();
			
			
			while(rs.next())
			{
				if(rs.getString(2).equals("Deposit"))
				{
					balance = balance + rs.getDouble(1);
				}
				else
				{
					balance = balance - rs.getDouble(1);
				}
				
			}

			return balance;
		}
		
		catch(SQLException e) {
			e.printStackTrace();
		}
		return balance;
	}
		

	

	@Override
	public void deposit(BankAccountDetailsModel entity) {
		try(Connection con = c.getDBConnection()){
			
			String sql = "INSERT INTO AccountDetails(accountNumber, userId, balance, transactionType) VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			//ps.setInt(1, entity.getAccountNumber());
			ps.setInt(1, entity.getAccountNumber());
			ps.setInt(2, entity.getUserId());
			ps.setDouble(3, entity.getBalance());
			ps.setString(4, entity.getTransactionType());
			ps.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public double withdraw(BankAccountDetailsModel entity) {
		try(Connection con = c.getDBConnection()){
			
			String sql = "INSERT INTO AccountDetails(accountNumber, userId, balance, transactionType) VALUES(?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);

			//ps.setInt(1, entity.getAccountNumber());
			ps.setInt(1, entity.getAccountNumber());
			ps.setInt(2, entity.getUserId());
			ps.setDouble(3, entity.getBalance());
			ps.setString(4, entity.getTransactionType());
			ps.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	

}
