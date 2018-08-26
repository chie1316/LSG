/**
 * 
 */
package com.c3.lsg.registration.service;

import java.util.List;

import com.c3.lsg.registration.dto.MemberResponseDtl;
import com.c3.lsg.registration.dto.NewMemberRequest;
import com.c3.lsg.registration.dto.ResponseObject;

/**
 * @author archie.ramirez
 *
 */
public interface MemberService {

	/**
	 * This method will add/save the new Member.
	 * 
	 * @return
	 */
	public ResponseObject addMember(NewMemberRequest request);

	/**
	 * This method will get all non-deleted member.
	 * @return
	 */
	public List<MemberResponseDtl> getMemberList();

}
