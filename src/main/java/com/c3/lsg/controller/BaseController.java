/**
 * 
 */
package com.c3.lsg.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import com.c3.lsg.validation.InputValidator;

/**
 * @author archie.ramirez
 *
 */
public abstract class BaseController {

	protected static final Logger log = LoggerFactory.getLogger(BaseController.class);

	@Autowired
	protected Environment env;

	@Autowired
	protected InputValidator inputValidator;
}
