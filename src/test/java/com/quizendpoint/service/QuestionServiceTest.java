package com.quizendpoint.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.quizendpoint.dao.imp.QuestionhibernateDao;
import com.quizendpoint.domain.Question;
import com.quizendpoint.exception.IdNotFoundException;

@ExtendWith(MockitoExtension.class)
public class QuestionServiceTest {

	@InjectMocks
	QuestionService questionService;
	
	@Mock
	QuestionhibernateDao questionhibernateDAO;
	
	Question q1;
	Question q2;
	List<Question> qls;
	
	@BeforeEach
	void setup() {
		q1 = new Question(1, "test question", 2);
		q2 = null;
		qls = new ArrayList<>();
	}
	
	@Test
	void testGetQuesiton_goodId() throws IdNotFoundException {
		when(questionhibernateDAO.getQuestion(1)).thenReturn(q1);
		
		assertEquals(questionService.getQuestion(1), q1);
	}
	
	@Test 	
	void testGetQuestion() {
		qls.add(q1);
		when(questionhibernateDAO.getQuestionbyCat(2)).thenReturn(qls);
		assertEquals(questionService.getQuestions(2), qls);
	}
	
	@Test
	void testAddQuestionObj() {
		when(questionhibernateDAO.addQuestionObj(q1)).thenReturn(q1);
		assertEquals(questionService.addQuestionObj(q1), q1);
	}
	
//	@Test
//	void testThrowIdException() {
//		assertThrows(IdNotFoundException.class, ()-> questionService.throwIdException());
//	}
	
	
	@Test
	void testGetQuestionInfoAsync() throws IdNotFoundException, InterruptedException, ExecutionException {
		when(questionhibernateDAO.getQuestion(1)).thenReturn(q1);
		
		assertEquals(questionService.getQuestionInfoAsync(1).get(), q1);
	}
	
}
