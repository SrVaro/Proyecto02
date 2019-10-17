package com.grupo01.lucatinder.repository;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import com.grupo01.lucatinder.converters.ProfileConverter;
import org.springframework.transaction.annotation.Transactional;
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
	@SuppressWarnings("unchecked")
	public List<Profile> getProfileSelection(int actualUserId) {

		String hql = "SELECT P.* " + "FROM profiles P " + "WHERE P.id_profile != ? " + "AND P.id_profile NOT IN ( "
				+ "	SELECT C.id_profile_liked " + "	FROM contacts C " + "    JOIN profiles P "
				+ "    ON P.id_profile = C.id_profile " + "    WHERE P.id_profile = ?) ";

		List<Object[]> lp = em.createNativeQuery(hql).setParameter(1, actualUserId).setParameter(2, actualUserId)
				.getResultList();

		return ProfileConverter.toProfileList(lp);
	}

	/**
	 * @author AR
	 * 
	 */
	@SuppressWarnings("unchecked")
	public List<Profile> getContactList(int actualUserId) {

		String hql = "SELECT P.* FROM profiles P" + "WHERE P.id_profile IN ( "
				+ "	SELECT C.id_profile_liked FROM profiles P" + "	JOIN contacts C\r\n"
				+ "	ON C.id_profile = P.id_profile" + "	WHERE P.id_profile = ?)";

		return em.createNativeQuery(hql).setParameter(1, actualUserId).getResultList();
	}

	/**
	 * @author MJ
	 */
	@Override
	public boolean dislikeProfile(int actualUserId, int dislikedUserId) {

		boolean sucess = false;
		int n;

		String hql = "INSERT INTO discards(id_discard, id_profile, id_profile_disliked) VALUES (?, ?)";
		n = em.createNativeQuery(hql).setParameter(1, actualUserId).setParameter(2, dislikedUserId).executeUpdate();

		if (n > 0)
			sucess = true;
		return sucess;
	}

	/**
	 *  @author MC
	 */
	public boolean likeProfile(int actualUserId, int likedUserId) {

		boolean sucess = false;
		int n;
		String sql = "INSERT INTO contacts(id_profile, id_profile_liked) VALUES (?,?)";

		n = em.createNativeQuery(sql).setParameter(1, actualUserId).setParameter(2, likedUserId).executeUpdate();
		if (n > 0) {
			sucess = true;

		}

		return sucess;
	}

}
