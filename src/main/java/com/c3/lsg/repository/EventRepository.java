/**
 * 
 */
package com.c3.lsg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.c3.lsg.model.Event;

/**
 * @author archie.ramirez
 *
 */
public interface EventRepository extends JpaRepository<Event, String> {

}
