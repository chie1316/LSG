/**
 * 
 */
package com.c3.lsg.service;

import static com.c3.lsg.constants.ResponseConstant.CODE_ERROR;
import static com.c3.lsg.constants.ResponseConstant.CODE_FAILED;
import static com.c3.lsg.constants.ResponseConstant.CODE_SUCCESS;
import static com.c3.lsg.constants.ResponseConstant.MESSAGE_FAILED;
import static com.c3.lsg.constants.ResponseConstant.MESSAGE_SUCCESS;
import static com.c3.lsg.constants.ResponseConstant.TITLE_DATA_ACCESS_ERROR;
import static com.c3.lsg.constants.ResponseConstant.TITLE_FAILED;
import static com.c3.lsg.constants.ResponseConstant.TITLE_SUCCESS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.c3.lsg.dto.FilterDto;
import com.c3.lsg.dto.MemberResponseDtl;
import com.c3.lsg.dto.NewMemberRequest;
import com.c3.lsg.dto.ResponseListObject;
import com.c3.lsg.dto.ResponseObject;
import com.c3.lsg.dto.UpdateMemberRequest;
import com.c3.lsg.exeception.CustomException;
import com.c3.lsg.model.Member;
import com.c3.lsg.validation.InputValidator;

/**
 * @author archie.ramirez
 *
 */
@Service
public class MemberServiceImpl extends BaseService implements MemberService {

	/**
	 * This method catches Data Access Error upon adding/saving new Member.
	 * 
	 * @param newMember
	 * @throws CustomException
	 */
	private ResponseObject saveMember(Member newMember) throws CustomException {

		try {
			memberRepo.save(newMember);

		} catch (DataAccessException e) {
			log.error("Error saving new member", e);
			throw new CustomException( //
					Integer.valueOf(env.getProperty(CODE_ERROR)), //
					env.getProperty(TITLE_DATA_ACCESS_ERROR), //
					"Unable to save Member.");
		}
		return new ResponseObject( //
				Integer.valueOf(env.getProperty(CODE_SUCCESS)), //
				env.getProperty(TITLE_SUCCESS), //
				env.getProperty(MESSAGE_SUCCESS));
	}

	/**
	 * This method catches Data Access Error upon retrieving Member Details.
	 * 
	 * @param id
	 * @return
	 * @throws CustomException
	 */
	private Member getMemberDetailsById(String id) throws CustomException {
		Member member = null;
		try {
			member = memberRepo.findByIdAndDelFalse(id);
		} catch (DataAccessException e) {
			log.error("Unable to retrieve Member Details", e);
			throw new CustomException( //
					Integer.valueOf(env.getProperty(CODE_ERROR)), //
					env.getProperty(TITLE_DATA_ACCESS_ERROR), //
					"Unable to retrieve Member Details.");
		}
		return member;
	}

	/**
	 * This method catches Data Access Error upon retrieving Member List.
	 * 
	 * @return
	 * @throws CustomException
	 */
	private List<Member> getAllMembers(FilterDto request) throws CustomException {
		Page<Member> memberPage = null;
		Pageable pageRequest = InputValidator.pageValidator(request);

		try {
			memberPage = memberRepo.findByDelFalse(pageRequest);

		} catch (DataAccessException e) {
			log.error("Unable to retrieve Member lists", e);
			throw new CustomException( //
					Integer.valueOf(env.getProperty(CODE_ERROR)), //
					env.getProperty(TITLE_DATA_ACCESS_ERROR), //
					"Unable to retrieve Member lists.");

		}

		List<Member> memberList = new ArrayList<>();
		if (memberPage != null) {
			for (Member memberItem : memberPage.getContent()) {
				memberList.add(memberItem);
			}
		}
		return memberList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.c3.lsg.registration.service.MemberService#addMember()
	 */
	@Override
	public ResponseObject addMember(NewMemberRequest request) throws CustomException {

		Member newMember = new Member( //
				request.getFirstName(), //
				request.getMiddleName(), //
				request.getLastName());

		return saveMember(newMember);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.c3.lsg.registration.service.MemberService#getMemberList()
	 */
	@Override
	public ResponseListObject<List<MemberResponseDtl>> getMemberList(FilterDto request) throws CustomException {

		List<MemberResponseDtl> responseList = new ArrayList<>();

		List<Member> memberList = getAllMembers(request);
		for (Member memberItem : memberList) {

			MemberResponseDtl responseEntity = new MemberResponseDtl( //
					memberItem.getId(), //
					memberItem.getFirstName(), //
					memberItem.getMiddleName(), //
					memberItem.getLastName());

			responseList.add(responseEntity);
		}

		return new ResponseListObject<>(//
				Integer.valueOf(env.getProperty(CODE_SUCCESS)), //
				env.getProperty(TITLE_SUCCESS), //
				env.getProperty(MESSAGE_SUCCESS), //
				responseList);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.c3.lsg.service.MemberService#updateMember(com.c3.lsg.dto.
	 * UpdateMemberRequest)
	 */
	@Override
	public ResponseObject updateMember(UpdateMemberRequest request) throws CustomException {
		ResponseObject response = null;

		Member member = getMemberDetailsById(request.getId());
		if (member != null) {
			member.setFirstName(request.getFirstName());
			member.setLastName(request.getLastName());
			member.setMiddleName(request.getMiddleName());

			response = new ResponseObject( //
					Integer.valueOf(env.getProperty(CODE_SUCCESS)), //
					env.getProperty(TITLE_SUCCESS), //
					env.getProperty(MESSAGE_SUCCESS));
		} else {

			response = new ResponseObject( //
					Integer.valueOf(env.getProperty(CODE_FAILED)), //
					env.getProperty(TITLE_FAILED), //
					env.getProperty(MESSAGE_FAILED));
		}
		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.c3.lsg.service.MemberService#removeMember(java.lang.String)
	 */
	@Override
	public ResponseObject removeMember(String id) throws CustomException {
		ResponseObject response = null;

		Member member = getMemberDetailsById(id);
		if (member != null) {
			member.setDel(true);
			saveMember(member);

			response = new ResponseObject( //
					Integer.valueOf(env.getProperty(CODE_SUCCESS)), //
					env.getProperty(TITLE_SUCCESS), //
					env.getProperty(MESSAGE_SUCCESS));
		} else {

			response = new ResponseObject( //
					Integer.valueOf(env.getProperty(CODE_FAILED)), //
					env.getProperty(TITLE_FAILED), //
					env.getProperty(MESSAGE_FAILED));
		}

		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.c3.lsg.service.MemberService#getMemberById(java.lang.String)
	 */
	@Override
	public ResponseListObject<MemberResponseDtl> getMemberById(String id) throws CustomException {
		Member member = getMemberDetailsById(id);

		MemberResponseDtl responseResponseDtl = null;
		if (member != null) {
			responseResponseDtl = new MemberResponseDtl( //
					member.getId(), //
					member.getFirstName(), //
					member.getMiddleName(), //
					member.getLastName());
		}

		return new ResponseListObject<>(//
				Integer.valueOf(env.getProperty(CODE_SUCCESS)), //
				env.getProperty(TITLE_SUCCESS), //
				env.getProperty(MESSAGE_SUCCESS), //
				responseResponseDtl);
	}

}
