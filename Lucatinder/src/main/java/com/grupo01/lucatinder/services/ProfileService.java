package com.grupo01.lucatinder.services;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

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

	public List<Profile> getDiscardList(int actualUserId);

	public void updateProfile(Profile profile);

	public Optional<Profile> getProfileId(int id);

	public List<Profile> getMatchesList(int actualUserId);
	public BCryptPasswordEncoder codificadorClave();
	

}
