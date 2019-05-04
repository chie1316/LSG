/**
 * 
 */
package com.c3.lsg.util;

import org.springframework.stereotype.Component;

import com.c3.lsg.dto.ResponseListObject;
import com.c3.lsg.dto.ResponseObject;

/**
 * @author archie.ramirez
 *
 */
@Component
public class CustomBuilder {

	private CustomBuilder() {
	}

	/*
	 * builds response message
	 */
	public static ResponseObject buildResponse(int code, String title, String message) {
		ResponseObject responseObject = new ResponseObject();
		responseObject.setCode(code);
		responseObject.setMessage(message);
		responseObject.setTitle(title);
		return responseObject;
	}

	/*
	 * builds list response message
	 */
	public static <T> ResponseListObject<T> buildListResponse(int code, String title, String message, T data) {
		ResponseListObject<T> responseListObject = new ResponseListObject<>();
		responseListObject.setCode(code);
		responseListObject.setMessage(message);
		responseListObject.setTitle(title);
		responseListObject.setData(data);
		return responseListObject;
	}
}
