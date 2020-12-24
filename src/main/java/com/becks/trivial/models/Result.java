package com.becks.trivial.models;

import java.util.List;

public class Result {
//	{
	private String category; 
	//        "category": "Entertainment: Film",
	private String type; 
	//        "type": "multiple",
	private String difficulty; 
	//        "difficulty": "medium",
	private String question; 
	//        "question": "Mark Wahlberg played the titular character of which 2008 video-game adaptation?",
	private String correct_answer; 
	//        "correct_answer": "Max Payne",
	private List<String> incorrect_answers; 
//	        "incorrect_answers": [
//            "Alan Wake",
//            "Hitman",
//            "God Of War"
	
	public Result () {
		
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getCorrect_answer() {
		return correct_answer;
	}

	public void setCorrect_answer(String correct_answer) {
		this.correct_answer = correct_answer;
	}

	public List<String> getIncorrect_answers() {
		return incorrect_answers;
	}

	public void setIncorrect_answers(List<String> incorrect_answers) {
		this.incorrect_answers = incorrect_answers;
	}
	
	
}
