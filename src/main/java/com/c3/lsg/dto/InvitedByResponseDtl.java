/**
 * 
 */
package com.c3.lsg.dto;

/**
 * @author archie.ramirez
 *
 */
public class InvitedByResponseDtl {

	/*
	 * Default
	 */
	public InvitedByResponseDtl() {
		super();
	}

	/**
	 * @param id
	 * @param name
	 */
	public InvitedByResponseDtl(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	private String id;

	private String name;

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

}
