package com.quizendpoint.service;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import org.hibernate.mapping.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.quizendpoint.dao.imp.UserDAOHibernate;
import com.quizendpoint.domain.User;
import com.quizendpoint.exception.IdNotFoundException;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@InjectMocks
	UserService userService;
	
	@Mock
	UserDAOHibernate userDAOHibernate;
	
	User mockuser, mockuser2; 
	
	@BeforeEach
	void setup() {
		mockuser = new User(1, "testuser", "123", "tester", "A", true, false);
		mockuser2 = new User();
	}
	
	@Test
	void testGetuser() {
		when(userDAOHibernate.getUser("testuser")).thenReturn(mockuser);
		
		User u = userService.getuser("testuser");
		assertEquals(mockuser, u);
	}
	
	@Test
	void testNewuser_success() {
		when(userDAOHibernate.createUser(mockuser)).thenReturn(1);
		
		assertTrue(userService.newuser(mockuser));
	}
	
	@Test
	void testNewuser_fail() {
		when(userDAOHibernate.createUser(mockuser2)).thenReturn(-1);
		
		assertFalse(userService.newuser(mockuser2));
	}
	
	@Test
	void testGetAllUser() {
		ArrayList<User> mockls = new ArrayList<>();
		mockls.add(mockuser);
		when(userDAOHibernate.getAllUser()).thenReturn(mockls);
	
		assertEquals(userService.getAllUser(), mockls);
	}
	
	@Test
	void testGetActive() {
		assertEquals(userService.getActive(mockuser), false);
	}
	
	@Test
	void testChangeActive() {
		userService.changeActive(mockuser);
		assertEquals(mockuser.isSuspend(), true);
	}
	
	@Test
	void testChangeStatusById_goodId() throws IdNotFoundException {
		mockuser.setSuspend(true);
		when(userDAOHibernate.changeStatusById(1)).thenReturn(mockuser);
		
		assertEquals(userService.changeStatusById(1),mockuser);
	}
	
	@Test
	void testChangeStatusById_badId() throws IdNotFoundException {
		when(userDAOHibernate.changeStatusById(10)).thenThrow(new IdNotFoundException("Id not found"));
		assertThrows(IdNotFoundException.class, ()-> userService.changeStatusById(10));
	}
	
	@Test
	void testGetUserInfoAsync() throws IdNotFoundException, InterruptedException, ExecutionException {
		when(userDAOHibernate.getUserById(1)).thenReturn(mockuser);
		
		assertEquals(userService.getUserInfoAsync(1).get(), mockuser);
	}
	
	
}
