package com.grupo01.lucatinder.repository;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.grupo01.lucatinder.models.Profile;

@Repository
public class ProfileRepositoryCustomImpl implements ProfileRepositoryCustom {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Optional<Profile> getProfile(String name) {
		return Optional.ofNullable((em.createQuery("SELECT c FROM Country c WHERE c.name = ?", Profile.class)
				.setParameter(1, name)
				.getSingleResult()));
	}

}
