package DAO;

import java.util.List;

public interface GenericDao <T>{
	
	List<T> getAll();
	T getByName(String name);
	T getById(int id);
	T getByUserName(String username);

	void update(T entity);
	void insert(T entity);
	void delete(T entity);

}
