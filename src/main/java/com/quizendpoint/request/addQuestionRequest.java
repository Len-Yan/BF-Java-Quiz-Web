package com.quizendpoint.request;

import java.util.List;

import com.quizendpoint.domain.Option;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class addQuestionRequest {
	private Integer categoryId;
	private String content;
	private List<Option> options;
}
