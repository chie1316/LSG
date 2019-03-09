/**
 * 
 */
package com.c3.lsg.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author archie.ramirez
 *
 */

@Entity
@Table(name = "EVENT")
public class Event extends ParentModel {

	/**
	 * Default
	 */
	public Event() {
		super();
	}

	/**
	 * @param name
	 * @param startDate
	 * @param endDate
	 * @param location
	 * @param banner
	 */
	public Event(String name, Date startDate, //
			Date endDate, String location, byte[] banner) {
		super();
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
		this.banner = banner;
	}

	@Column(name = "NAME")
	private String name;

	@Column(name = "START_DATE")
	private Date startDate;

	@Column(name = "END_DATE")
	private Date endDate;

	@Column(name = "LOCATION")
	private String location;

	@Column(name = "BANNER")
	private byte[] banner;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public byte[] getBanner() {
		return banner;
	}

	public void setBanner(byte[] banner) {
		this.banner = banner;
	}

}
