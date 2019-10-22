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

	public boolean likeProfile(int actualUserId, int likedUserId);

	public boolean dislikeProfile(int actualUserID, int dislikedUserId);

	public List<Profile> getContactList(int actualUserId);

	String getImage();

	public void deleteProfile(int id);
	
	public Optional<Profile> showProfile (int id);


}
