/**
 * 
 */
package com.c3.lsg.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.c3.lsg.model.Guest;

/**
 * @author archie.ramirez
 *
 */
public interface GuestRepository extends JpaRepository<Guest, String> {

	/**
	 * Finds Guest by ID and not deleted.
	 * 
	 * @param id
	 * @return
	 */
	public Guest findByIdAndDelFalse(String id);

	/**
	 * Selects all undeleted Guests.
	 * 
	 * @return
	 */
	public Page<Guest> findByDelFalse(Pageable page);

}
