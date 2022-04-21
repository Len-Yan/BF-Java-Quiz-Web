package com.quizendpoint.dao;

import java.util.List;

import com.quizendpoint.domain.Option;

public interface OptionDao {

	List<Option> getOption(int question_id);
	
	Option getRightOption(int question_id);
}
