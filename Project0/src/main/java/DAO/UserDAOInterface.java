package DAO;

import java.util.List;

import users.UserModel;

public interface UserDAOInterface extends GenericDao<UserModel>  {
	List<UserModel> findById(int customer_id);

	 UserModel getByUserNameAndType(String username, String userType);
	 
}
