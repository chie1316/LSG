/**
 * 
 */
package com.c3.lsg.registration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.c3.lsg.registration.service.MemberService#addMember()
	 */
	@Override
	public ResponseObject addMember(NewMemberRequest request) {
		Member member = new Member();
		member.setFirstName(request.getFirstName());
		member.setMiddleName(request.getMiddleName());
		member.setLastName(request.getLastName());
		memberRepo.save(member);
		return new ResponseObject();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.c3.lsg.registration.service.MemberService#getMemberList()
	 */
	@Override
	public List<MemberResponseDtl> getMemberList() {

		List<Member> memberList = memberRepo.findByDelFalse();
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
