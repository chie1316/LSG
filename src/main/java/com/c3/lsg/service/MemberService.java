/**
 * 
 */
package com.c3.lsg.service;

import java.util.List;

import com.c3.lsg.dto.MemberResponseDtl;
import com.c3.lsg.dto.NewMemberRequest;
import com.c3.lsg.dto.ResponseListObject;
import com.c3.lsg.dto.ResponseObject;
import com.c3.lsg.exeception.CustomException;

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
	public ResponseListObject<List<MemberResponseDtl>> getMemberList() throws CustomException;

}
