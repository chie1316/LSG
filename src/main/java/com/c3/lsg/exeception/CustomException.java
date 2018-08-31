package com.c3.lsg.exeception;

public class CustomException extends Exception {
	
	private static final long serialVersionUID = -6785486887574538971L;
	private final Integer code;
	private final String title;
	private final String message;

	public CustomException(Integer code, String title, String message) {
		super();
		this.code = code;
		this.title = title;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	@Override
	public String getMessage() {
		return message;
	}
}
