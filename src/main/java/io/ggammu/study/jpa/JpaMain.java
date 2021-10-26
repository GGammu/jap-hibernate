package io.ggammu.study.jpa;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import org.hibernate.Hibernate;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("io.ggammu.study.jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            for (int i = 0; i < 100; i++) {
                Member member = new Member();
                member.setUsername("test");
                member.setAge(i);
                em.persist(member);
            }

            em.flush();
            em.clear();

            List<Member> resultList = em.createQuery("select  m from Member m order by m.age desc", Member.class)
                            .setFirstResult(0)
                            .setMaxResults(10)
                            .getResultList();

            resultList.forEach(m -> System.out.println(m.toString()));

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
