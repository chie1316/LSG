/**
 * 
 */
package com.c3.lsg.dto;

/**
 * @author archie.ramirez
 *
 */
public class NewMemberRequest {

	/**
	 * Default
	 */
	public NewMemberRequest() {
		super();
	}

	/**
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 */
	public NewMemberRequest(String firstName, String middleName, String lastName) {
		super();
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
	}

	private String firstName;

	private String middleName;

	private String lastName;

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

}
