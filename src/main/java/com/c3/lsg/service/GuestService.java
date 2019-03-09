/**
 * 
 */
package com.c3.lsg.service;

import java.util.List;

import com.c3.lsg.dto.GuestResponseDtl;
import com.c3.lsg.dto.NewGuestRequest;
import com.c3.lsg.dto.ResponseListObject;
import com.c3.lsg.dto.ResponseObject;
import com.c3.lsg.exeception.CustomException;

/**
 * @author archie.ramirez
 *
 */
public interface GuestService {
	/*
	 * This service will add/save the new Guest entered by the user.
	 */
	public ResponseObject addGuest(NewGuestRequest request) throws CustomException;

	/*
	 * This service will allow the user to view all guests.
	 */
	public ResponseListObject<List<GuestResponseDtl>> getGuestLists() throws CustomException;
}
