package com.quizendpoint.dao.imp;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.quizendpoint.domain.User;
import com.quizendpoint.exception.IdNotFoundException;

@ActiveProfiles(value = "test")
@SpringBootTest
public class UserDAOHibernateTest {

	@Autowired
	UserDAOHibernate userDAOHibernate;
	
	User mockUser;
	User mockUser2;
	
	@BeforeEach
	void setup() {
		mockUser = new User(1, "testuser", "123", "tester", "A", true, false);
		mockUser2 = new User(10, "", "","","",false, false);
	}
	@AfterEach
	void clean() {
		
	}
	
	@Test
	@Transactional
	void testCreateUser_success() {
		Integer i = userDAOHibernate.createUser(mockUser);
		assertEquals(i, 1);
	}
	
	@Test
	@Transactional
	void testCreateUser_fail() {
		Integer i = userDAOHibernate.createUser(mockUser2);
		assertEquals(i, -1);
	}
	
	
	@Test
	@Transactional
	void testGetUser_exist() {
		userDAOHibernate.createUser(mockUser);
		User user = userDAOHibernate.getUser("testuser");
		assertEquals( mockUser, user);
	}
	
	@Test
	@Transactional
	void testGetAllUser() {
		userDAOHibernate.createUser(mockUser);
		List<User> users = new ArrayList<>();
		users.add(mockUser);
		assertEquals(users, userDAOHibernate.getAllUser());
	}
	
	@Test
	@Transactional
	void testChangeStatusById_noneExist() throws IdNotFoundException {
		userDAOHibernate.createUser(mockUser);
		assertThrows(IdNotFoundException.class, () -> userDAOHibernate.changeStatusById(-1));
	}
	
	@Test
	@Transactional
	void testGetUserById() throws IdNotFoundException {
		userDAOHibernate.createUser(mockUser);
		assertEquals(mockUser, userDAOHibernate.getUserById(4));
	}
	
	
}
