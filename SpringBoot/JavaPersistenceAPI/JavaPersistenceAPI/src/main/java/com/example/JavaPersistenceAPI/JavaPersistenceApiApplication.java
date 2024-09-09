package com.example.JavaPersistenceAPI;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
public class JavaPersistenceApiApplication {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BookstoreDBUnit");
		EntityManager entityManager = factory.createEntityManager();

		try {
			entityManager.getTransaction().begin();
			Book firstbook = new Book("the java", "brooke", 113f);
			Book secondbook = new Book("the python", "john", 134f);
			Book thridbook = new Book();
			entityManager.persist(firstbook);
			entityManager.persist(secondbook);
			entityManager.persist(thridbook);

		} catch (Exception ex) {
			SpringApplication.run(JavaPersistenceApiApplication.class, args);
		}

	}
}