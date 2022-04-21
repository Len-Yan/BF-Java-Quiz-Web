package com.quizendpoint.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "qoption")
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Option implements Serializable{

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "question_id")
	private int question_id;
	
	@Column(name = "isCorrect")
	private boolean isCorrect;
	
	
	//private int answer_id;
}
