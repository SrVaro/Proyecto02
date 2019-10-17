package com.grupo01.lucatinder.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.grupo01.lucatinder.services.ProfileService;

@RestController
@RequestMapping ("/rest/profile")
public class ProfileControllerREST {
	
	@SuppressWarnings("serial")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	class ProfileNotFoundException extends RuntimeException {

		public ProfileNotFoundException() {
			super("User does not exist");
		}
	}

	private static final Logger logger = LoggerFactory.getLogger(ProfileControllerREST.class);

	private int actualUserID;
	
	@Autowired
	private ProfileService profileServ;

	public ProfileControllerREST() {
	}

  
}
