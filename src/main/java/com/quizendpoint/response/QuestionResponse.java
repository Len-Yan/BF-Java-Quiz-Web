package com.quizendpoint.response;

import java.util.List;

import com.quizendpoint.domain.Option;
import com.quizendpoint.domain.Question;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class QuestionResponse {
	private String category;
	private String Content;
	private List<Option> options;
}
