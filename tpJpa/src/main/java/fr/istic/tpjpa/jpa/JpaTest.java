package fr.istic.tpjpa.jpa;

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
		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("example");
		EntityManager manager = factory.createEntityManager();

		EntityTransaction tx = manager.getTransaction();
		tx.begin();

		// TODO create entity

		Person personne = new Person("Le Verge", "Pauline", "Inconnu", "pops@fr", "26 janvier 1992", "Pop's");		
		Person personne2 = new Person("Bechepois", "Corinne", "Inconnu", "coco@fr", "décembre 1992", "Coco");		

		Home home = new Home("9 rue des Bolosses", 23532, "192.168.1.1", personne);
		Home home2 = new Home("10 rue des Bolosses", 23532, "192.168.1.1", personne2);
		Home home3 = new Home("8 rue des Bolosses", 23532, "192.168.1.1", personne);
		
		
		personne.setFriends(personne2);

		
		
		manager.persist(home);
		manager.persist(home2);
		manager.persist(home3);
		manager.persist(personne);
		manager.persist(personne2);
	
		// TODO persist entity

		tx.commit();

		
		manager.close();
		// TODO run request

		System.out.println(".. done");
	}

}
