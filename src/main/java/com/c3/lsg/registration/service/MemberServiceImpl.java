/**
 * 
 */
package com.c3.lsg.registration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.c3.lsg.exeception.CustomException;
import com.c3.lsg.registration.dto.MemberResponseDtl;
import com.c3.lsg.registration.dto.NewMemberRequest;
import com.c3.lsg.registration.dto.ResponseObject;
import com.c3.lsg.registration.model.Member;

/**
 * @author archie.ramirez
 *
 */
@Service
public class MemberServiceImpl extends BaseService implements MemberService {

	private static final String DATA_ACCESS_ERROR = "DATA ACCESS ERROR";

	/**
	 * This method catches Data Access Error upon adding/saving new Member.
	 * 
	 * @param newMember
	 * @throws CustomException
	 */
	private void addNewMember(Member newMember) throws CustomException {

		try {
			memberRepo.save(newMember);
		} catch (DataAccessException e) {
			throw new CustomException(400, DATA_ACCESS_ERROR, "Unable to add/save new Member.");
		}
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
			throw new CustomException(400, DATA_ACCESS_ERROR, "Unable to retrieve Member lists.");
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

		Member newMember = new Member();
		newMember.setFirstName(request.getFirstName());
		newMember.setMiddleName(request.getMiddleName());
		newMember.setLastName(request.getLastName());
		addNewMember(newMember);

		return new ResponseObject();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.c3.lsg.registration.service.MemberService#getMemberList()
	 */
	@Override
	public List<MemberResponseDtl> getMemberList() throws CustomException {

		List<Member> memberList = getAllMembers();
		List<MemberResponseDtl> responseList = new ArrayList<>();
		for (Member memberItem : memberList) {

			MemberResponseDtl responseEntity = new MemberResponseDtl();
			responseEntity.setId(memberItem.getId());
			responseEntity.setFirstName(memberItem.getFirstName());
			responseEntity.setMiddleName(memberItem.getMiddleName());
			responseEntity.setLastName(memberItem.getLastName());

			responseList.add(responseEntity);
		}
		return responseList;
	}

}
