/**
 * 
 */
package com.c3.lsg.registration.util;

import com.google.gson.Gson;

/**
 * @author archie.ramirez
 *
 */
public class ConverterUtil {

	private ConverterUtil() {
	}

	public static String objectToString(Object o) {
		Gson gson = new Gson();
		return gson.toJson(o);
	}
}
