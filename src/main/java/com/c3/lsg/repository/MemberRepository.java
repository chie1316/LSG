/**
 * 
 */
package com.c3.lsg.repository;

import java.util.List;

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
	 * @return
	 */
	public List<Member> findByDelFalse();
}
