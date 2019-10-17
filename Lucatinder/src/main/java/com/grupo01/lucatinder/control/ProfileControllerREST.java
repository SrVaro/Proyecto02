package com.grupo01.lucatinder.control;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.grupo01.lucatinder.models.Profile;
import com.grupo01.lucatinder.services.ProfileService;

@RestController
@RequestMapping("/rest/profile")
public class ProfileControllerREST {

	private static final Logger logger = LoggerFactory.getLogger(ProfileControllerREST.class);

/**
 * @author MJ
 */
	
	@PostMapping
	public ResponseEntity<?> addProfile(@RequestBody Profile profile) {
		Profile result = this.profileServ.addProfile(profile);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(result.getId_profile())
				.toUri();
		
		return ResponseEntity.created(location).build();
}
}
