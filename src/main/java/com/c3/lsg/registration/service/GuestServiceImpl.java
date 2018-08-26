/**
 * 
 */
package com.c3.lsg.registration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.c3.lsg.registration.dao.GuestRepository;
import com.c3.lsg.registration.dto.GuestResponseDtl;
import com.c3.lsg.registration.dto.NewGuestRequest;
import com.c3.lsg.registration.dto.ResponseObject;
import com.c3.lsg.registration.model.Guest;
import com.c3.lsg.registration.model.Member;
import com.c3.lsg.registration.util.CustomBuilder;

/**
 * @author archie.ramirez
 *
 */
@Service
public class GuestServiceImpl extends BaseService implements GuestService {

	@Autowired
	private GuestRepository guestRepo;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.c3.lsg.registration.service.GuestService#addGuest(com.c3.lsg.registration
	 * .dto.AddGuestRequest).
	 */
	@Override
	public ResponseObject addGuest(NewGuestRequest request) {

		Guest newGuest = new Guest();
		newGuest.setFirstName(request.getFirstName());
		newGuest.setMiddleName(request.getMiddleName());
		newGuest.setLastName(request.getLastName());
		newGuest.setAddress(request.getAddress());
		newGuest.setAge(request.getAge());
		newGuest.setMobileNo(request.getMobileNo());
		newGuest.setEmail(request.getEmail());

		Member member = memberRepo.findByIdAndDelFalse(request.getInvitedBy());
		if (member != null) {
			newGuest.setInvitedBy(member);
		}

		guestRepo.save(newGuest);
		return new ResponseObject();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.c3.lsg.registration.service.GuestService#getGuestLists()
	 */
	@Override
	public List<GuestResponseDtl> getGuestLists() {
		List<Guest> guestProjectionList = guestRepo.findByDelFalse();

		List<GuestResponseDtl> guestResponseDtlList = new ArrayList<>();
		for (Guest guestProjectionData : guestProjectionList) {

			String fullName = CustomBuilder.buildName(guestProjectionData.getFirstName(),
					guestProjectionData.getMiddleName(), guestProjectionData.getLastName());

			GuestResponseDtl guestResponseDtl = new GuestResponseDtl();
			guestResponseDtl.setId(guestProjectionData.getId());
			guestResponseDtl.setName(fullName);
			guestResponseDtl.setAge(guestProjectionData.getAge());
			guestResponseDtl.setAddress(guestProjectionData.getAddress());
			guestResponseDtl.setMobileNo(guestProjectionData.getMobileNo());
			guestResponseDtl.setEmail(guestProjectionData.getEmail());

			Member member = guestProjectionData.getInvitedBy();
			if (member != null) {
				String memberFullName = CustomBuilder.buildName(member.getFirstName(), null, member.getLastName());
				guestResponseDtl.setInvitedBy(memberFullName);
			}

			guestResponseDtlList.add(guestResponseDtl);
		}

		return guestResponseDtlList;
	}

}
