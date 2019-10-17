package com.grupo01.lucatinder.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.grupo01.lucatinder.models.Profile;

public class ProfileRepositoryCustomImpl implements ProfileRepositoryCustom {

	private Profile profile;

	@PersistenceContext
	protected EntityManager entityManager;

	public ProfileRepositoryCustomImpl() {

	}

	/**
	 * @author MC
	 * @param actualUserId
	 * @return List<Profile>
	 */
	
	public List<Profile> getProfileSelection(int actualUserId) {

		String hql = "FROM Profile WhERE id_profile <> 'actualUserId'";
		return (List<Profile>) entityManager.createQuery(hql).getResultList();

	}
}
