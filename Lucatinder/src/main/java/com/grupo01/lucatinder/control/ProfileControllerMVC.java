package com.grupo01.lucatinder.control;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.grupo01.lucatinder.services.ProfileService;
import org.springframework.ui.Model;
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

	@RequestMapping("/")
	String index(Model model) {
		return "index";
	}

	/**
	 * @author AL
	 * @param name
	 * @return login.html
	 * @throws Exception
	 */
	@GetMapping("/login")
	String loginTemplate(Model model) {
		logger.info("-- Comprobando si el usuario existe --");
		model.addAttribute("profile", new Profile());
		return "login";
	}

	/**
	 * @author AL
	 * @param name
	 * @return home.html
	 * @throws Exception
	 */
	@PostMapping("/login")
	String loginProfile(@ModelAttribute Profile profile) throws Exception {
		logger.info("-- Comprobando si el usuario existe --");
		String link = "index";
		Profile p = profileServ.getProfile(profile.getName()).get();
		if (p != null) {
			link = "redirect:/mvc/profile/home";
			this.actualUserID = p.getId_profile();
		}
		return link;
	}

	@RequestMapping("/home")
	public String getProfileSelection(ModelMap model) throws Exception {
		logger.info("-- en HOME --");
		model.addAttribute("profilesList", profileServ.getProfileSelection(actualUserID));
		return "home";
	}

	/**
	 * 
	 * @author AR
	 * @return profileForm.html
	 */
	@GetMapping("/new")
	public String addProfile(ModelMap model) {
		logger.info("-- Creando un nuevo usuario --");
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
		this.actualUserID = profileServ.addProfile(profile).getId_profile();
		return "redirect:/mvc/profile/home";
	}

	/**
	 * @author AR
	 * @return home.html
	 */
	@RequestMapping(value = "/like", method = RequestMethod.GET)
	public String likeProfile(HttpServletRequest request) {
		logger.info("-- en LIKE");
		profileServ.likeProfile(actualUserID, Integer.parseInt(request.getParameter("id")));
		return "redirect:/mvc/profile/home";
	}

	/**
	 * @author MJ
	 * @param dislike
	 * @return home.html
	 */
	@RequestMapping(value = "/dislike", method = RequestMethod.GET)
	public String dislikeProfile(HttpServletRequest request) {
		logger.info("-- en DISLIKE");
		profileServ.dislikeProfile(actualUserID, Integer.parseInt(request.getParameter("id")));
		return "redirect:/mvc/profile/home";

	}

	/**
	 * @author MC
	 * @param model
	 * @return contacts.html
	 * @throws Exception
	 */

	@RequestMapping(value = "/contacts", method = RequestMethod.GET)
	public String getContactList(Model model) throws Exception {
		List<Profile> listcontact = profileServ.getContactList(actualUserID);
		model.addAttribute("listContact", listcontact);
		return "contacts";
	}
}
