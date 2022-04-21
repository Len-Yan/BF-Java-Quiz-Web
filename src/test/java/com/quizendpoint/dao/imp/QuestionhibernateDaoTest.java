package com.quizendpoint.dao.imp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.quizendpoint.domain.Question;
import com.quizendpoint.exception.IdNotFoundException;

@ActiveProfiles(value = "test")
@SpringBootTest
public class QuestionhibernateDaoTest {
	
	@Autowired
	QuestionhibernateDao questionhibernateDAO;
	
	Question q1;
	Question q2;
	List<Question> qlist;
	
	@BeforeEach
	void setup() {
		q1 = new Question(1, "test question", 1);
		q2 = new Question(5, "test question", 1);
		qlist = new ArrayList<>(); qlist.add(q1);
	}
	
	@Test
	@Transactional
	void testAddQuestion_ByQuesitonObj() {
		assertEquals(q1, questionhibernateDAO.addQuestionObj(q1));
	}
	
	@Test
	@Transactional
	void testAddQuestion_bycontent() {
		assertEquals(q2, questionhibernateDAO.addQuestion(1, "test question"));
	}
	
	@Test
	@Transactional
	void testGetQuestion() throws IdNotFoundException {
		questionhibernateDAO.addQuestionObj(q1);
		//assertEquals(q2,questionhibernateDAO.getQuestion(1));
		assertThrows(IdNotFoundException.class, () -> questionhibernateDAO.getQuestion(-1));
	}
	
	@Test
	@Transactional
	void testGetAllQuesiton() {
		questionhibernateDAO.addQuestionObj(q1);
		assertEquals(qlist, questionhibernateDAO.getAllQuestion());
	}
	
//	@Test
//	@Transactional
//	void testGetQuesitonByCat() {
//		questionhibernateDAO.addQuestionObj(q1);
//		assertEquals(qlist, questionhibernateDAO.getQuestionbyCat(2));
//	}
	
//	@Test
//	@Transactional
//	void testGetXQuesitonbyCat() {
//		assertEquals(qlist, questionhibernateDAO.getXquestionbyCat(1, 1));
//	}
	
	@Test
	@Transactional
	void testGetQuestionCount() {
		questionhibernateDAO.addQuestionObj(q1);
		assertEquals(1, questionhibernateDAO.getQuestionCount());
	}
	
}
