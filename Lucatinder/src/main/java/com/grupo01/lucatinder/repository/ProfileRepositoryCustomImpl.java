package com.grupo01.lucatinder.repository;

import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import com.grupo01.lucatinder.converters.ProfileConverter;
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
		return Optional
				.ofNullable((em.createQuery("SELECT c FROM Profile c WHERE c.name = ?1", Profile.class)
				.setParameter(1, name).getSingleResult()));
	}

	/**
	 * @author MC
	 * @param int actualUserId
	 * @return List<Profile>
	 */
	public List<Profile> getProfileSelection(int actualUserId) {

		String hql = "SELECT P.* " + 
				"FROM profiles P " + 
				"WHERE P.id_profile != ? " + 
				"AND P.id_profile NOT IN ( " + 
				"	SELECT C.id_profile_liked " + 
				"	FROM contacts C " + 
				"    JOIN profiles P " + 
				"    ON P.id_profile = C.id_profile " + 
				"    WHERE P.id_profile = ?) ";
		
		
		@SuppressWarnings("unchecked")
		List<Object[]> lp = em.createNativeQuery(hql)
							.setParameter(1, actualUserId)
							.setParameter(2, actualUserId)
							.getResultList();
		
		return ProfileConverter.toProfileList(lp);
	}

	@Override
	public boolean likeProfile(int actualUserId, int likedUserId) {
		// TODO Auto-generated method stub
		return false;
	}
}
