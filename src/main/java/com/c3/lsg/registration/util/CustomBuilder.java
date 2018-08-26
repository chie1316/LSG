/**
 * 
 */
package com.c3.lsg.registration.util;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.c3.lsg.registration.dto.ResponseListObject;
import com.c3.lsg.registration.dto.ResponseObject;

/**
 * @author archie.ramirez
 *
 */
@Component
public class CustomBuilder {

	private static final String COLON_SPACE = ", ";
	private static final String SPACE = " ";

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

	/*
	 * builds full name
	 */
	public static String buildName(String firstName, String middleName, String lastName) {
		StringBuilder fullName = new StringBuilder();
		if (StringUtils.isEmpty(middleName)) {
			fullName.append(lastName);
			fullName.append(COLON_SPACE);
			fullName.append(firstName);
		} else {
			fullName.append(lastName);
			fullName.append(COLON_SPACE);
			fullName.append(firstName);
			fullName.append(SPACE);
			fullName.append(middleName);
		}
		return fullName.toString();
	}
}
