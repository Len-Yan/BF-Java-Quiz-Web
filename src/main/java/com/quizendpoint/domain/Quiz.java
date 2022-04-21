package com.quizendpoint.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="QuizSubmission")
@Data
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "startTime")
	private LocalDateTime startTime;
	
	@Column(name = "endTime")
	private LocalDateTime endTime;
	
	@Column(name = "score")
	private Integer score;
	
	@Column(name = "userid")
	private Integer userid;
	
	@Column(name = "quiz_id")
	private Integer quiz_id;
	
	//private List<Integer> selected;
	//private List<Question> question;	// 10 question in certain quiz
	
	
}
