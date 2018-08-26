/**
 * 
 */
package com.c3.lsg.registration.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.c3.lsg.registration.dao.MemberRepository;
import com.c3.lsg.registration.util.ConverterUtil;

/**
 * @author archie.ramirez
 *
 */
public abstract class BaseService {

	@Autowired
	protected ConverterUtil convert;
	
	@Autowired
	protected MemberRepository memberRepo;
}
