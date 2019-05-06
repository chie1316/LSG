/**
 * 
 */
package com.c3.lsg.dto;

/**
 * @author archie.ramirez
 *
 */
public class SortDto {

	/**
	 * Default
	 */
	public SortDto() {
		super();
	}

	/**
	 * @param sortOrder
	 * @param sortBy
	 */
	public SortDto(String sortOrder, String sortBy) {
		super();
		this.sortOrder = sortOrder;
		this.sortBy = sortBy;
	}

	private String sortOrder;

	private String sortBy;

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getSortBy() {
		return sortBy;
	}

	public void setSortBy(String sortBy) {
		this.sortBy = sortBy;
	}

}
