package com.quizendpoint.dao.imp;

import java.util.List;

import javax.persistence.Query;
import org.springframework.stereotype.Repository;

import com.quizendpoint.dao.AbstractHibernateDAO;
import com.quizendpoint.dao.UserDAO;
import com.quizendpoint.domain.User;
import com.quizendpoint.exception.IdNotFoundException;

@Repository("userDAOHibernate")
public class UserDAOHibernate extends AbstractHibernateDAO<User> implements UserDAO {
	
	@Override
	public User getUser(String username) {
	        Query query = getCurrentSession().createQuery("from User u where u.username = :username");
	        query.setParameter("username", username);
	        List<User> u = query.getResultList();
	     
		return u.size() == 0 ? null : u.get(0);
	}

	@Override
	public int createUser(User user) {
		if(user.getFirstname().length()< 1 || user.getLastname().length()< 1 || user.getPassword().length()< 1 || user.getUsername().length()< 1
				|| getUser(user.getUsername()) != null ) {
			return -1;
		}
		user.setSuspend(false);
		//persist not work, show detatched pass to pressits
		getCurrentSession().save(user);
		//getCurrentSession().getTransaction().commit();
		return 1;
	}

	@Override
	public List<User> getAllUser() {
		List<User> users = getCurrentSession().createQuery("from User").list();
		 
		return users;
	}
	
	public User changeStatusById(int id) throws IdNotFoundException{
        Query query = getCurrentSession().createQuery("from User u where u.id = :id");
        query.setParameter("id", id);
        List<User> us = query.getResultList();
        User u =  us.size() == 0 ? null : us.get(0);
        if(u == null) {throw new IdNotFoundException("User Id not foundx");}
        u.setSuspend(!u.isSuspend());
		return u;
	}

	public User throwIdExcetpion() throws IdNotFoundException{
		throw new IdNotFoundException("User Id not found");
	}

	@Override
	public User getUserById(int id) throws IdNotFoundException {
        Query query = getCurrentSession().createQuery("from User u where u.id = :id");
        query.setParameter("id", id);
        List<User> u = query.getResultList();
     
	return u.size() == 0 ? null : u.get(0);
	}
}
