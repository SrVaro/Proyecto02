package com.grupo01.lucatinder.services;

/**
 * @author MJ
 * 
 * 16/10/2019
 */

import com.grupo01.lucatinder.models.Profile;

public interface ProfileService {	

	public Profile addProfile(Profile p);
	
	public Profile getProfile(String name);
}
