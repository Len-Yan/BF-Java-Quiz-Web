package com.quizendpoint.dao;

import java.util.List;

import com.quizendpoint.domain.Question;
import com.quizendpoint.exception.IdNotFoundException;

public interface QuestionDAO {

	Question getQuestion(int question_id) throws IdNotFoundException;
	
	List<Question> getQuestionbyCat(int cat_id); 
	
	List<Question> getXquestionbyCat(int cat_id, int questionNum);
	List<Question> getAllQuestion();
	
	Integer getQuestionCount();
	Question addQuestion(int cat_id, String content);
	Question addQuestionObj(Question q);
	Question throwQuestionExcption() throws IdNotFoundException;
}
