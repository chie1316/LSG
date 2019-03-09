/**
 * 
 */
package com.c3.lsg.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.c3.lsg.repository.MemberRepository;

/**
 * @author archie.ramirez
 *
 */
public abstract class BaseService {

	protected static final Logger log = LoggerFactory.getLogger(BaseService.class);

	@Autowired
	protected MemberRepository memberRepo;

	@Autowired
	protected Environment env;
}
