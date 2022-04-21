package com.quizendpoint.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "Question")
@Data
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Question implements Serializable{
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int question_id;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "category_id")
	private int category_id;
	
	//private String category;
	
	//@ElementCollection
	//private List<Option> options;	// currently 4 option per question
	//@ElementCollection
	//private List<Question> questions;

}
