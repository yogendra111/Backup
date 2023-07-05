package com.hibernate;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "ans")
public class Answer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String answer;
	
//	@ManyToMany
//	List<Question> questions;
	
//	@ManyToOne
//	Question question;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
//	public List<Question> getQuestions() {
//		return questions;
//	}
//	public void setQuestions(List<Question> questions) {
//		this.questions = questions;
//	}
	
//	public Question getQuestion() {
//		return question;
//	}
//	public void setQuestion(Question question) {
//		this.question = question;
//	}
	
}
