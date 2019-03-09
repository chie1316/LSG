/**
 * 
 */
package com.c3.lsg.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

/**
 * @author archie.ramirez
 *
 */
@Entity
@Table(name = "MEMBER")
public class Member extends ParentModel {

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "MIDDLE_NAME")
	private String middleName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@OneToMany
	@Where(clause = "del = false")
	private List<Guest> inviteList;

	/**
	 * Default
	 */
	public Member() {
		super();
	}

	/**
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param inviteList
	 */
	public Member(String firstName, String middleName, //
			String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
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

	public List<Guest> getInviteList() {
		return inviteList;
	}

	public void setInviteList(List<Guest> inviteList) {
		this.inviteList = inviteList;
	}

}
