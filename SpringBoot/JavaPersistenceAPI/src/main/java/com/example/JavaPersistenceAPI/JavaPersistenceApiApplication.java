package com.example.JavaPersistenceAPI;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class JavaPersistenceApiApplication {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("BookstoreDBUnit");
		EntityManager entityManager = factory.createEntityManager();

		try {
			entityManager.getTransaction().begin();

			//CREATE operation

			Book firstbook = new Book("the java", "brooke", 113f);
			Book secondbook = new Book("the python", "john", 134f);
			Book thridbook = new Book();
			entityManager.persist(firstbook);
			entityManager.persist(secondbook);
			entityManager.persist(thridbook);

			//READ OPERATION

			List<Book> books=entityManager.createQuery("Select b from Book b",Book.class).getResultList();
			System.out.println(books);

			Book book1=entityManager.find(Book.class,222);
			System.out.println(book1);

			Book book2=entityManager.find(Book.class,225);
			System.out.println(book2);

			//UPDATE
			book1.setPrice((float) 23.54);
			book2.setTitle("new title set");
//merges the changes made to the original values tht exist already in the db and updates
			entityManager.merge(book1);
			entityManager.merge(book2);

			System.out.println(books);

			//DELETE
			if(book1!=null){
				entityManager.remove(book1);
			}



		} catch (Exception ex) {
			SpringApplication.run(JavaPersistenceApiApplication.class, args);
		}
		finally {
			entityManager.getTransaction().commit();
			entityManager.close();
			factory.close();
		}

	}
}