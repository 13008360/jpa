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

		Home home = new Home("9 rue des Bolosses", 23532, "192.168.1.1", null);
		Person personne = new Person("Maboule", "Docteur", "Masculin", "dr.maboule@cliniquedelasavoie.fr", "26 janvier 1992", "Le Maboule");		
		manager.persist(home);
		manager.persist(personne);
		
		// TODO persist entity

		tx.commit();

		
		manager.close();
		// TODO run request

		System.out.println(".. done");
	}

}
