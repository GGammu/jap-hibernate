package io.ggammu.study.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(java.lang.String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("io.ggammu.study.jpa");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Team team = new Team();
            team.setName("A team");
            em.persist(team);

            Member member = new Member();
            member.setUsername("member 1");
            member.setAge(10);
            member.setType(MemberType.ADMIN);
            member.setTeam(team);
            em.persist(member);

            Member member1 = new Member();
            member1.setUsername("member 2");
            member1.setAge(20);
            member1.setType(MemberType.ADMIN);
            member1.setTeam(team);
            em.persist(member1);

            em.flush();
            em.clear();

            String query = "select m.username from Team t join t.members m";
            List<String> resultList = em.createQuery(query, String.class)
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
