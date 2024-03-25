package application;

import domain.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Program {

	public static void main(String[] args) {
		Person p1 = new Person("Carlos Orange", "carlos@gmail.com");
		Person p2 = new Person("Bob Brown", "bob@gmail.com");
		Person p3 = new Person("Maria Green", "maria@gmail.com");
		
		EntityManagerFactory emFactory = null;
		// Instantiates an  EntityManager
		EntityManager entityManager = null;
		
		
		try {
			// Instantiates an EntityManagerFactory
			emFactory = Persistence.createEntityManagerFactory("exemplo-jpa");
			// Instantiates an  EntityManager
			entityManager = emFactory.createEntityManager();
			
			Person result = entityManager.find(Person.class, 5);
			System.out.println("Done!");
			System.out.println(result);
		} 
		catch (Exception e) {
			System.out.println("Error: "+ e.getMessage());
		} 
		finally {
			if (entityManager != null) {
				entityManager.close();				
			}
			if (emFactory != null) {
				emFactory.close();
			}
		}
	}

}
