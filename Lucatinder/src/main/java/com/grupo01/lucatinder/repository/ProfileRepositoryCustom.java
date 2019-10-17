package com.grupo01.lucatinder.repository;

import java.util.Optional;

import com.grupo01.lucatinder.models.Profile;

public interface ProfileRepositoryCustom {
	
	public Optional<Profile> getProfile(String name);

}
