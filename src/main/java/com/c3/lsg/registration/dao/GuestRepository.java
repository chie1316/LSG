/**
 * 
 */
package com.c3.lsg.registration.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c3.lsg.registration.model.Guest;

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
	public List<Guest> findByDelFalse();
}
