package com.grupo01.lucatinder.control;

import java.util.ArrayList;
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

import com.grupo01.lucatinder.exception.ProfileNotFoundException;
import com.grupo01.lucatinder.models.Profile;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
	 * 
	 *                   Metodo que te dirige a la pagina login
	 */
	@GetMapping("/login")
	String loginTemplate(Model model) {
		model.addAttribute("profile", new Profile());
		return "login";
	}

	/**
	 * @author AL
	 * @param name
	 * @return home.html
	 * @throws Exception
	 * 
	 *                   Metodo que comprueba si el usuario existe y te logea
	 */
	@PostMapping("/login")
	String loginProfile(@ModelAttribute Profile profile) throws Exception {
		logger.info("-- Comprobando si el usuario existe --");
		String link = "login";
		Profile p = profileServ.getProfile(profile.getName()).orElse(null);
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

	@RequestMapping("/myProfile")
	public String getMyProfile(ModelMap model) throws Exception {
		logger.info("-- en MY PERFIL --");
		model.addAttribute("profile", profileServ.getProfileId(actualUserID).get());
		return "myProfile";
	}

	/**
	 * 
	 * @author AR
	 * @return profileForm.html
	 */
	@GetMapping("/new")
	public String addProfile(ModelMap model) {
		logger.info("-- Creando un nuevo usuario --");
		List<String> p = new ArrayList<>();
		p.add("fadsuk");
		p.add("fadsuk");
		model.addAttribute("categorys", p);
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
		Profile p = profileServ.addProfile(profile);
		if (p != null) {
			this.actualUserID = p.getId_profile();
			return "redirect:/mvc/profile/home";
		} else {
			return "redirect:/mvc/profile/new";
		}
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
		return "profileList";
	}

	/**
	 * @author MJ
	 * @param delete
	 * @return index.html
	 */

	@RequestMapping(value = "/delete", method = RequestMethod.GET)
	public String deleteProfile() {
		logger.info("-- en DELETE");
		profileServ.deleteProfile(actualUserID);
		return "redirect:/";
	}

	/**
	 * 
	 */
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String updateProfile(ModelMap model) {
		logger.info("-- en update");
		model.addAttribute("profile", profileServ.getProfileId(actualUserID));
		return "profileForm";
	}

	@RequestMapping(value = "/discards", method = RequestMethod.GET)
	public String getDiscardList(Model model) throws Exception {
		List<Profile> listDiscards = profileServ.getDiscardList(actualUserID);
		model.addAttribute("listDiscards", listDiscards);
		return "profileList";
	}

	/**
	 * @author MJ
	 * @param show
	 * @return myProfile.html
	 */

	@RequestMapping(value = "/profile/{id}/", method = RequestMethod.GET)
	public String showProfile() {
		logger.info("-- en SHOW");
		profileServ.getProfileId(actualUserID);
		return "myProfile";
	}

	/**
	 * @author MC
	 * @param model
	 */

	@RequestMapping(value = "/matches", method = RequestMethod.GET)
	public String getMatchesList(Model model) throws Exception {
		List<Profile> listMatches = profileServ.getMatchesList(actualUserID);
		model.addAttribute("listMatches", listMatches);
		return "profileList";
	}

}
