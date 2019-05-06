/**
 * 
 */
package com.c3.lsg.service;

import static com.c3.lsg.constants.ResponseConstant.CODE_FAILED;
import static com.c3.lsg.constants.ResponseConstant.CODE_SUCCESS;
import static com.c3.lsg.constants.ResponseConstant.MESSAGE_FAILED;
import static com.c3.lsg.constants.ResponseConstant.MESSAGE_SUCCESS;
import static com.c3.lsg.constants.ResponseConstant.TITLE_DATA_ACCESS_ERROR;
import static com.c3.lsg.constants.ResponseConstant.TITLE_FAILED;
import static com.c3.lsg.constants.ResponseConstant.TITLE_SUCCESS;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.c3.lsg.dto.FilterDto;
import com.c3.lsg.dto.GuestResponseDtl;
import com.c3.lsg.dto.InvitedByResponseDtl;
import com.c3.lsg.dto.NewGuestRequest;
import com.c3.lsg.dto.ResponseListObject;
import com.c3.lsg.dto.ResponseObject;
import com.c3.lsg.dto.UpdateGuestRequest;
import com.c3.lsg.exeception.CustomException;
import com.c3.lsg.model.Guest;
import com.c3.lsg.model.Member;
import com.c3.lsg.repository.GuestRepository;
import com.c3.lsg.util.ConverterUtil;
import com.c3.lsg.validation.InputValidator;

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
	private void saveGuest(Guest newGuest) throws CustomException {
		try {
			guestRepo.save(newGuest);

		} catch (DataAccessException e) {
			throw new CustomException(Integer.valueOf(env.getProperty(CODE_FAILED)), //
					env.getProperty(TITLE_DATA_ACCESS_ERROR), //
					"Unable to save Guest.");
		}
	}

	/**
	 * This method catches Data access Error upon retrieving Guest List.
	 * 
	 * @return
	 * @throws CustomException
	 */
	private List<Guest> getAllGuests(FilterDto request) throws CustomException {
		Page<Guest> guestPage = null;
		Pageable pageRequest = InputValidator.pageValidator(request);

		try {
			guestPage = guestRepo.findByDelFalse(pageRequest);

		} catch (DataAccessException e) {
			throw new CustomException(Integer.valueOf(env.getProperty(CODE_FAILED)), //
					env.getProperty(TITLE_DATA_ACCESS_ERROR), //
					"Unable to retrieve Guest lists.");
		}

		List<Guest> guestList = new ArrayList<>();
		if (guestPage != null) {
			for (Guest guestItem : guestPage.getContent()) {
				guestList.add(guestItem);
			}
		}

		return guestList;
	}

	/**
	 * This method gets the Guest Details.
	 * 
	 * @return
	 * @throws NumberFormatException
	 * @throws CustomException
	 */
	private Guest findGuestById(String id) throws CustomException {
		Guest guest = null;
		try {
			guest = guestRepo.findByIdAndDelFalse(id);
		} catch (DataAccessException e) {
			throw new CustomException(Integer.valueOf(env.getProperty(CODE_FAILED)), //
					env.getProperty(TITLE_DATA_ACCESS_ERROR), //
					"Unable to retrieve Guest's Details.");
		}
		return guest;
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
		newGuest.setBirthDate(ConverterUtil.stringToDate(request.getBirthDate()));
		newGuest.setMobileNo(request.getMobileNo());
		newGuest.setEmail(request.getEmail());

		Member member = memberRepo.findByIdAndDelFalse(request.getInvitedById());
		if (member != null) {
			newGuest.setInvitedBy(member);
		}

		saveGuest(newGuest);

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
	public ResponseListObject<List<GuestResponseDtl>> getGuestLists(FilterDto request) throws CustomException {

		List<GuestResponseDtl> guestResponseDtlList = new ArrayList<>();

		List<Guest> guestProjectionList = getAllGuests(request);
		for (Guest guestProjectionData : guestProjectionList) {

			Member member = guestProjectionData.getInvitedBy();
			InvitedByResponseDtl invitedBy = new InvitedByResponseDtl();
			if (member != null) {
				String memberFullName = member.getFirstName() + " " + member.getLastName();
				invitedBy = new InvitedByResponseDtl(member.getId(), memberFullName);
			}

			GuestResponseDtl guestResponseDtl = new GuestResponseDtl( //
					guestProjectionData.getId(), //
					guestProjectionData.getFirstName(), //
					guestProjectionData.getMiddleName(), //
					guestProjectionData.getLastName(), //
					guestProjectionData.getBirthDate(), //
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.c3.lsg.service.GuestService#getGuestById()
	 */
	@Override
	public ResponseListObject<GuestResponseDtl> getGuestById(String id) throws CustomException {

		GuestResponseDtl guestResponseDtl = null;
		Guest guest = findGuestById(id);

		if (guest != null) {
			Member member = guest.getInvitedBy();
			InvitedByResponseDtl invitedBy = new InvitedByResponseDtl();
			if (member != null) {
				String memberFullName = member.getFirstName() + " " + member.getLastName();
				invitedBy = new InvitedByResponseDtl(member.getId(), memberFullName);
			}

			guestResponseDtl = new GuestResponseDtl( //
					guest.getId(), //
					guest.getFirstName(), //
					guest.getMiddleName(), //
					guest.getLastName(), //
					guest.getBirthDate(), //
					guest.getAddress(), //
					guest.getMobileNo(), //
					guest.getEmail(), //
					invitedBy);
		}

		return new ResponseListObject<>(//
				Integer.valueOf(env.getProperty(CODE_SUCCESS)), //
				env.getProperty(TITLE_SUCCESS), //
				env.getProperty(MESSAGE_SUCCESS), //
				guestResponseDtl);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.c3.lsg.service.GuestService#updateGuest(com.c3.lsg.dto.
	 * UpdateGuestRequest)
	 */
	@Override
	public ResponseObject updateGuest(UpdateGuestRequest request) throws CustomException {

		ResponseObject response = null;
		Guest guest = findGuestById(request.getId());

		if (guest != null) {
			guest.setFirstName(request.getFirstName());
			guest.setMiddleName(request.getMiddleName());
			guest.setLastName(request.getLastName());
			guest.setAddress(request.getAddress());
			guest.setBirthDate(ConverterUtil.stringToDate(request.getBirthDate()));
			guest.setMobileNo(request.getMobileNo());
			guest.setEmail(request.getEmail());

			Member member = memberRepo.findByIdAndDelFalse(request.getInvitedById());
			if (member != null) {
				guest.setInvitedBy(member);
			}

			saveGuest(guest);

			response = new ResponseObject( //
					Integer.valueOf(env.getProperty(CODE_SUCCESS)), //
					env.getProperty(TITLE_SUCCESS), //
					env.getProperty(MESSAGE_SUCCESS));
		} else {

			response = new ResponseObject( //
					Integer.valueOf(env.getProperty(CODE_FAILED)), //
					env.getProperty(TITLE_FAILED), //
					env.getProperty(MESSAGE_FAILED));
		}

		return response;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.c3.lsg.service.GuestService#removeGuest(java.lang.String)
	 */
	@Override
	public ResponseObject removeGuest(String id) throws CustomException {
		ResponseObject response = null;

		Guest guest = findGuestById(id);
		if (guest != null) {
			guest.setDel(true);

			saveGuest(guest);

			response = new ResponseObject( //
					Integer.valueOf(env.getProperty(CODE_SUCCESS)), //
					env.getProperty(TITLE_SUCCESS), //
					env.getProperty(MESSAGE_SUCCESS));
		} else {

			response = new ResponseObject( //
					Integer.valueOf(env.getProperty(CODE_FAILED)), //
					env.getProperty(TITLE_FAILED), //
					env.getProperty(MESSAGE_FAILED));
		}

		return response;
	}
}
