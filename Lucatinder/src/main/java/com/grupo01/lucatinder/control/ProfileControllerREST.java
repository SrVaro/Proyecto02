package com.grupo01.lucatinder.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping ("/rest/profile")
public class ProfileControllerREST {

	private static final Logger logger = LoggerFactory.getLogger(ProfileControllerREST.class);
}
