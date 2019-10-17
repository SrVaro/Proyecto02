package com.grupo01.lucatinder.control;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.grupo01.lucatinder.services.ProfileService;

@Controller("ControllerMVC")
@RequestMapping("/mvc/profile")
public class ProfileControllerMVC {

	private static final Logger logger = LoggerFactory.getLogger(ProfileControllerMVC.class);

	@Autowired
	private ProfileService profileServ;

	public ProfileControllerMVC() {

	}

	@RequestMapping("/login/{name}")
	String loginProfile(@PathVariable String name) throws Exception {
		logger.info("-- Comprobando si el usuario existe --");
		List<Kitty> listKitty = kittyService.list();
		model.addAttribute("kittyList", listKitty);
		return "index";
	}

}
