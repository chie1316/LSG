/**
 * 
 */
package com.c3.lsg.dto;

/**
 * @author archie.ramirez
 *
 */
public class ResponseObject {

	/**
	 * Default
	 */
	public ResponseObject() {
		super();
	}

	/**
	 * @param code
	 * @param title
	 * @param message
	 */
	public ResponseObject(int code, String title, String message) {
		super();
		this.code = code;
		this.title = title;
		this.message = message;
	}

	private int code;

	private String title;

	private String message;

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
