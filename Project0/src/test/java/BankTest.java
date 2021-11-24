import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import DAO.CustomerDAO;
import DAO.DbConnection;
import users.UserModel;

public class BankTest {
	
	public static DbConnection con = new DbConnection();
	public static CustomerDAO cDao = new CustomerDAO(con);
	public static UserModel c = null;

	@Test
	public void insertCustomer() {
		c = new UserModel(129, "thomas", "P4ssw0rd", "cute", "Gabrielle.Obiang@revature.net", "sdfsaf");
		cDao.insert(c);
		assertEquals("thomas", c.getUsername());
		assertEquals("P4ssw0rd", c.getPassword());
	}

}
