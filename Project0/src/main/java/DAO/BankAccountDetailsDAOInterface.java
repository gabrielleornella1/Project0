package DAO;

import users.BankAccountDetailsModel;

public interface BankAccountDetailsDAOInterface extends GenericDao<BankAccountDetailsDAOImpl> {
	
	
	double checkBalance(int accountNumber);
	void deposit(BankAccountDetailsModel entity);
	double withdraw(BankAccountDetailsModel entity);
	

}
