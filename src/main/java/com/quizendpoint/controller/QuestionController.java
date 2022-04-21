package com.quizendpoint.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.quizendpoint.dao.OptionDao;
import com.quizendpoint.dao.QuestionDAO;
import com.quizendpoint.domain.Option;
import com.quizendpoint.domain.Question;
import com.quizendpoint.exception.IdNotFoundException;
import com.quizendpoint.request.addQuestionRequest;
import com.quizendpoint.response.QuestionResponse;

import lombok.Builder;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionDAO questionDAO;
	
	@Autowired
	OptionDao optionDao;
	
	@GetMapping()
	public List<Question> getAllQuestions(){
		List<Question> q = questionDAO.getAllQuestion();
		
		return q;
	}
	
	@GetMapping("/{id}")
	public QuestionResponse getQuestionById(@PathVariable Integer id) throws IdNotFoundException {
		Question q = questionDAO.getQuestion(id);
		String catStr = "";
		//just hard code category id -> string
		if(q.getCategory_id() == 1) catStr = "Math";
		else if(q.getCategory_id() == 1) catStr = "Java";
		else {catStr = "else";}
		
		//need add Option List later
		
		List<Option> optlist = optionDao.getOption(id);
		
		QuestionResponse qr = QuestionResponse.builder()
				.category(catStr).Content(q.getContent()).options(optlist).build();
		
		return qr;
	}
	/*
	@PostMapping("/add_question")
	public QuestionResponse addQuestion(@RequestParam Integer Category_id, @RequestParam String content, @RequestParam List<Option> optlist) {
		Question q = questionDAO.addQuestion(Category_id, content);
		
		
		
		QuestionResponse qr = QuestionResponse.builder()
				.category(Category_id+"").Content(q.getContent()).build();
		return qr;
	}
	*/
	
	@PostMapping("/add_question")
	public QuestionResponse addQuestion(@RequestBody addQuestionRequest request) {
		Question q = Question.builder().category_id(request.getCategoryId())
				.content(request.getContent()).build();
		
		questionDAO.addQuestionObj(q);
		
		
		QuestionResponse qr = QuestionResponse.builder()
				.category(request.getCategoryId()+"").Content(q.getContent()).build();
		return qr;
	}
	
}
