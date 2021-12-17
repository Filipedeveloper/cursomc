package com.example.cursomc.resources.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ValidationError extends StandardError {
	private static final long serialVersionUID = 1L;
	
	private List<FildMessage> erros = new ArrayList<>();

	public ValidationError(Integer status, String msg, Long timestamp) {
		super(status, msg, timestamp);
		
	}

	public List<FildMessage> getErrors() {
		return erros;
	}

	public void addError(String fieldName, String message) {
		erros.add(new FildMessage( fieldName,message));
	}

}
