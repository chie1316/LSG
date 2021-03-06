/**
 * 
 */
package com.c3.lsg.dto;

/**
 * @author archie.ramirez
 *
 */
public class NewGuestRequest {

	/**
	 * Default
	 */
	public NewGuestRequest() {
		super();
	}

	/**
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param age
	 * @param address
	 * @param mobileNo
	 * @param email
	 * @param invitedById
	 */
	public NewGuestRequest(String firstName, String middleName, String lastName, String birthDate, String address,
			String mobileNo, String email, String invitedById) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
		this.invitedById = invitedById;
	}

	private String firstName;

	private String middleName;

	private String lastName;

	private String birthDate;

	private String address;

	private String mobileNo;

	private String email;

	private String invitedById;

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

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
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

	public String getInvitedById() {
		return invitedById;
	}

	public void setInvitedById(String invitedById) {
		this.invitedById = invitedById;
	}

}
