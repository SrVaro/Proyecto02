package com.grupo01.lucatinder.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grupo01.lucatinder.models.Profile;

@Controller("ControllerMVC")
@RequestMapping("/mvc/profile")
public class ProfileControllerMVC {
	
	private static final Logger logger = LoggerFactory.getLogger(ProfileControllerMVC.class);
	
	public ProfileControllerMVC() {
		
	}
	
	private int actualUserID;
/**
 * 
 * @author andres
 * @return profileForm.html
 */
	@GetMapping ("/new")
	public String addProfile(ModelMap model) {
		logger.info("-- en NEW");
		model.addAttribute("profile", new Profile());
		return "profileForm";
	}
	
}
