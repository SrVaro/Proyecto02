package com.grupo01.lucatinder.control;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
