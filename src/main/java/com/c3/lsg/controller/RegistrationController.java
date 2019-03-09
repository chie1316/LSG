/**
 * 
 */
package com.c3.lsg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c3.lsg.dto.GuestResponseDtl;
import com.c3.lsg.dto.NewGuestRequest;
import com.c3.lsg.dto.ResponseListObject;
import com.c3.lsg.dto.ResponseObject;
import com.c3.lsg.exeception.CustomException;
import com.c3.lsg.service.GuestService;
import com.c3.lsg.util.CustomBuilder;

/**
 * @author archie.ramirez
 *
 */
@RestController
@RequestMapping(value = "/registration")
public class RegistrationController extends BaseController {

	@Autowired
	private GuestService guestService;

	/**
	 * Add new Guest
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/addGuest")
	public ResponseObject addGuest(@RequestBody NewGuestRequest request) {
		log.info("addGuest");

		ResponseObject response = null;
		try {
			inputValidator.addGuest(request);
			response = guestService.addGuest(request);

		} catch (CustomException e) {
			response = CustomBuilder.buildResponse(e.getCode(), e.getTitle(), e.getMessage());
		}
		return response;
	}

	/**
	 * View list of Guests
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/getGuests")
	public ResponseListObject<List<GuestResponseDtl>> getGuests() {
		log.info("getGuests");

		ResponseListObject<List<GuestResponseDtl>> response = new ResponseListObject<>();
		try {
			response = guestService.getGuestLists();

		} catch (CustomException e) {
			response = CustomBuilder.buildListResponse(e.getCode(), e.getTitle(), e.getMessage(), new ArrayList<>());
		}
		return response;
	}
}
