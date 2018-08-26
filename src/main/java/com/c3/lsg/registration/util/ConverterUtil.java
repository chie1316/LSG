/**
 * 
 */
package com.c3.lsg.registration.util;

import org.springframework.stereotype.Component;

import com.google.gson.Gson;

/**
 * @author archie.ramirez
 *
 */
@Component
public class ConverterUtil {

	public String objectToString(Object o) {
		Gson gson = new Gson();
		String jsonInString = gson.toJson(o);
		return jsonInString;
	}
}
