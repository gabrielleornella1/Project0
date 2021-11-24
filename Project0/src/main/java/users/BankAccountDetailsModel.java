package users;

public class BankAccountDetailsModel {
	
	private int accountNumber;
	private int userId;
	private double balance;
	private String transactionType;
	
	
	public BankAccountDetailsModel()
	{
		
	}
	
	public BankAccountDetailsModel(int accountNumber, int userId, double balance, String transactionType) {
		super();
		this.accountNumber = accountNumber;
		this.userId = userId;
		this.balance = balance;
		this.transactionType = transactionType;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	
	
	@Override
	public String toString() {
		return "BankAccountDetailsModel [accountNumber=" + accountNumber + ", userId=" + userId + ", balance=" + balance
				+ ", transactionType=" + transactionType + "]";
	}
	
	
	

}
