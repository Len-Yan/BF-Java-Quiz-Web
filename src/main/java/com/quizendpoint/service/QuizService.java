package com.quizendpoint.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.quizendpoint.dao.QuizDAO;
import com.quizendpoint.domain.Question;

//@Component
public class QuizService {
	private QuizDAO quizdaojdbc;
	
	//@Autowired
	//@Qualifier("questionJdbcDao")
	public void setquizedaojdbc(QuizDAO quizjdbc) {
		quizdaojdbc = quizjdbc;
	}
	
	@Transactional
	public void addQuestion(String questioncontent) {
		
	}
	
	@Transactional
	public void addQuestion(Question q) {
		
	}
}
