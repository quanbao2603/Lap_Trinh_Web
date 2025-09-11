package dao;

import config.JPAConfig;
import entity.UserProfile;
import jakarta.persistence.*;

public class ProfileDAO {
	public UserProfile getById(int id) {
        EntityManager em = JPAConfig.getEntityManagerFactory().createEntityManager();
        return em.find(UserProfile.class, id);
    }

    public void saveOrUpdate(UserProfile profile) {
        EntityManager em = JPAConfig.getEntityManagerFactory().createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (profile.getId() == 0) {
                em.persist(profile);
            } else {
                em.merge(profile);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx.isActive()) tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
