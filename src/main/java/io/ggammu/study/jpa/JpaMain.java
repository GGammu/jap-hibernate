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

            // member.getAddress().setCity("newCity");
            Address address1 = Address.builder().city("newCity").street(address.getStreet()).zipCode(address.getZipCode()).build();

            member.setAddress(address1);

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
