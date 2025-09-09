package test;

import config.JPAConfig;
import entity.Users;
import jakarta.persistence.EntityManager;

public class Insert {
    public static void main(String[] args) {
        EntityManager em = JPAConfig.getEntityManager();

        try {
            em.getTransaction().begin();

            // Insert user với role = 1 (User)
            Users u1 = new Users();
            u1.setUsername("user01");
            u1.setPassword("123456");
            u1.setRole(1);
            em.persist(u1);

            Users u2 = new Users();
            u2.setUsername("user02");
            u2.setPassword("123456");
            u2.setRole(1);
            em.persist(u2);

            // Insert user với role = 2 (Admin)
            Users u3 = new Users();
            u3.setUsername("admin01");
            u3.setPassword("123456");
            u3.setRole(2);
            em.persist(u3);

            Users u4 = new Users();
            u4.setUsername("admin02");
            u4.setPassword("123456");
            u4.setRole(2);
            em.persist(u4);

            // Insert user với role = 3 (Manager)
            Users u5 = new Users();
            u5.setUsername("manager01");
            u5.setPassword("123456");
            u5.setRole(3);
            em.persist(u5);

            Users u6 = new Users();
            u6.setUsername("manager02");
            u6.setPassword("123456");
            u6.setRole(3);
            em.persist(u6);

            em.getTransaction().commit();
            System.out.println("Insert dữ liệu vào bảng users thành công!");
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
}