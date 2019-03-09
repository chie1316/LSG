/**
 * 
 */
package com.c3.lsg.service;

import static com.c3.lsg.constants.ResponseConstant.CODE_FAILED;
import static com.c3.lsg.constants.ResponseConstant.CODE_SUCCESS;
import static com.c3.lsg.constants.ResponseConstant.MESSAGE_SUCCESS;
import static com.c3.lsg.constants.ResponseConstant.TITLE_DATA_ACCESS_ERROR;
import static com.c3.lsg.constants.ResponseConstant.TITLE_SUCCESS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.c3.lsg.dto.GuestResponseDtl;
import com.c3.lsg.dto.InvitedByResponseDtl;
import com.c3.lsg.dto.NewGuestRequest;
import com.c3.lsg.dto.ResponseListObject;
import com.c3.lsg.dto.ResponseObject;
import com.c3.lsg.exeception.CustomException;
import com.c3.lsg.model.Guest;
import com.c3.lsg.model.Member;
import com.c3.lsg.repository.GuestRepository;
import com.c3.lsg.util.CustomBuilder;

/**
 * @author archie.ramirez
 *
 */
@Service
public class GuestServiceImpl extends BaseService implements GuestService {

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
			throw new CustomException(Integer.valueOf(env.getProperty(CODE_FAILED)), //
					env.getProperty(TITLE_DATA_ACCESS_ERROR), //
					"Unable to add/save new Guest.");
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
			throw new CustomException(Integer.valueOf(env.getProperty(CODE_FAILED)), //
					env.getProperty(TITLE_DATA_ACCESS_ERROR), //
					"Unable to retrieve Guest lists.");
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

		return new ResponseObject( //
				Integer.valueOf(env.getProperty(CODE_SUCCESS)), //
				env.getProperty(TITLE_SUCCESS), //
				env.getProperty(MESSAGE_SUCCESS));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.c3.lsg.registration.service.GuestService#getGuestLists()
	 */
	@Override
	public ResponseListObject<List<GuestResponseDtl>> getGuestLists() throws CustomException {

		List<GuestResponseDtl> guestResponseDtlList = new ArrayList<>();

		List<Guest> guestProjectionList = getAllGuests();
		for (Guest guestProjectionData : guestProjectionList) {

			Member member = guestProjectionData.getInvitedBy();
			InvitedByResponseDtl invitedBy = new InvitedByResponseDtl();
			if (member != null) {
				String memberFullName = CustomBuilder.buildName(member.getFirstName(), null, member.getLastName());
				invitedBy = new InvitedByResponseDtl(member.getId(), memberFullName);
			}

			String guestfullName = CustomBuilder.buildName(guestProjectionData.getFirstName(),
					guestProjectionData.getMiddleName(), guestProjectionData.getLastName());

			GuestResponseDtl guestResponseDtl = new GuestResponseDtl( //
					guestProjectionData.getId(), //
					guestfullName, //
					guestProjectionData.getAge(), //
					guestProjectionData.getAddress(), //
					guestProjectionData.getMobileNo(), //
					guestProjectionData.getEmail(), //
					invitedBy);

			guestResponseDtlList.add(guestResponseDtl);
		}

		return new ResponseListObject<>(//
				Integer.valueOf(env.getProperty(CODE_SUCCESS)), //
				env.getProperty(TITLE_SUCCESS), //
				env.getProperty(MESSAGE_SUCCESS), //
				guestResponseDtlList);
	}

}
