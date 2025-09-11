package config;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAConfig {
	private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("dataSource");

    public static EntityManagerFactory getEntityManagerFactory() {
        return emf;
    }
}
