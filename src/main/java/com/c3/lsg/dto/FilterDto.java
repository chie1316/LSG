/**
 * 
 */
package com.c3.lsg.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author archie.ramirez
 *
 */
public class FilterDto {

	/**
	 * Default
	 */
	public FilterDto() {
		super();
	}

	/**
	 * 
	 * @param page
	 * @param limit
	 * @param sortList
	 */
	public FilterDto(Integer page, Integer limit,List<SortDto> sortList ) {
		super();
		this.page = page;
		this.limit = limit;
		this.sortList = sortList;
	}

	/**
	 * 
	 * @param page
	 * @param limit
	 * @param sortData
	 */
	public FilterDto(Integer page, Integer limit, SortDto sortData ) {
		super();
		this.page = page;
		this.limit = limit;
		
		List<SortDto> newSortList = new ArrayList<>();
		sortList.add(sortData);
		this.sortList = newSortList;
	}
	
	private Integer page;

	private Integer limit;

	private List<SortDto> sortList;
	
	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public List<SortDto> getSortList() {
		return sortList;
	}

	public void setSortList(List<SortDto> sortList) {
		this.sortList = sortList;
	}

}
