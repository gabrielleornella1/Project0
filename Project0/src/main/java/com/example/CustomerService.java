package com.example;

import DAO.UserDAOImpl;
import users.UserModel;

//A service class is the middle man between your ui/controller and the dao layer, that should house your apps core
//business logic along with validation
public class CustomerService {
	
	private UserDAOImpl ccDao;
	
	    public CustomerService() {
			// TODO Auto-generated constructor stub
		}
	    
	    public CustomerService(UserDAOImpl ccDao) {
	    	this.ccDao=ccDao;
			
		}
	    
	    public UserModel getCustomerByUserName(String username) {
	    	UserModel userName = ccDao.getByUserName(username);
	    	if(userName == null) {
	    		throw new NullPointerException("There isn't a customer with username: " + userName);
	    	}
	    	return userName;
	    	
	    	
	    }
	    
	    
	    
	    
	    
	
 
}
