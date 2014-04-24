package fr.istic.tpjpa.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaTest {

	private EntityManager manager;

    public JpaTest(EntityManager manager) {

        this.manager = manager;

    }

    /**

     * @param args

     */

    public static void main(String[] args) {

        EntityManagerFactory factory =   

             Persistence.createEntityManagerFactory("example");

        EntityManager manager = factory.createEntityManager();

        JpaTest test = new JpaTest(manager);

        EntityTransaction tx = manager.getTransaction();

        tx.begin();

        try {

            test.createPersons();

        } catch (Exception e) {

            e.printStackTrace();

        }

        tx.commit();

        test.listPersons();

           

       manager.close();

        System.out.println(".. done");

    }

    private void createPersons() {

        int numOfPersons = manager.createQuery("Select a From Person a", Person.class).getResultList().size();

        if (numOfPersons == 0) {

            Home maison = new Home();
            maison.setAdresse("35 rue de nul part");
            maison.setIP("192.168.1.1");
            manager.persist(maison);
            
            Person per1 = new Person();
            per1.setDatenaissance("15/01/1988");
            per1.setPrenom("Jean");
            per1.setNom("Reno");

            Person per2 = new Person();
            per2.setDatenaissance("25/04/1975");
            per2.setPrenom("Martin");
            per2.setNom("Mystere");
            
            List<Home> maisons = new ArrayList<Home>();
            maisons.add(maison);
            
            per1.setResidences(maisons);
            
            List<Person> amis = new ArrayList<Person>();
            amis.add(per1);
            per2.setFriends(amis);
            
            manager.persist(per1);

            manager.persist(per2);

        }

    }

    private void listPersons() {

        List<Person> resultList = manager.createQuery("Select a From Person a", Person.class).getResultList();

        System.out.println("num of persons:" + resultList.size());

        for (Person next : resultList) {

            System.out.println("next person: " + next);

        }

    }

}


