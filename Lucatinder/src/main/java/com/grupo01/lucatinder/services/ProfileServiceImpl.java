package com.grupo01.lucatinder.services;

import java.util.Optional;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		return profileRep.save(p);
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
		
		if (lp.size() < 20) {
			for (int i = 0; i < 20 - lp.size(); i++) {
				Faker faker = new Faker();
				profileRep.save(new Profile(0,
						faker.name().firstName(),
						false,
						(int) Math.round(Math.random() * 100),
						faker.gameOfThrones().character(),
						true,
						(int) Math.round(Math.random() * 100),
						(int) Math.round(Math.random() * 100)
						));
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

}
