package com.quizendpoint.service;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.quizendpoint.dao.QuestionDAO;
import com.quizendpoint.dao.imp.QuestionhibernateDao;
import com.quizendpoint.domain.Question;
import com.quizendpoint.domain.User;
import com.quizendpoint.exception.IdNotFoundException;

@Component
@Service
public class QuestionService {
	private QuestionDAO questionDaojdbc;
	
	@Autowired
	public void setquesitondaojdbc(QuestionDAO questionjdbc) {
		questionDaojdbc = questionjdbc;
	}
	@Transactional
	public Question getQuestion(int id) throws IdNotFoundException{
		return questionDaojdbc.getQuestion(id);
	}
	@Transactional
	public List<Question> getQuestions(int catid) {
		return questionDaojdbc.getQuestionbyCat(catid);
	}
	@Transactional
	public Question addQuestionObj(Question q) {
		questionDaojdbc.addQuestionObj(q);
		return q;
	}
	
	public Question throwIdException() throws IdNotFoundException{
		return questionDaojdbc.throwQuestionExcption();
	}
	
    @Async("taskExecutor")
    public CompletableFuture<Question> getQuestionInfoAsync(int id) throws IdNotFoundException{
         Question q = questionDaojdbc.getQuestion(id);
         return CompletableFuture.completedFuture(q);
    }
}
