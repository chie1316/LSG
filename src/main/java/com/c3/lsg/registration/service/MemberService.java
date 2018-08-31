/**
 * 
 */
package com.c3.lsg.registration.service;

import java.util.List;

import com.c3.lsg.exeception.CustomException;
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
	 * @throws CustomException
	 */
	public ResponseObject addMember(NewMemberRequest request) throws CustomException;

	/**
	 * This method will get all non-deleted member.
	 * 
	 * @return
	 * @throws CustomException
	 */
	public List<MemberResponseDtl> getMemberList() throws CustomException;

}
