/**
 * 
 */
package com.c3.lsg.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author archie.ramirez
 *
 */
@Entity
@Table(name = "GUEST")
public class Guest extends ParentModel {

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "BIRTH_DATE")
	private Date birthDate;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "MOBILE_NO")
	private String mobileNo;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "CREATE_DATE")
	private Date createDate = new Date();

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INVITED_BY", referencedColumnName = "ID")
	private Member invitedBy;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "EVENT_ID", referencedColumnName = "ID")
	private Event event;

	/**
	 * Default
	 */
	public Guest() {
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
	 * @param createDate
	 * @param invitedBy
	 * @param event
	 */
	public Guest(String firstName, String middleName, String lastName, Date birthDate, String address, String mobileNo,
			String email, Date createDate, Member invitedBy, Event event) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.address = address;
		this.mobileNo = mobileNo;
		this.email = email;
		this.createDate = createDate;
		this.invitedBy = invitedBy;
		this.event = event;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public Member getInvitedBy() {
		return invitedBy;
	}

	public void setInvitedBy(Member invitedBy) {
		this.invitedBy = invitedBy;
	}

}
