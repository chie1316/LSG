/**
 * 
 */
package com.c3.lsg.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.c3.lsg.model.Member;

/**
 * @author archie.ramirez
 *
 */
public interface MemberRepository extends JpaRepository<Member, String> {

	/**
	 * Finds Member by id
	 * 
	 * @param id
	 * @return
	 */
	public Member findByIdAndDelFalse(String id);

	/**
	 * Selects all undeleted Member.
	 * 
	 * @param pageRequest
	 * 
	 * @return
	 */
	public Page<Member> findByDelFalse(Pageable pageRequest);
}
