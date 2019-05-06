/**
 * 
 */
package com.c3.lsg.validation;

import static com.c3.lsg.constants.ResponseConstant.CODE_FAILED;
import static com.c3.lsg.constants.ResponseConstant.TITLE_REQUIRED;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.c3.lsg.dto.FilterDto;
import com.c3.lsg.dto.NewGuestRequest;
import com.c3.lsg.dto.NewMemberRequest;
import com.c3.lsg.dto.SortDto;
import com.c3.lsg.dto.UpdateGuestRequest;
import com.c3.lsg.exeception.CustomException;

/**
 * @author archie.ramirez
 *
 */
@Component
public class InputValidator {

	private static final Logger log = LoggerFactory.getLogger(InputValidator.class);

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

		if (isEmptyStr(request.getBirthDate())) {
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
	 * This method will validate Incoming requests from updateGuest Controller.
	 * 
	 * @throws CustomException
	 */
	public void updateGuest(UpdateGuestRequest request) throws CustomException {
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

		if (isEmptyStr(request.getBirthDate())) {
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

	public static Pageable pageValidator(FilterDto request) {
		Pageable pageRequest = null;
		if (request != null) {
			
			if (request.getPage() == null) {
				request.setPage(0);
			}

			if (request.getLimit() == null) {
				request.setLimit(10);
			}

			pageRequest = PageRequest.of(request.getPage(), request.getLimit());

			List<SortDto> sortList = request.getSortList();
			if (sortList != null) {
				log.info("sort not null");

				if (!sortList.isEmpty()) {
					for (SortDto sortData : sortList) {

						if (!StringUtils.isEmpty(sortData.getSortBy())
								&& !StringUtils.isEmpty(sortData.getSortOrder())) {
							pageRequest = PageRequest.of(request.getPage(), request.getLimit(),
									Sort.Direction.fromString(sortData.getSortOrder()), sortData.getSortBy());
						}
					}
				}
			}
		} else {
			pageRequest = PageRequest.of(0, 10);
		}
		return pageRequest;
	}
}
