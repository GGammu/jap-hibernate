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
            Team team = new Team();
            team.setName("A");
            em.persist(team);

            Member member = new Member();
            member.setUsername("native");
            member.setTeam(team);
            member.setAge(10);
            em.persist(member);

            em.flush();
            em.clear();

            List<MemberDto> members = em.createQuery("select new io.ggammu.study.jpa.MemberDto(m.username, m.age) from Member m", MemberDto.class).getResultList();

            MemberDto member1 = members.get(0);
            System.out.println(member1.getName());
            System.out.println(member1.getAge());

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
