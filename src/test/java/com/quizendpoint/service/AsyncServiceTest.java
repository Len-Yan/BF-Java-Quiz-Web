package com.quizendpoint.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.concurrent.CompletableFuture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.quizendpoint.dao.imp.QuestionhibernateDao;
import com.quizendpoint.dao.imp.UserDAOHibernate;
import com.quizendpoint.domain.Question;
import com.quizendpoint.domain.User;
import com.quizendpoint.exception.IdNotFoundException;
import com.quizendpoint.response.User_QuestionResponse;

@ExtendWith(MockitoExtension.class)
public class AsyncServiceTest {
	
	
	@InjectMocks
	AsyncService asyncService;
	
	@Mock
	UserService userService;
	
	@Mock
	QuestionService questionService;
	
	User user;
	Question question;
	CompletableFuture<User> mockUserFuture;
	CompletableFuture<Question> mockQuestionFuture;
	User_QuestionResponse mockResponse;
	
	@BeforeEach
	void setup() {
		user = new User(1, "testuser", "123", "tester", "A", true, false);
		question = new Question(1, "test question", 2);
		mockQuestionFuture = CompletableFuture.completedFuture(question);
		mockUserFuture= CompletableFuture.completedFuture(user);
		mockResponse = new User_QuestionResponse(user, question);
	}
	
	@Test
	void testGetAllInfoAsync() throws IdNotFoundException {
		when(userService.getUserInfoAsync(1)).thenReturn(mockUserFuture);
		when(questionService.getQuestionInfoAsync(1)).thenReturn(mockQuestionFuture);
		
		assertEquals(((User_QuestionResponse)asyncService.getAllInfoAsync(1)).getUser()
				, mockResponse.getUser());
		assertEquals(((User_QuestionResponse)asyncService.getAllInfoAsync(1)).getQuestion()
				, mockResponse.getQuestion());
	}
}
