/**
 * 
 */
package com.c3.lsg.dto;

import java.util.Date;

/**
 * @author archie.ramirez
 *
 */
public class GuestResponseDtl {

	/**
	 * Default
	 */
	public GuestResponseDtl() {
		super();
		this.invitedBy = new InvitedByResponseDtl();
	}

	/**
	 * 
	 * @param id
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param birthDate
	 * @param address
	 * @param mobileNo
	 * @param email
	 * @param invitedBy
	 */
	public GuestResponseDtl(String id, String firstName, String middleName, String lastName, Date birthDate,
			String address, String mobileNo, String email, InvitedByResponseDtl invitedBy) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
		this.invitedBy = invitedBy;
	}

	private String id;

	private String firstName;

	private String middleName;

	private String lastName;

	private Date birthDate;

	private String address;

	private String mobileNo;

	private String email;

	private InvitedByResponseDtl invitedBy;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public InvitedByResponseDtl getInvitedBy() {
		return invitedBy;
	}

	public void setInvitedBy(InvitedByResponseDtl invitedBy) {
		this.invitedBy = invitedBy;
	}

}
