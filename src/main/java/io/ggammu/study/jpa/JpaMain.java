package io.ggammu.study.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import org.hibernate.Hibernate;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("io.ggammu.study.jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Address address = Address.builder().city("city").street("street").zipCode("zip").build();

            Member member = new Member();
            member.setUsername("hello");
            member.setAddress(address);
            em.persist(member);

            Member member1 = new Member();
            member1.setUsername("hello1");
            member1.setAddress(address);
            em.persist(member1);

            member.getAddress().setCity("newCity");

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
