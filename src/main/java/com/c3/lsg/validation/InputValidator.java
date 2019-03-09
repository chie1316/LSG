/**
 * 
 */
package com.c3.lsg.validation;

import static com.c3.lsg.constants.ResponseConstant.CODE_FAILED;
import static com.c3.lsg.constants.ResponseConstant.TITLE_REQUIRED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.c3.lsg.dto.NewGuestRequest;
import com.c3.lsg.dto.NewMemberRequest;
import com.c3.lsg.exeception.CustomException;

/**
 * @author archie.ramirez
 *
 */
@Component
public class InputValidator {

	@Autowired
	private Environment env;

	/**
	 * This method will validate an String if it is Empty/null or not.
	 * 
	 * @param str
	 * @return
	 */
	private boolean isEmptyStr(Object str) {
		return StringUtils.isEmpty(str);
	}

	/**
	 * This method will validate an Integer if it is null or not.
	 * 
	 * @param num
	 * @return
	 */
	private boolean isEmptyInt(Integer num) {

		boolean isEmpty = false;
		if (num == null) {
			isEmpty = true;
		}

		return isEmpty;
	}

	/**
	 * This method will validate Incoming requests from addGuest Controller.
	 * 
	 * @throws CustomException
	 */
	public void addGuest(NewGuestRequest request) throws CustomException {
		boolean hasError = false;
		StringBuilder errorMessage = new StringBuilder();

		if (isEmptyStr(request.getFirstName())) {
			hasError = true;
			errorMessage.append("First Name is required.");
			errorMessage.append("\n");
		}

		if (isEmptyStr(request.getLastName())) {
			hasError = true;
			errorMessage.append("Last Name is required.");
			errorMessage.append("\n");
		}

		if (isEmptyInt(request.getAge())) {
			hasError = true;
			errorMessage.append("Age is required.");
			errorMessage.append("\n");
		}

		if (isEmptyStr(request.getAddress())) {
			hasError = true;
			errorMessage.append("Address is required.");
			errorMessage.append("\n");
		}

		if (hasError) {
			throw new CustomException( //
					Integer.valueOf(env.getProperty(CODE_FAILED)), //
					env.getProperty(TITLE_REQUIRED), //
					errorMessage.toString());
		}
	}

	/**
	 * This method will validate Incoming requests from addMember Controller.
	 * 
	 * @param request
	 * @throws CustomException
	 */
	public void addMember(NewMemberRequest request) throws CustomException {
		boolean hasError = false;
		StringBuilder errorMessage = new StringBuilder();

		if (isEmptyStr(request.getFirstName())) {
			hasError = true;
			errorMessage.append("First Name is required.");
			errorMessage.append("\n");
		}

		if (isEmptyStr(request.getLastName())) {
			hasError = true;
			errorMessage.append("First Name is required.");
			errorMessage.append("\n");
		}

		if (hasError) {
			throw new CustomException( //
					Integer.valueOf(env.getProperty(CODE_FAILED)), //
					env.getProperty(TITLE_REQUIRED), //
					errorMessage.toString());
		}
	}
}
