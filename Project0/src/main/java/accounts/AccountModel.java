package accounts;

public class AccountModel {
	private int Accountnumber ;
	private String Type;
	private float Balance;
	private int Userid;
	private boolean Active;
	private String Transtype;
	private String Transferacc;
	
	public AccountModel() {
		// TODO Auto-generated constructor stub
	}

	public AccountModel(int accountnumber, String type, float balance, int userid, boolean active, String transtype,
			String transferacc) {
		super();
		Accountnumber = accountnumber;
		Type = type;
		Balance = balance;
		Userid = userid;
		Active = active;
		Transtype = transtype;
		Transferacc = transferacc;
	}

	public int getAccountnumber() {
		return Accountnumber;
	}

	public void setAccountnumber(int accountnumber) {
		Accountnumber = accountnumber;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public float getBalance() {
		return Balance;
	}

	public void setBalance(float balance) {
		Balance = balance;
	}

	public int getUserid() {
		return Userid;
	}

	public void setUserid(int userid) {
		Userid = userid;
	}

	public boolean isActive() {
		return Active;
	}

	public void setActive(boolean active) {
		Active = active;
	}

	public String getTranstype() {
		return Transtype;
	}

	public void setTranstype(String transtype) {
		Transtype = transtype;
	}

	public String getTransferacc() {
		return Transferacc;
	}

	public void setTransferacc(String transferacc) {
		Transferacc = transferacc;
	}

	@Override
	public String toString() {
		return "AccountModel [Accountnumber=" + Accountnumber + ", Type=" + Type + ", Balance=" + Balance + ", Userid="
				+ Userid + ", Active=" + Active + ", Transtype=" + Transtype + ", Transferacc=" + Transferacc + "]";
	}
	
	
	
	

}
