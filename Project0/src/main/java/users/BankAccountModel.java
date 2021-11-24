package users;

public class BankAccountModel {
	
	private int accountNumber;
	private String type;
	private int userId;
	private String state;
	
	
	
	public BankAccountModel(int accountNumber, String type, int userId, String state) {
		super();
		this.accountNumber = accountNumber;
		this.type = type;
		this.userId = userId;
		this.state = state;

	}



	public int getAccountNumber() {
		return accountNumber;
	}



	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}



	public String getType() {
		return type;
	}



	public void setType(String type) {
		this.type = type;
	}



	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public String isActive() {
		return state;
	}



	public void setActive(String active) {
		this.state = active;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	@Override
	public String toString() {
		return "BankAccountModel [accountNumber=" + accountNumber + ", type=" + type + ", userId=" + userId + ", state="
				+ state + "]";
	}
	
	
	
	


}
