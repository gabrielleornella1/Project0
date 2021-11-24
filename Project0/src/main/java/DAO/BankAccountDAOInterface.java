package DAO;
import users.BankAccountModel;

public interface BankAccountDAOInterface extends GenericDao <BankAccountModel>{
	
	BankAccountModel  getAccountByNumber(int accountNumber);
	
	void approveAccount(int accountNumber);
}
