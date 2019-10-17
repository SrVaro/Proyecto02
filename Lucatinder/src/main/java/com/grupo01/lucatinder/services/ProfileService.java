package com.grupo01.lucatinder.services;

import java.util.Optional;
import java.util.List;

/**
 * @author MJ
 * 
 * 16/10/2019
 */

import com.grupo01.lucatinder.models.Profile;

public interface ProfileService {

	public Profile addProfile(Profile p);

	public Optional<Profile> getProfile(String name);

	public List<Profile> getProfileSelection(int actualUserId);

}
