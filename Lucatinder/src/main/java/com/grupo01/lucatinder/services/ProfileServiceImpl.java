package com.grupo01.lucatinder.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.grupo01.lucatinder.models.Profile;
import com.grupo01.lucatinder.repository.ProfileRepository;



@Repository
public class ProfileServiceImpl implements ProfileService{

	private static final Logger logger = LoggerFactory.getLogger(ProfileServiceImpl.class);
	
	@Autowired
	private ProfileRepository profileRep;

	ProfileServiceImpl() {

	}

	@Override
	public Profile addProfile(Profile p) {
		return profileRep.save(p);
	}

	@Override
	public Profile getProfile(String name) {
		return null;
	}
	
	

}
