/**
 * 
 */
package com.c3.lsg.registration.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c3.lsg.registration.dto.GuestResponseDtl;
import com.c3.lsg.registration.dto.MemberResponseDtl;
import com.c3.lsg.registration.dto.NewGuestRequest;
import com.c3.lsg.registration.dto.NewMemberRequest;
import com.c3.lsg.registration.dto.ResponseListObject;
import com.c3.lsg.registration.dto.ResponseObject;
import com.c3.lsg.registration.service.GuestService;
import com.c3.lsg.registration.service.MemberService;
import com.c3.lsg.registration.util.CustomBuilder;

/**
 * @author archie.ramirez
 *
 */
@RestController
@RequestMapping(value = "/registration")
public class RegistrationController {

	@Autowired
	private GuestService guestService;

	@Autowired
	private MemberService memberService;

	@PostMapping(value = "/addGuest")
	public ResponseObject addGuest(@RequestBody NewGuestRequest request) {

		ResponseObject response = null;
		try {
			response = guestService.addGuest(request);
		} catch (Exception e) {
			response = CustomBuilder.buildResponse(400, "FAILED", "Fail");
		}
		return response;
	}

	@GetMapping(value = "/getGuests")
	public ResponseListObject<List<GuestResponseDtl>> getGuests() {

		ResponseListObject<List<GuestResponseDtl>> response = new ResponseListObject<>();
		try {
			List<GuestResponseDtl> data = guestService.getGuestLists();
			response.setData(data);
		} catch (Exception e) {
			response = CustomBuilder.buildListResponse(400, "FAILED", "Fail", null);
		}
		return response;
	}

	@PostMapping(value = "/addMember")
	public ResponseObject addMember(@RequestBody NewMemberRequest request) {

		ResponseObject response = null;
		try {
			response = memberService.addMember(request);
		} catch (Exception e) {
			response = CustomBuilder.buildResponse(400, "FAILED", "Fail");
		}
		return response;
	}

	@GetMapping(value = "/getMembers")
	public ResponseListObject<List<MemberResponseDtl>> getMembers() {

		ResponseListObject<List<MemberResponseDtl>> response = new ResponseListObject<>();
		try {
			List<MemberResponseDtl> data = memberService.getMemberList();
			response.setData(data);
		} catch (Exception e) {
			response = CustomBuilder.buildListResponse(400, "FAILED", "Fail", null);
		}
		return response;
	}
}
