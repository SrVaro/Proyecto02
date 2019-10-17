package com.grupo01.lucatinder.repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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
	/**
	 * @author MC
	 * @param actualUserId
	 * @param likedUserId
	 */
	@Transactional
	public void likeProfile(int actualUserId, int likedUserId) {
		
		String sql="INSERT INTO contacts(id_profile, id_profile_liked) VALUES (actualUserID,likedUserId)";
				em.createNativeQuery(sql);

	}
}
