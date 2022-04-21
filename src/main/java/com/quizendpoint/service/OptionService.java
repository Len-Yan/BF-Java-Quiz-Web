package com.quizendpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.quizendpoint.dao.OptionDao;
import com.quizendpoint.domain.Option;
import com.quizendpoint.exception.IdNotFoundException;

@Component
public class OptionService {
	private OptionDao optiondaoJDBC;
	
	@Autowired
	public void setOptionDaoJDBC(OptionDao optiondao) {
		optiondaoJDBC = optiondao;
	}
	
	public Option getRightoption(int id) {
		return optiondaoJDBC.getRightOption(id);
	}
	
	public List<Option> getoptionbyquestion(int question_id) throws IdNotFoundException{
		return optiondaoJDBC.getOption(question_id);
		
	}
}
