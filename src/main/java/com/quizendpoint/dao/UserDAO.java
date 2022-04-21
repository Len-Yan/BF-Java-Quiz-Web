package com.quizendpoint.dao;

import java.util.List;

import com.quizendpoint.domain.User;
import com.quizendpoint.exception.IdNotFoundException;

public interface UserDAO {

	User getUser(String username);
	int createUser(User user);
	
	List<User> getAllUser();
	User changeStatusById(int id) throws IdNotFoundException;
	User throwIdExcetpion() throws IdNotFoundException;
	User getUserById(int id) throws IdNotFoundException;
}
