package com.grupo01.lucatinder.services;

import java.util.Optional;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.grupo01.lucatinder.models.Profile;
import com.grupo01.lucatinder.repository.ProfileRepository;

@Repository
public class ProfileServiceImpl implements ProfileService {

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
		return profileRep.getProfileSelection(actualUserId);
	}

	@Override
	public boolean likeProfile(int actualUserId, int likedUserId) {
		return profileRep.likeProfile(actualUserId, likedUserId);
	}

	@Override
	public boolean dislikeProfile(int actualUserID, int dislikedUserId) {
		return profileRep.dislikeProfile(actualUserID, dislikedUserId);
	}

	public List<Profile> getContactList(int actualUserId) {
		return profileRep.getContactList(actualUserId);
	}

}
