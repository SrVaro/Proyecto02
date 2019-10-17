package com.grupo01.lucatinder.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.grupo01.lucatinder.models.Profile;
import com.grupo01.lucatinder.repository.ProfileRepository;



@Repository
public class ProfileServiceImpl implements ProfileService{

	private static final Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);
	
	private ProfileRepository profileRep;

	ProfileServiceImpl() {

	}

	@Override
	public void addProfile(Profile p) {
		profileRep.save(p);
	}

}
