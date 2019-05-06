/**
 * 
 */
package com.c3.lsg.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.c3.lsg.dto.FilterDto;
import com.c3.lsg.dto.GuestResponseDtl;
import com.c3.lsg.dto.NewGuestRequest;
import com.c3.lsg.dto.ResponseListObject;
import com.c3.lsg.dto.ResponseObject;
import com.c3.lsg.dto.UpdateGuestRequest;
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
	@PostMapping(value = "/getGuests")
	public ResponseListObject<List<GuestResponseDtl>> getGuests(@RequestBody FilterDto request) {
		log.info("getGuests");

		ResponseListObject<List<GuestResponseDtl>> response = new ResponseListObject<>();
		try {
			response = guestService.getGuestLists(request);

		} catch (CustomException e) {
			response = CustomBuilder.buildListResponse(e.getCode(), e.getTitle(), e.getMessage(), new ArrayList<>());
		}
		return response;
	}

	/**
	 * View Guest details found by guestId
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/getGuestDetailsById")
	public ResponseListObject<GuestResponseDtl> getGuestById(@RequestParam String id) {
		log.info("getGuestDetailsById");

		ResponseListObject<GuestResponseDtl> response = new ResponseListObject<>();
		try {
			response = guestService.getGuestById(id);

		} catch (CustomException e) {
			response = CustomBuilder.buildListResponse(e.getCode(), e.getTitle(), e.getMessage(), null);
		}
		return response;
	}

	/**
	 * Updates Guest Details
	 * 
	 * @param request
	 * @return
	 */
	@PutMapping(value = "updateGuest")
	public ResponseObject updateGuest(@RequestBody UpdateGuestRequest request) {
		ResponseObject response = null;

		try {
			inputValidator.updateGuest(request);
			response = guestService.updateGuest(request);

		} catch (CustomException e) {
			response = CustomBuilder.buildResponse(e.getCode(), e.getTitle(), e.getMessage());
		}

		return response;
	}

	/**
	 * Removes Guest
	 * 
	 * @param request
	 * @return
	 */
	@DeleteMapping(value = "removeGuest")
	public ResponseObject removeGuest(@RequestParam String id) {
		ResponseObject response = null;

		try {
			response = guestService.removeGuest(id);

		} catch (CustomException e) {
			response = CustomBuilder.buildResponse(e.getCode(), e.getTitle(), e.getMessage());
		}

		return response;
	}
}
