/**
 * 
 */
package com.c3.lsg.service;

import static com.c3.lsg.constants.ResponseConstant.CODE_ERROR;
import static com.c3.lsg.constants.ResponseConstant.CODE_SUCCESS;
import static com.c3.lsg.constants.ResponseConstant.MESSAGE_SUCCESS;
import static com.c3.lsg.constants.ResponseConstant.TITLE_DATA_ACCESS_ERROR;
import static com.c3.lsg.constants.ResponseConstant.TITLE_SUCCESS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.c3.lsg.dto.MemberResponseDtl;
import com.c3.lsg.dto.NewMemberRequest;
import com.c3.lsg.dto.ResponseListObject;
import com.c3.lsg.dto.ResponseObject;
import com.c3.lsg.exeception.CustomException;
import com.c3.lsg.model.Member;

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
	private ResponseObject addNewMember(Member newMember) throws CustomException {

		try {
			memberRepo.save(newMember);

		} catch (DataAccessException e) {
			log.error("Error saving new member", e);
			throw new CustomException( //
					Integer.valueOf(env.getProperty(CODE_ERROR)), //
					env.getProperty(TITLE_DATA_ACCESS_ERROR), //
					"Unable to add/save new Member.");
		}
		return new ResponseObject( //
				Integer.valueOf(env.getProperty(CODE_SUCCESS)), //
				env.getProperty(TITLE_SUCCESS), //
				env.getProperty(MESSAGE_SUCCESS));
	}

	/**
	 * This method catches Data Access Error upon retrieving Member List.
	 * 
	 * @return
	 * @throws CustomException
	 */
	private List<Member> getAllMembers() throws CustomException {
		List<Member> memberList = new ArrayList<>();
		try {
			memberList = memberRepo.findByDelFalse();

		} catch (DataAccessException e) {
			log.error("Unable to retrieve Member lists", e);
			throw new CustomException( //
					Integer.valueOf(env.getProperty(CODE_ERROR)), //
					env.getProperty(TITLE_DATA_ACCESS_ERROR), //
					"Unable to retrieve Member lists.");

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

		return addNewMember(newMember);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.c3.lsg.registration.service.MemberService#getMemberList()
	 */
	@Override
	public ResponseListObject<List<MemberResponseDtl>> getMemberList() throws CustomException {

		List<MemberResponseDtl> responseList = new ArrayList<>();

		List<Member> memberList = getAllMembers();
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

}
