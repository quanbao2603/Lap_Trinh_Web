package dao;

import config.JPAConfig;
import dao.interfaces.UsersDAO;
import entity.Users;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;

public class UsersDAOImpl implements UsersDAO {
	@Override
	public Users findByUsernameAndPassword(String username, String password) {
		EntityManager em = JPAConfig.getEntityManager();
		try {
			String jpql = "SELECT u FROM Users u WHERE u.username = :username AND u.password = :password";
			TypedQuery<Users> query = em.createQuery(jpql, Users.class);
			query.setParameter("username", username);
			query.setParameter("password", password);
			return query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		} finally {
			em.close();
		}
	}
}