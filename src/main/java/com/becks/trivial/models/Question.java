package com.becks.trivial.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Question {
	
	private int response_code; 
	
	private List<Result> results; 
	
	public Question () {
		
	}

	public int getResponse_code() {
		return response_code;
	}

	public void setResponse_code(int response_code) {
		this.response_code = response_code;
	}

	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	
	

}
