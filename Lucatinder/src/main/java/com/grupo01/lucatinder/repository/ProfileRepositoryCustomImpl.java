package com.grupo01.lucatinder.repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.grupo01.lucatinder.models.Profile;

/**
 * 
 * @author AR
 *
 */
@Repository
public class ProfileRepositoryCustomImpl implements ProfileRepositoryCustom {

	private Profile profile;
	@PersistenceContext
	private EntityManager em;

	/**
	 * @author AL
	 */
	@Override
	public Optional<Profile> getProfile(String name) {
		return Optional.ofNullable((em.createQuery("SELECT c FROM Profile c WHERE c.name = ?1", Profile.class)
				.setParameter(1, name).getSingleResult()));
	}

	/**
	 * @author MC
	 * @param actualUserId
	 * @return List<Profile>
	 */

	public List<Profile> getProfileSelection(int actualUserId) {

		String hql = "FROM Profile WhERE id_profile <> '" + actualUserId + "'";
		return (List<Profile>) em.createQuery(hql).getResultList();

	}
}
