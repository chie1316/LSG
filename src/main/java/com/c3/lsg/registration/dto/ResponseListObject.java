/**
 * 
 */
package com.c3.lsg.registration.dto;

/**
 * @author archie.ramirez
 * @param <T>
 *
 */
public class ResponseListObject<T> extends ResponseObject {

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

}
