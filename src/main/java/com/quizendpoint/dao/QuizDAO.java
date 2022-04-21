package com.quizendpoint.dao;

import java.time.LocalDateTime;

import com.quizendpoint.domain.Quiz;

public interface QuizDAO {

	Quiz getQuiz(int id);
	Quiz createQuiz (int cate_id, LocalDateTime stime, int questionNum, String user);
	int submitQuiz(String user, LocalDateTime endtime);
}
