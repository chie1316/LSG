/**
 * 
 */
package com.c3.lsg.registration.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.c3.lsg.registration.dao.MemberRepository;

/**
 * @author archie.ramirez
 *
 */
public abstract class BaseService {

	@Autowired
	protected MemberRepository memberRepo;
}
