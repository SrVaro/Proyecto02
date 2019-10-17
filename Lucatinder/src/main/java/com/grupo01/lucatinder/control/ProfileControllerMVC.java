package com.grupo01.lucatinder.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.grupo01.lucatinder.services.ProfileService;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.grupo01.lucatinder.models.Profile;

@Controller("ControllerMVC")
@RequestMapping("/mvc/profile")
public class ProfileControllerMVC {

	private static final Logger logger = LoggerFactory.getLogger(ProfileControllerMVC.class);
	
	private int actualUserID;

	@Autowired
	private ProfileService profileServ;

	public ProfileControllerMVC() {

	}

	/**
	 * @author varo
	 * @param name
	 * @return home.html
	 * @throws Exception
	 */
	@RequestMapping("/login/{name}")
	String loginProfile(@PathVariable String name) throws Exception {
		logger.info("-- Comprobando si el usuario existe --");
		//List<Kitty> listKitty = kittyService.list();
		//model.addAttribute("kittyList", listKitty);
		return "home";
	}
	
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
