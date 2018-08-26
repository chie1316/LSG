/**
 * 
 */
package com.c3.lsg.registration.dto;

/**
 * @author archie.ramirez
 *
 */
public class ResponseObject {
	private int code = 200;

	private String title = "SUCCESS";

	private String message = "Success.";

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
