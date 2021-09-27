package io.ggammu.study.jpa;

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
            Member member1 = new Member();
            member1.setUsername("Hello");
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("Hello");

            em.persist(member2);

            em.flush();
            em.clear();

//            Member findMember1 = em.find(Member.class, member1.getId());
//            Member findMember2 = em.getReference(Member.class, member2.getId());

//            System.out.println("m1 == m2 " + (findMember1.getClass() == findMember2.getClass()));
//            System.out.println("m1 " + (findMember1 instanceof Member));
//            System.out.println("m2 " + (findMember2 instanceof Member));

            Member refMember1 = em.getReference(Member.class, member1.getId());
            System.out.println("refMember1 " + refMember1.getClass());

//            em.detach(refMember1);
//            em.clear();
//            em.close();

            Hibernate.initialize(refMember1);
            System.out.println("is Loaded " + emf.getPersistenceUnitUtil().isLoaded(refMember1));

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
