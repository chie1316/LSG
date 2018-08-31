/**
 * 
 */
package com.c3.lsg.registration.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.c3.lsg.exeception.CustomException;
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

	private static final String DATA_ACCESS_ERROR = "DATA ACCESS ERROR";
	@Autowired
	private GuestRepository guestRepo;

	/**
	 * This method catches Data access Error upon saving new Guest.
	 * 
	 * @param newGuest
	 * @throws CustomException
	 */
	private void saveNewGuest(Guest newGuest) throws CustomException {
		try {
			guestRepo.save(newGuest);

		} catch (DataAccessException e) {
			throw new CustomException(400, DATA_ACCESS_ERROR, "Unable to add/save new Guest.");
		}
	}

	/**
	 * This method catches Data access Error upon retrieving Guest List.
	 * 
	 * @return
	 * @throws CustomException
	 */
	private List<Guest> getAllGuests() throws CustomException {
		List<Guest> guestList = new ArrayList<>();
		try {
			guestList = guestRepo.findByDelFalse();
		} catch (DataAccessException e) {
			throw new CustomException(400, DATA_ACCESS_ERROR, "Unable to retrieve Guest lists.");
		}
		return guestList;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.c3.lsg.registration.service.GuestService#addGuest(com.c3.lsg.registration
	 * .dto.AddGuestRequest).
	 */
	@Override
	public ResponseObject addGuest(NewGuestRequest request) throws CustomException {

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

		saveNewGuest(newGuest);

		return new ResponseObject();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.c3.lsg.registration.service.GuestService#getGuestLists()
	 */
	@Override
	public List<GuestResponseDtl> getGuestLists() throws CustomException {
		List<Guest> guestProjectionList = getAllGuests();

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
