/**
 * 
 */
package com.c3.lsg.controller;

import static com.c3.lsg.constants.ResponseConstant.CODE_FAILED;
import static com.c3.lsg.constants.ResponseConstant.CODE_SUCCESS;
import static com.c3.lsg.constants.ResponseConstant.MESSAGE_FAILED;
import static com.c3.lsg.constants.ResponseConstant.MESSAGE_SUCCESS;
import static com.c3.lsg.constants.ResponseConstant.TITLE_FAILED;
import static com.c3.lsg.constants.ResponseConstant.TITLE_SUCCESS;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c3.lsg.dto.MemberResponseDtl;
import com.c3.lsg.dto.NewMemberRequest;
import com.c3.lsg.dto.ResponseListObject;
import com.c3.lsg.dto.ResponseObject;
import com.c3.lsg.exeception.CustomException;
import com.c3.lsg.service.MemberService;
import com.c3.lsg.util.CustomBuilder;

/**
 * @author archie.ramirez
 *
 */
@RestController
@RequestMapping(value = "/member")
public class C3MemberController extends BaseController {

	@Autowired
	private MemberService memberService;

	/**
	 * Add new C3 Member
	 * 
	 * @param request
	 * @return
	 */
	@PostMapping(value = "/addMember")
	public ResponseObject addMember(@RequestBody NewMemberRequest request) {
		log.info("addMember");

		ResponseObject response = null;
		try {
			inputValidator.addMember(request);
			response = memberService.addMember(request);
		} catch (CustomException e) {
			response = CustomBuilder.buildResponse(e.getCode(), e.getTitle(), e.getMessage());
		}
		return response;
	}

	/**
	 * View list of C3 Members
	 * 
	 * @param request
	 * @return
	 */
	@GetMapping(value = "/getMembers")
	public ResponseListObject<List<MemberResponseDtl>> getMembers() {
		log.info("getMembers");

		ResponseListObject<List<MemberResponseDtl>> response = new ResponseListObject<>();

		try {
			response = memberService.getMemberList();

		} catch (Exception e) {
			response = CustomBuilder.buildListResponse(//
					Integer.valueOf(env.getProperty(CODE_FAILED)), //
					env.getProperty(TITLE_FAILED), //
					env.getProperty(MESSAGE_FAILED), //
					null);
		}
		return response;
	}
}
