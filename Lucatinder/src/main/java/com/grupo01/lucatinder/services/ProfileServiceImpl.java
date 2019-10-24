package com.grupo01.lucatinder.services;

import java.util.Optional;
import java.util.Random;
import java.io.IOException;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.grupo01.lucatinder.models.Profile;
import com.grupo01.lucatinder.repository.ProfileRepository;

@Repository
public class ProfileServiceImpl implements ProfileService {

	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);

	@Autowired
	private ProfileRepository profileRep;

	ProfileServiceImpl() {

	}

	@Override
	public Profile addProfile(Profile p) {
		try {
			p = profileRep.save(p);
		} catch (Exception ex) {
			p = null;
		}
		return p;
	}

	/**
	 * @author AL
	 */
	@Override
	public Optional<Profile> getProfile(String name) {
		return profileRep.getProfile(name);
	}

	@Override
	public List<Profile> getProfileSelection(int actualUserId) {

		List<Profile> lp = profileRep.getProfileSelection(actualUserId);

		if (profileRep.findAll().size() < 20) {
			for (int i = 0; i < 20 - lp.size(); i++) {
				Faker faker = new Faker();
				profileRep.save(new Profile(0, faker.name().firstName(), new Random().nextBoolean(),
						(int) Math.round(Math.random() * 100), faker.gameOfThrones().character(), true,
						(int) Math.round(Math.random() * 100), (int) Math.round(Math.random() * 100), this.getImage()));
			}
		}

		return lp;
	}

	@Override
	public boolean likeProfile(int actualUserId, int likedUserId) {
		return profileRep.likeProfile(actualUserId, likedUserId);
	}

	@Override
	public boolean dislikeProfile(int actualUserID, int dislikedUserId) {
		return profileRep.dislikeProfile(actualUserID, dislikedUserId);
	}

	@Override
	public List<Profile> getContactList(int actualUserId) {
		return profileRep.getContactList(actualUserId);
	}

	@Override
	public String getImage() {

		String photo = "";

		RestTemplate restTemplate = new RestTemplate();

		HttpHeaders headers = new HttpHeaders();

		headers.add("x-api-key", "69521f5d-1f9a-4e1c-9f47-2cdc5caea9dc");

		HttpEntity<String> entity = new HttpEntity<>("body", headers);

		ResponseEntity<String> response = restTemplate.exchange("https://api.thecatapi.com/v1/images/search",
				HttpMethod.GET, entity, String.class);

		ObjectMapper mapper = new ObjectMapper();

		try {

			JsonNode root = mapper.readTree(response.getBody().substring(1, response.getBody().length() - 1));

			photo = root.get("url").asText();

		} catch (IOException e) {
			e.printStackTrace();
		}

		return photo;
	}
	
	@Override
	public void deleteProfile(int id) {
		profileRep.deleteById(id);
	}
	

	@Override
	public List<Profile> getDiscardList(int actualUserId) {
		return profileRep.getDiscardList(actualUserId);
	}

	@Override
	public void updateProfile(Profile profile) {
		profileRep.save(profile);
	}

	@Override
	public Optional<Profile> getProfileId(int id) {
		return profileRep.findById(id);
	}
	
	@Override
	public List<Profile> getMatchesList(int actualUserId) {
		return profileRep.getMatchesList(actualUserId);
	}
}
