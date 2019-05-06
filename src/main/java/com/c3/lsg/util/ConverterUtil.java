/**
 * 
 */
package com.c3.lsg.util;

import static com.c3.lsg.constants.DataConstants.DATE_SLASHED_FORMAT;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.util.StringUtils;

import com.c3.lsg.exeception.CustomException;
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

	public static Date stringToDate(String dateStr) throws CustomException {
		Date newDate = null;

		if (!StringUtils.isEmpty(dateStr)) {
			SimpleDateFormat fromatter = new SimpleDateFormat(DATE_SLASHED_FORMAT);

			try {
				newDate = fromatter.parse(dateStr);
			} catch (ParseException e) {
				throw new CustomException(400, "ERROR", "Unable to parse String to date");
			}

		}

		return newDate;
	}

	public static String dateToString(Date date) {
		String strDate = null;

		if (date != null) {
			SimpleDateFormat fromatter = new SimpleDateFormat(DATE_SLASHED_FORMAT);
			strDate = fromatter.format(date);
		}

		return strDate;
	}
}
