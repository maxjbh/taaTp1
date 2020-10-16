package jpa;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;


public class JpaTest {

	private static EntityManager manager;
	
	/**
     * @param args
     */
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("dev");
        manager = factory.createEntityManager();

        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        try {
        	createObjects();
        } catch (Exception e) {
            e.printStackTrace();
        }
        tx.commit();
        
        listCards();
        
        manager.close();
        factory.close();
    }
    public static void createObjects() {
    	Carte c1 = new Carte();
        c1.setLibelle("first card");
        c1.setDateButoir(Date.valueOf("2013-09-29"));
        c1.setUser("Max");
        c1.setTimeNeeded(120);
        HashSet<Tag> tags = new HashSet<Tag>();
        tags.add(new Tag("hard work"));
        tags.add(new Tag("urgent"));
        c1.setTags(tags);
        manager.persist(c1);
        
        Carte c2 = new Carte();
        c2.setLibelle("second card");
        c2.setDateButoir(Date.valueOf("2020-09-29"));
        c2.setUser("Jacob");
        c2.setTimeNeeded(120);
        HashSet<Tag> tags2 = new HashSet<Tag>();
        tags2.add(new Tag("eee"));
        tags2.add(new Tag("rrr"));
        c2.setTags(tags2);
        manager.persist(c2);
        
        /*
        Table t1 = new Table();
    	t1.setProjectName("a project");
    	ArrayList<Carte> fiches = new ArrayList<Carte>();
    	fiches.add(c1);
    	fiches.add(c2);
    	t1.setFiches(fiches);
    	manager.persist(t1);
    	*/
    }
    private static void listCards() {
        List<Carte> resultList = manager.createQuery("Select a From Carte a", Carte.class).getResultList();
        System.out.println("num of cards:" + resultList.size());
        for (Carte next : resultList) {
            System.out.println("next card: " + next);
        }
    }


}

