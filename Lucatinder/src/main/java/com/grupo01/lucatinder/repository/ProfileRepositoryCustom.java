package com.grupo01.lucatinder.repository;

import java.util.List;

import com.grupo01.lucatinder.models.Profile;

/**
 * 
 * @author AR
 *
 */
public interface ProfileRepositoryCustom {

	public List<Profile> getProfileSelection(int actualUserId);
}
