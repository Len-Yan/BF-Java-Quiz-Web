package com.quizendpoint.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.quizendpoint.dao.UserDAO;
import com.quizendpoint.dao.imp.UserDAOHibernate;
import com.quizendpoint.domain.User;
import com.quizendpoint.exception.IdNotFoundException;

@Component
@Service
public class UserService {

	private UserDAO userdaojdbc;
	
	@Autowired
	@Qualifier("userDAOHibernate")
	public void setuserdaojdbc(UserDAO userdao) {
		userdaojdbc = userdao;
		//userDAOHibernate = userdao;
	}
	
	@Transactional
	public User getuser(String username) {
		return userdaojdbc.getUser(username);
	}
	@Transactional
	public boolean newuser(User user) {
		int i = userdaojdbc.createUser(user);
		
		return i > 0;
	}
	//@Transactional
	//public String getfirstname(User user) {
	//	return user.getFirstname();
	//}
	//@Transactional
	//public String getlastname(User user) {
	//	return user.getLastname();
	//}
	//@Transactional
	//public String getusrename(User user) {
	//	return user.getUsername();
	//}
	@Transactional
	public List<User> getAllUser(){
		return userdaojdbc.getAllUser();
	}
	@Transactional
	public boolean getActive(User user) {
		return user.isSuspend();
	}
	@Transactional
	public void changeActive(User user) {
		user.setSuspend(!user.isSuspend());
	}
	@Transactional
	public User changeStatusById(int id) throws IdNotFoundException{
		return userdaojdbc.changeStatusById(id);
	}
	
	public User throwIdException() throws IdNotFoundException{
		return userdaojdbc.throwIdExcetpion();
	}
	
    @Async("taskExecutor")
    public CompletableFuture<User> getUserInfoAsync(int id) throws IdNotFoundException{
         User user = userdaojdbc.getUserById(id);
         return CompletableFuture.completedFuture(user);
    }
}
