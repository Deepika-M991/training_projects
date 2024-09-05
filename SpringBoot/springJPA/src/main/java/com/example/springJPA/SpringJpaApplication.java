package com.example.springJPA;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaApplication {

	public static void main(String[] args) {

		EntityManagerFactory factory= Persistence.createEntityManagerFactory("EmployeeDBUnit");
		EntityManager entityManager= factory.createEntityManager();

		entityManager.getTransaction().begin();
		Employee firstEmp=new Employee(1121,"peter","holland","Manager",12000);
		Employee secondemp=new Employee(1141,"bruce","Brenner","analyst",9000);

		entityManager.persist(firstEmp);
		entityManager.persist(secondemp);

		entityManager.getTransaction().commit();
		entityManager.close();
		factory.close();
//
//		SpringApplication.run(SpringJpaApplication.class, args);
	}

}
