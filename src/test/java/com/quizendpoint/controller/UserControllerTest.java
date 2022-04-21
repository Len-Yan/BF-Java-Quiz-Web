package com.quizendpoint.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.quizendpoint.service.UserService;

@WebMvcTest(UserController.class)
@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	UserService userService;
	
	@BeforeEach
	void init() {
		
	}
	
	
	
	
	
	
	
	
	
}
