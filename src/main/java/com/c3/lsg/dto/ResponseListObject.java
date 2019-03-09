/**
 * 
 */
package com.c3.lsg.dto;

/**
 * @author archie.ramirez
 * @param <T>
 *
 */
public class ResponseListObject<T> extends ResponseObject {

	/**
	 * Default
	 */
	public ResponseListObject() {
		super();
	}

	/**
	 * @param data
	 */
	public ResponseListObject(T data) {
		super();
		this.data = data;
	}

	/**
	 * @param code
	 * @param title
	 * @param message
	 * @param data
	 */
	public ResponseListObject(int code, String title, String message, T data) {
		super(code, title, message);
		this.data = data;
	}

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
