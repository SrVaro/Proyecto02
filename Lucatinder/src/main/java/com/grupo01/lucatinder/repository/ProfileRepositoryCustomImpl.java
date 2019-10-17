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
	 * @param int actualUserId
	 * @return List<Profile>
	 */
	public List<Profile> getProfileSelection(int actualUserId) {

		String hql = "SELECT P.name" + "FROM profiles P" + "WHERE id_profile NOT IN ?" + "AND id_profile != ("
				+ "	SELECT C.id_profile_liked" + "	FROM contacts C" + "    JOIN profiles P"
				+ "    ON P.id_profile = C.id_profile)";

		return em.createNativeQuery(hql).setParameter(1, actualUserId).getResultList();

	}

	@Override
	public boolean likeProfile(int actualUserId, int likedUserId) {
		// TODO Auto-generated method stub
		return false;
	}

	
	/**
	 * @author AR
	 * 
	 */
	public List<Profile> getContactList(int actualUserId) {

		String hql = "SELECT P.* FROM profiles P" + "WHERE P.id_profile IN ( "
				+ "	SELECT C.id_profile_liked FROM profiles P" + "	JOIN contacts C\r\n"
				+ "	ON C.id_profile = P.id_profile" + "	WHERE P.id_profile = ?)";

		return em.createNativeQuery(hql).setParameter(1, actualUserId).getResultList();
	}
}
