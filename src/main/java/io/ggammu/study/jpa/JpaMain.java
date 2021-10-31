package io.ggammu.study.jpa;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
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

            System.out.println("team");
            team.getMembers().forEach(m -> System.out.println(m.toString()));
            System.out.println("member");
            System.out.println(member.getTeam());

            em.flush();
            em.clear();

            String query = "select m.team from Member m";
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
