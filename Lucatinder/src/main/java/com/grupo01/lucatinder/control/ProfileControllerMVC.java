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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

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
	 * @author AL
	 * @param name
	 * @return home.html
	 * @throws Exception
	 */
	@RequestMapping("/login/{name}")
	String loginProfile(@PathVariable String name) throws Exception {
		logger.info("-- Comprobando si el usuario existe --");
		// List<Kitty> listKitty = kittyService.list();
		// model.addAttribute("kittyList", listKitty);
		return "home";
	}

	/**
	 * 
	 * @author AR
	 * @return profileForm.html
	 */
	@GetMapping("/new")
	public String addProfile(ModelMap model) {
		logger.info("-- en NEW");
		model.addAttribute("profile", new Profile());
		return "profileForm";
	}

	/**
	 * @author MC
	 * @param profile
	 * @return index.html
	 */
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String save(@ModelAttribute Profile profile) {
		logger.info("-- en SAVE");
		profileServ.addProfile(profile);
		return "redirect:/index";
	}
}
