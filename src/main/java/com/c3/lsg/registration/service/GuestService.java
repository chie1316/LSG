/**
 * 
 */
package com.c3.lsg.registration.service;

import java.util.List;

import com.c3.lsg.registration.dto.GuestResponseDtl;
import com.c3.lsg.registration.dto.NewGuestRequest;
import com.c3.lsg.registration.dto.ResponseObject;

/**
 * @author archie.ramirez
 *
 */
public interface GuestService {
	/*
	 * This service will add/save the new Guest entered by the user.
	 */
	public ResponseObject addGuest(NewGuestRequest request);

	/*
	 * This service will allow the user to view all guests.
	 */
	public List<GuestResponseDtl> getGuestLists();
}
