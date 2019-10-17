package com.grupo01.lucatinder.control;

import java.util.List;
import java.net.URI;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.grupo01.lucatinder.models.Profile;
import com.grupo01.lucatinder.services.ProfileService;

@RestController
@RequestMapping("/rest/profile")
public class ProfileControllerREST {

	@Autowired
	private ProfileService profileServ;

	private int actualUserID;

	private static final Logger logger = LoggerFactory.getLogger(ProfileControllerREST.class);

	/**
	 * @author MC
	 * @param model
	 * 
	 */
	@GetMapping("/home")
	public List<Profile> getProfileSelection(Model model) throws Exception {
		logger.info("-- en HOME --");
		return profileServ.getProfileSelection(actualUserID);
	}

	@GetMapping("/like/{id}")
	Boolean likeProfile(@PathVariable int id) {
		return this.profileServ.likeProfile(actualUserID, id);
	}
	
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
	
	/**
	 * 
	 * @author AR
	 */
	
	@GetMapping("/login/{name}")
	public Profile loginUser(@PathVariable String name) {
		logger.info("-- Comprobando si el usuario existe --");
		Profile p = profileServ.getProfile(name).orElseThrow(ProfileNotFoundException: : new);
		if (p != null) {
			this.actualUserID = p.getId_profile();
		}
		return p;
	}


}
