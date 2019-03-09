/**
 * 
 */
package com.c3.lsg.dto;

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
	 * @param id
	 * @param name
	 * @param age
	 * @param address
	 * @param mobileNo
	 * @param email
	 * @param invitedBy
	 */
	public GuestResponseDtl(String id, String name, int age, String address, String mobileNo, String email,
			InvitedByResponseDtl invitedBy) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
		this.invitedBy = invitedBy;
	}

	private String id;

	private String name;

	private int age;

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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
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
