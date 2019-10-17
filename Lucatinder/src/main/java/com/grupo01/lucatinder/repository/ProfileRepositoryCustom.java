package com.grupo01.lucatinder.repository;

import java.util.Optional;
import com.grupo01.lucatinder.models.Profile;
import java.util.List;

/**
 * 
 * @author AR
 *
 */
public interface ProfileRepositoryCustom {

	public Optional<Profile> getProfile(String name);

	public List<Profile> getProfileSelection(int actualUserId);

	public boolean likeProfile(int actualUserId, int likedUserId);

}
