package com.quizendpoint.response;

import java.util.List;

import com.quizendpoint.domain.Option;
import com.quizendpoint.domain.Question;
import com.quizendpoint.domain.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class User_QuestionResponse {
	private User user;
	private Question question;
}
